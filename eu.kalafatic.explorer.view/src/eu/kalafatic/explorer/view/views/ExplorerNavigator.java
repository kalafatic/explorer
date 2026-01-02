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
package eu.kalafatic.explorer.view.views;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.DrillDownAdapter;
import org.eclipse.ui.part.ViewPart;

import eu.kalafatic.explorer.controller.model.ExplorerModelManager;
import eu.kalafatic.explorer.model.explorer.Explorer;
import eu.kalafatic.explorer.model.explorer.Route;
import eu.kalafatic.explorer.view.providers.ExplorerLabelDecorator;
import eu.kalafatic.explorer.view.providers.ExplorerNavigatorContentProvider;
import eu.kalafatic.explorer.view.providers.ExplorerNavigatorLabelProvider;
import eu.kalafatic.explorer.view.providers.ExplorerNavigatorSorter;

/**
 * The Class class ExplorerNavigator.
 * @author Petr Kalafatic
 * @version 3.0.0
 * @project Gemini
 */

public class ExplorerNavigator extends ViewPart {

	/** The Constant ID. */
	public static final String ID = "eu.kalafatic.explorer.view.views.ExplorerNavigator";

	/** The viewer. */
	private TreeViewer viewer;

	/** The drill down adapter. */
	private DrillDownAdapter drillDownAdapter;

	/** The action1. */
	private Action action1;

	/** The action2. */
	private Action action2;

	/** The double click action. */
	private Action doubleClickAction;

	/** The root node. */
	private final String ROOT_NODE = "Net";

	private ExplorerNavigatorLabelProvider provider;

	private ExplorerLabelDecorator labelDecorator;

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createPartControl(Composite parent) {
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		drillDownAdapter = new DrillDownAdapter(viewer);
		viewer.setContentProvider(new ExplorerNavigatorContentProvider());
		// viewer.setLabelProvider(new ExplorerNavigatorLabelProvider());
		provider = new ExplorerNavigatorLabelProvider();
		viewer.setLabelProvider(new DecoratingLabelProvider(provider, PlatformUI.getWorkbench().getDecoratorManager().getLabelDecorator()));

		viewer.setSorter(new ExplorerNavigatorSorter());

		Map<String, EMap<?, ?>> inputMap = new HashMap<String, EMap<?, ?>>();
		Explorer explorer = ExplorerModelManager.getInstance().getModel();

		inputMap.put(ROOT_NODE, explorer.getChildren());
		viewer.setInput(inputMap);

		// Create the help context id for the viewer's control
		PlatformUI.getWorkbench().getHelpSystem().setHelp(viewer.getControl(), "eu.kalafatic.explorer.view.viewer");
		makeActions();
		hookContextMenu();
		hookDoubleClickAction();
		contributeToActionBars();
	}

	/**
	 * Hook context menu.
	 */
	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			@Override
			public void menuAboutToShow(IMenuManager manager) {
				ExplorerNavigator.this.fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer);
	}

	/**
	 * Contribute to action bars.
	 */
	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	/**
	 * Fill local pull down.
	 * @param manager the manager
	 */
	private void fillLocalPullDown(IMenuManager manager) {
		manager.add(action1);
		manager.add(new Separator());
		manager.add(action2);
	}

	/**
	 * Fill context menu.
	 * @param manager the manager
	 */
	private void fillContextMenu(IMenuManager manager) {
		manager.add(action1);
		manager.add(action2);
		manager.add(new Separator());
		drillDownAdapter.addNavigationActions(manager);
		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}

	/**
	 * Fill local tool bar.
	 * @param manager the manager
	 */
	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(action1);
		manager.add(action2);
		manager.add(new Separator());
		drillDownAdapter.addNavigationActions(manager);
	}

	/**
	 * Make actions.
	 */
	private void makeActions() {
		action1 = new Action() {
			@Override
			public void run() {
				showMessage("Action 1 executed");
			}
		};
		action1.setText("Action 1");
		action1.setToolTipText("Action 1 tooltip");
		action1.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));

		action2 = new Action() {
			@Override
			public void run() {
				showMessage("Action 2 executed");
			}
		};
		action2.setText("Action 2");
		action2.setToolTipText("Action 2 tooltip");
		action2.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
		doubleClickAction = new Action() {
			@Override
			public void run() {
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection) selection).getFirstElement();
				// showMessage("Double-click detected on " + obj.toString());
			}
		};
	}

	/**
	 * Hook double click action.
	 */
	private void hookDoubleClickAction() {
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			@Override
			public void doubleClick(final DoubleClickEvent event) {
				doubleClickAction.run();
				if (event.getSelection() instanceof IStructuredSelection) {

					final IStructuredSelection s = (IStructuredSelection) event.getSelection();

					refresh(s.toArray());

					// Display.getDefault().asyncExec(new Runnable() {
					// @Override
					// public void run() {
					// viewer.refresh(s.toArray()[0], true);
					// }
					// });
				}

			}
		});
	}

	public void refresh(Object... objects) {
		List l = new ArrayList();
		if (objects[0] instanceof Route) {
			l.add(objects[0]);
			// Route device = (Route) objects[0];
			//
			// if (device.getHost().equals("localhost")) {
			// decoration.addOverlay(imageDescriptor);
			// }
			// ILightweightLabelDecorator labelDecorator2 =
			IBaseLabelProvider labelProvider2 = PlatformUI.getWorkbench().getDecoratorManager().getBaseLabelProvider("eu.kalafatic.explorer.view.providers.ExplorerLabelDecorator");

			// labelProvider2.decorateImage(provider.getImage(objects[0]), objects[0]);

			PlatformUI.getWorkbench().getDecoratorManager().update("eu.kalafatic.explorer.view.providers.ExplorerLabelDecorator");
		}
		// provider.update(l.toArray());

	}

	/**
	 * Show message.
	 * @param message the message
	 */
	private void showMessage(String message) {
		MessageDialog.openInformation(viewer.getControl().getShell(), "Sample View", message);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	@Override
	public void setFocus() {
		viewer.getControl().setFocus();
	}
}