/*******************************************************************************
 * Copyright (c) 2010, Petr Kalafatic (gemini@kalafatic.eu).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU GPL Version 3 
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.txt  
 * 
 * Contributors:
 *     Petr Kalafatic - initial API and implementation
 ******************************************************************************/
package eu.kalafatic.explorer.view.editors.pages;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.zest.core.viewers.AbstractZoomableViewer;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.viewers.IZoomableWorkbenchPart;
import org.eclipse.zest.core.widgets.Graph;

import eu.kalafatic.explorer.controller.adapters.NodeGraphAdapter;
import eu.kalafatic.explorer.controller.adapters.NodeGraphContentAdapter;
import eu.kalafatic.explorer.controller.model.ExplorerModelManager;
import eu.kalafatic.explorer.model.explorer.Node;
import eu.kalafatic.explorer.view.editors.ExplorerEditor;
import eu.kalafatic.explorer.view.hack.FilterContributionItem;
import eu.kalafatic.explorer.view.hack.LayoutContributionItem;
import eu.kalafatic.explorer.view.hack.SubtreeContributionItem;
import eu.kalafatic.explorer.view.hack.ZoomContributionViewItem;
import eu.kalafatic.explorer.view.hack.ZoomManager;
import eu.kalafatic.explorer.view.lib.constants.ELayouts;
import eu.kalafatic.explorer.view.pages.AProjectPage;
import eu.kalafatic.explorer.view.providers.ZestLabelProvider;
import eu.kalafatic.explorer.view.providers.ZestNodeContentProvider;
import eu.kalafatic.utils.interfaces.IViewer;

/**
 * The Class class GraphPage.
 * @author Petr Kalafatic
 * @version 3.0.0
 * @project Gemini
 */
public class GraphPage extends AProjectPage implements IPartListener2, IViewer, IZoomableWorkbenchPart {

	/** The Constant ID. */
	public static final String ID = "eu.kalafatic.explorer.view.pages.GraphPage";

	/** The zoom item. */
	private ZoomContributionViewItem zoomItem;

	/** The layout item. */
	private LayoutContributionItem layoutItem;

	/** The filter item. */
	private FilterContributionItem filterItem;

	/** The subtree filter. */
	private SubtreeContributionItem subtreeFilter;

	/** The zoom manager. */
	private ZoomManager zoomManager;

	/** The viewer. */
	private GraphViewer viewer;

	/** The input map. */
	private HashMap<String, Object> inputMap;

	/** The select all action. */
	private Action addItemAction, deleteItemAction, selectAllAction;

	/** The tool bar manager. */
	private IToolBarManager toolBarManager;

	/** The action bars. */
	private IActionBars actionBars;

	/** The combo. */
	private Combo combo;

	/** The header form. */
	private Form headerForm;

	/** The lock. */
	private final ReentrantLock lock = new ReentrantLock(true);

	/** The adapter. */
	private Adapter adapter;

	/** The content adapter. */
	private Adapter contentAdapter;

	/**
	 * Instantiates a new graph page.
	 * @param editor the editor
	 * @param form the form
	 * @param index the index
	 */
	public GraphPage(ExplorerEditor editor, Form form, int index) {
		super(editor, ID, "Graph", index, Collections.EMPTY_MAP);
		this.headerForm = form;

	}

	// ---------------------------------------------------------------
	// ---------------------------------------------------------------

