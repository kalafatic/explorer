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
package eu.kalafatic.explorer.view.pages;

import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.forms.IFormColors;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;

import eu.kalafatic.explorer.view.editors.ExplorerEditor;

/**
 * The Class class AProjectPage.
 * @author Petr Kalafatic
 * @version 3.0.0
 * @project Gemini
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public abstract class AProjectPage extends FormPage implements ISelectionListener {

	/** The editor. */
	private ExplorerEditor editor;
	
	/** The input. */
	private Map input;

	/** The Constant TAB_INDEX. */
	public static final String TAB_INDEX = "TAB_INDEX";
	
	/** The Constant PARENT. */
	public static final String PARENT = "PARENT";
	
	/** The tab index. */
	private int tabIndex = 0;

	/** The text style. */
	int textStyle = SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL | SWT.READ_ONLY;

	/** The tab folder. */
	public CTabFolder tabFolder;
	
	/** The form. */
	protected ScrolledForm form;
	
	/** The toolkit. */
	protected FormToolkit toolkit;

	/**
	 * Instantiates a new a project page.
	 * @param editor the editor
	 * @param id the id
	 * @param title the title
	 * @param index the index
	 * @param input the input
	 */
	public AProjectPage(ExplorerEditor editor, String id, String title, int index, Map input) {
		super(editor, id, title);
		// /
		// Map attributes = (Map) input.get(EProject.ATTRIBUTES.name());
		// if (attributes.containsKey(EProject.NAME.name())) {
		// setPartName((String) attributes.get(EProject.NAME.name()));
		// } else {
		// setPartName((String) input.get(EProject.KEY.name()));
		// }
		this.editor = editor;
		this.input = input;
	}

	// ---------------------------------------------------------------
	// ---------------------------------------------------------------

	/* (non-Javadoc)
	 * @see org.eclipse.ui.forms.editor.FormPage#createFormContent(org.eclipse.ui.forms.IManagedForm)
	 */
	@Override
	protected void createFormContent(IManagedForm managedForm) {
		form = managedForm.getForm();
		form.getBody().setLayout(new GridLayout(1, false));
		form.getBody().setLayoutData(new GridData(GridData.FILL_BOTH));

		toolkit = managedForm.getToolkit();

		createTabFolder();
		createTabs();

		tabFolder.setSelection(0);
		// updateSelection();
		initListeners();
	}

	// ---------------------------------------------------------------

	/**
	 * Inits the listeners.
	 */
	private void initListeners() {
		tabFolder.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// updateSelection();
			}
		});
	}

	// ---------------------------------------------------------------

	/**
	 * Creates the tab folder.
	 */
	private void createTabFolder() {
		tabFolder = new CTabFolder(form.getBody(), SWT.FLAT | SWT.TOP);
		toolkit.adapt(tabFolder, true, true);

		tabFolder.setLayout(new GridLayout(1, false));
		tabFolder.setLayoutData(new GridData(GridData.FILL_BOTH));

		Color selectedColor = toolkit.getColors().getColor(IFormColors.SEPARATOR);
		tabFolder.setSelectionBackground(new Color[] { selectedColor, toolkit.getColors().getBackground() }, new int[] { 50 });
		// tabFolder.setCursor(FormsResources.getHandCursor());

		toolkit.paintBordersFor(tabFolder);
	}

	// ---------------------------------------------------------------

	/**
	 * Creates the tabs.
	 */
	private void createTabs() {
		// createTab(EProject.PROJECT, createTab(EProject.PROJECT.literal, false));
		//
		// createTab(EProject.ATTRIBUTES, createTab(EProject.ATTRIBUTES.literal, true));

		// one tabs level only
		// if (!(this instanceof OverviewPage)) {
		// List children = (List) input.get(EProject.CHILDREN.name());
		// for (int i = 0; i < 5; i++) {
		//
		// // for (Object object : children) {
		// // Map supProject = (Map) object;
		// createTab(EProject.CHILDREN, createTab("huk", true));
		// }
		// }
	}

	// ---------------------------------------------------------------

	/**
	 * Creates the tab.
	 * @param title the title
	 * @param closeable the closeable
	 * @return the c tab item
	 */
	private CTabItem createTab(String title, /* Map map, */boolean closeable) {
		CTabItem item = new CTabItem(tabFolder, SWT.NULL);
		item.setText(title);
		// item.setData(map);
		item.setShowClose(closeable);
		return item;
	}

	// ---------------------------------------------------------------

	// one level projects only
	// private CTabItem createTab(EProject eProject, CTabItem cTabItem) {
	// // SashForm parent = new SashForm(tabFolder, SWT.VERTICAL);
	// Composite parent = new Composite(tabFolder, SWT.NONE);
	// parent.setLayout(new GridLayout());
	// cTabItem.setControl(parent);
	// createSection(eProject, (Map) cTabItem.getData(), parent, true);
	//
	// cTabItem.setData(TAB_INDEX, tabIndex++);
	// cTabItem.setData(PARENT, this);
	// // editor.pages.put(cTabItem.getData(), cTabItem);
	//
	// return cTabItem;
	// }

	// ---------------------------------------------------------------

	/**
	 * Adds the client.
	 * @param client the client
	 * @param map the map
	 * @param entry the entry
	 * @param ui the ui
	 */
	// private void createSection(EProject eProject, Map map, Composite parent, boolean expanded) {
	//
	// Composite client;
	// boolean enabled = !(this instanceof OverviewPage);

	// Iterator iterator = map.entrySet().iterator();

	// switch (eProject) {
	// case PROJECT:
	// client = GUIFactory.createUISection(parent, EProject.PROJECT.literal,
	// expanded);
	//
	// // while (iterator.hasNext()) {
	// // Entry entry = (Entry) iterator.next();
	//
	// for (int i = 0; i < 5; i++) {
	//
	// // if (filter(entry, EProject.PROJECT, EProject.ATTRIBUTES,
	// // EProject.CHILDREN)) {
	// // enabled &= !entry.getKey().equals(EProject.KEY.name());
	// addClient(client, map, null, enabled ? EUI.SELECT.bits : 0);
	// // }
	// }
	// break;
	// case ATTRIBUTES:
	// // client = guiFactory.createUISection(parent,
	// // EProject.ATTRIBUTES.literal, expanded);
	// // Map attributes = (Map) map.get(EProject.ATTRIBUTES.name());
	// //
	// // while (iterator.hasNext()) {
	// // Entry entry = (Entry) iterator.next();
	// // addClient(client, attributes, entry, enabled ? EUI.SELECT.bits :
	// // 0);
	// // }
	// break;
	//
	// case CHILDREN:
	// // client = guiFactory.createUISection(parent, Utils.getName(map,
	// // EProject.TYPE), expanded);
	// //
	// // while (iterator.hasNext()) {
	// // Entry entry = (Entry) iterator.next();
	// // addClient(client, map, entry, 0);
	// // }
	// break;
	//
	// default:
	// break;
	// }
	// }

	// ---------------------------------------------------------------

	// private boolean filter(Entry entry, EProject... eProjects) {
	// for (EProject eProject : eProjects) {
	// if (entry.getKey().equals(eProject.name())) {
	// return false;
	// }
	// }
	// return true;
	// }

	// ---------------------------------------------------------------

	public void addClient(Composite client, Map map, Entry entry, int ui) {
		// Composite tabContent = GUIFactory.createTabContent(client, 3, "gk");
		// Text text = GUI_FACTORY.createText(tabContent, "Juk");
		// // text.setData(map);
		// // text.setData(EProject.KEY.name(), entry.getKey());
		//
		// Label label = toolkit.createLabel(tabContent, null);
		// GridData gridData = new GridData(GridData.HORIZONTAL_ALIGN_END);
		// gridData.widthHint = 60;
		// label.setLayoutData(gridData);
		//
		// GUI_FACTORY.setControls(ui, text, null);

	}
}