	/* (non-Javadoc)
	 * @see eu.kalafatic.explorer.view.pages.AProjectPage#createFormContent(org.eclipse.ui.forms.IManagedForm)
	 */
	@Override
	protected void createFormContent(IManagedForm managedForm) {
		super.createFormContent(managedForm);

		viewer = new GraphViewer(form.getBody(), SWT.NONE);
		viewer.setContentProvider(new ZestNodeContentProvider(viewer));
		viewer.setLabelProvider(new ZestLabelProvider(viewer));

		final Graph graph = viewer.getGraphControl();
		graph.setLayout(new GridLayout(1, false));

		graph.setLayoutData(new GridData(GridData.FILL_BOTH));
		graph.addControlListener(new ControlListener() {

			@Override
			public void controlResized(ControlEvent e) {
				int height = form.getBody().getBounds().height;
				GridData layoutData = (GridData) graph.getLayoutData();
				layoutData.heightHint = height / 2;
				graph.layout(true, true);
			}

			@Override
			public void controlMoved(ControlEvent e) {
				// TODO Auto-generated method stub

			}
		});

		zoomManager = new ZoomManager(graph.getRootLayer(), graph.getViewport());
		// zoomManager.setZoomAnimationStyle(0);

		inputMap = new HashMap<String, Object>();
		EMap<String, Node> children = ExplorerModelManager.getInstance().getModel().getChildren();
		inputMap.put("Net", children);

		viewer.setInput(inputMap);

		actionBars = getEditor().getEditorSite().getActionBars();

		createActions();
		createMenu();
		hookContextMenu();
		createToolbar();
		initAdapters();

		initContributionItems();

		getSite().setSelectionProvider(viewer);
		getSite().getWorkbenchWindow().getPartService().addPartListener(this);

		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				form.getBody().layout(true, true);
			}
		});
	}

	// ---------------------------------------------------------------

	/**
	 * Inits the adapters.
	 */
	private void initAdapters() {
		contentAdapter = new NodeGraphContentAdapter(viewer, lock);
		adapter = new NodeGraphAdapter(viewer, lock, contentAdapter);
		ExplorerModelManager.getInstance().getModel().eAdapters().add(adapter);

		initAdapters(ExplorerModelManager.getInstance().getModel().getChildren().values());
	}

	// ---------------------------------------------------------------

	/* (non-Javadoc)
	 * @see eu.kalafatic.utils.interfaces.IViewer#initAdapters(java.util.Collection)
	 */
	@Override
	public void initAdapters(Collection<?> collection) {

		for (Object object : collection) {
			Node node = (Node) object;

			node.eAdapters().add(adapter);
			node.eAdapters().add(contentAdapter);

			initAdapters(node.getChildren().values());
		}
	}

	// ---------------------------------------------------------------

	/**
	 * Inits the contribution items.
	 */
	private void initContributionItems() {
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				// filterItem.getCombo().select(0);
				// layoutItem.getCombo().select(0);
				// zoomItem.getCombo().select(0);
				// viewer.setLayoutAlgorithm(ELayouts.RADIAL.algorithm, true);

				viewer.setLayoutAlgorithm(ELayouts.SPRING.algorithm, true);
				viewer.getGraphControl().layout(true, true);

				// initListeners();
				// initAdapters(null);
			}
		});
	}

	// ---------------------------------------------------------------

	/**
	 * Creates the toolbar.
	 */
	private void createToolbar() {

		IToolBarManager toolBarManager = getEditorSite().getActionBars().getToolBarManager();

		IActionBars bars = getEditorSite().getActionBars();

		// subtreeFilter = new SubtreeContributionItem(viewer, inputMap);
		// filterItem = new FilterContributionItem(viewer, inputMap,
		// subtreeFilter);
		//
		// layoutItem = new LayoutContributionItem(viewer.getGraphControl());
		// zoomItem = new ZoomContributionViewItem(this, zoomManager);
		//
		// bars.getMenuManager().add(filterItem);
		// bars.getMenuManager().add(subtreeFilter);
		// bars.getMenuManager().add(layoutItem);
		// bars.getMenuManager().add(zoomItem);
		//
		// toolBarManager.add(filterItem);
		// toolBarManager.add(subtreeFilter);
		// toolBarManager.add(layoutItem);
		// toolBarManager.add(zoomItem);
	}

	// ---------------------------------------------------------------

	/**
	 * Creates the actions.
	 */
	public void createActions() {
		addItemAction = new Action("Add...") {
			@Override
			public void run() {
				System.err.println(" addItem();");

			}
		};
		// addItemAction.setImageDescriptor(getImageDescriptor("add.gif"));

		deleteItemAction = new Action("Delete") {
			@Override
			public void run() {
				System.err.println(" deleteItem();");

			}
		};
		// deleteItemAction.setImageDescriptor(getImageDescriptor("delete.gif"));

		selectAllAction = new Action("Select All") {
			@Override
			public void run() {
				System.err.println("  selectAll();");

			}
		};

		// Add selection listener.
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				// updateActionEnablement();
			}
		});
	}

	// ---------------------------------------------------------------

	/**
	 * Creates the menu.
	 */
	@SuppressWarnings("unused")
	private void createMenu() {
		IMenuManager mgr = getEditorSite().getActionBars().getMenuManager();
	}

	// ---------------------------------------------------------------

	/*
	 * (non-Javadoc)
	 * @see eu.kalafatic.gemini.core.interfaces.IViewer#hookContextMenu()
	 */
	@Override
	public void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			@Override
			public void menuAboutToShow(IMenuManager manager) {}
		});
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.zest.core.viewers.IZoomableWorkbenchPart#getZoomableViewer()
	 */
	@Override
	public AbstractZoomableViewer getZoomableViewer() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IPartListener2#partActivated(org.eclipse.ui.IWorkbenchPartReference)
	 */
	@Override
	public void partActivated(IWorkbenchPartReference partRef) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IPartListener2#partBroughtToTop(org.eclipse.ui.IWorkbenchPartReference)
	 */
	@Override
	public void partBroughtToTop(IWorkbenchPartReference partRef) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IPartListener2#partClosed(org.eclipse.ui.IWorkbenchPartReference)
	 */
	@Override
	public void partClosed(IWorkbenchPartReference partRef) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IPartListener2#partDeactivated(org.eclipse.ui.IWorkbenchPartReference)
	 */
	@Override
	public void partDeactivated(IWorkbenchPartReference partRef) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IPartListener2#partOpened(org.eclipse.ui.IWorkbenchPartReference)
	 */
	@Override
	public void partOpened(IWorkbenchPartReference partRef) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IPartListener2#partHidden(org.eclipse.ui.IWorkbenchPartReference)
	 */
	@Override
	public void partHidden(IWorkbenchPartReference partRef) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IPartListener2#partVisible(org.eclipse.ui.IWorkbenchPartReference)
	 */
	@Override
	public void partVisible(IWorkbenchPartReference partRef) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IPartListener2#partInputChanged(org.eclipse.ui.IWorkbenchPartReference)
	 */
	@Override
	public void partInputChanged(IWorkbenchPartReference partRef) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.ISelectionListener#selectionChanged(org.eclipse.ui.IWorkbenchPart, org.eclipse.jface.viewers.ISelection)
	 */
	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IPerspectiveListener#perspectiveActivated(org.eclipse.ui.IWorkbenchPage, org.eclipse.ui.IPerspectiveDescriptor)
	 */
	@Override
	public void perspectiveActivated(IWorkbenchPage page, IPerspectiveDescriptor perspective) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IPerspectiveListener#perspectiveChanged(org.eclipse.ui.IWorkbenchPage, org.eclipse.ui.IPerspectiveDescriptor, java.lang.String)
	 */
	@Override
	public void perspectiveChanged(IWorkbenchPage page, IPerspectiveDescriptor perspective, String changeId) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see eu.kalafatic.utils.interfaces.IViewer#initColumns()
	 */
	@Override
	public void initColumns() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see eu.kalafatic.utils.interfaces.IViewer#initListeners()
	 */
	@Override
	public void initListeners() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see eu.kalafatic.utils.interfaces.IViewer#initDragAndDrop()
	 */
	@Override
	public void initDragAndDrop() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see eu.kalafatic.utils.interfaces.IViewer#getViewer()
	 */
	@Override
	public Object getViewer() {
		return viewer;
	}
}
