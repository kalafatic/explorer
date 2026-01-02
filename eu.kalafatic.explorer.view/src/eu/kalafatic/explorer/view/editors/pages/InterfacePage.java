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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.forms.IFormColors;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.events.ExpansionAdapter;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

import eu.kalafatic.explorer.view.editors.ExplorerEditor;
import eu.kalafatic.explorer.view.pages.AProjectPage;
import eu.kalafatic.utils.factories.GUIFactory;

/**
 * The Class class InterfacePage.
 * @author Petr Kalafatic
 * @version 3.0.0
 * @project Gemini
 */
public class InterfacePage extends AProjectPage {

	/** The Constant ID. */
	public static final String ID = "eu.kalafatic.maintain.core.editors.pages.InterfacePage";

	/** The grid layout. */
	private GridLayout gridLayout;

	/** The grid data. */
	private GridData gridData;

	/** The filter path. */
	private String filterPath = "c:/GE/maintain/";

	/** The xml. */
	private String xml;

	/** The xsds. */
	private List<String> xsds = new ArrayList<String>();

	/** The result text. */
	private Text resultText;

	/**
	 * Instantiates a new interface page.
	 * @param explorerEditor the explorer editor
	 * @param index the index
	 */
	public InterfacePage(ExplorerEditor explorerEditor, int index) {
		this(explorerEditor, ID, "Interface", index, Collections.EMPTY_MAP);
	}

	/**
	 * Instantiates a new interface page.
	 * @param explorerEditor the explorer editor
	 * @param id the id
	 * @param title the title
	 * @param index the index
	 * @param input the input
	 */
	private InterfacePage(ExplorerEditor explorerEditor, String id, String title, int index, Map input) {
		super(explorerEditor, id, title, index, input);
	}

	// ---------------------------------------------------------------
	// ---------------------------------------------------------------

	/*
	 * (non-Javadoc)
	 * @see eu.kalafatic.explorer.view.pages.AProjectPage#createFormContent(org.eclipse.ui.forms.IManagedForm)
	 */
	@Override
	protected void createFormContent(IManagedForm managedForm) {
		ScrolledForm form = managedForm.getForm();
		toolkit = managedForm.getToolkit();
		// form.setText("");
		// form.setBackgroundImage(FormArticlePlugin.getDefault().getImage(FormArticlePlugin.IMG_FORM_BG));

		form.getBody().setLayout(new GridLayout());

		SashForm sashForm = GUIFactory.INSTANCE.createSashForm(form.getBody(), 2, SWT.VERTICAL);
		SashForm sashFormTable = GUIFactory.INSTANCE.createSashForm(sashForm, 1, SWT.HORIZONTAL);

		createTableSection(sashFormTable, 0);
		createTableSection(sashFormTable, 1);

		createResultSection(sashForm);

		createActionBar(managedForm);
	}

	// ---------------------------------------------------------------

	/**
	 * Creates the action bar.
	 * @param managedForm the managed form
	 */
	private void createActionBar(final IManagedForm managedForm) {
		// Action validate = new Action("Validate") {
		// @Override
		// public void run() {
		// XSDXMLValidator xsdxmlValidator = getXSDXMLValidator();
		// BusyIndicator.showWhile(Display.getDefault(), xsdxmlValidator);
		//
		// String result = xsdxmlValidator.getResult();
		// if (result.equals("Valid")) {
		// ((MaintainEditor)
		// getEditor()).getForm().setMessage("Valid comparision",
		// IMessageProvider.INFORMATION);
		// } else {
		// ((MaintainEditor)
		// getEditor()).getForm().setMessage("Invalid comparision",
		// IMessageProvider.WARNING);
		// }
		// resultText.setText(result);
		// }
		// };
		// managedForm.getForm().getToolBarManager().add(validate);
		managedForm.getForm().getToolBarManager().update(true);
	}

	// ---------------------------------------------------------------

	// private XSDXMLValidator getXSDXMLValidator() {
	// File[] xsdsFiles = new File[xsds.size()];
	//
	// for (int i = 0; i < xsdsFiles.length; i++) {
	// xsdsFiles[i] = new File(xsds.get(i));
	// }
	// return new XSDXMLValidator(new File(xml), xsdsFiles);
	// }

	// ---------------------------------------------------------------

	/**
	 * Creates the table section.
	 * @param parent the parent
	 * @param type the type
	 */
	private void createTableSection(final Composite parent, int type) {
		Section section = toolkit.createSection(parent, /* Section.DESCRIPTION | */Section.COMPACT);
		section.setActiveToggleColor(toolkit.getHyperlinkGroup().getActiveForeground());
		section.setToggleColor(toolkit.getColors().getColor(IFormColors.SEPARATOR));
		toolkit.createCompositeSeparator(section);
		Composite client = toolkit.createComposite(section, SWT.WRAP);
		gridLayout = new GridLayout();
		gridLayout.numColumns = 2;

		client.setLayout(gridLayout);

		// Table table = createTable(client, type);
		// createButtons(client, table, type);

		section.setText(type == 0 ? "Command" : "Execute");
		// section.setDescription(type == 0 ? "Command" : "Response");
		section.setClient(client);
		section.setExpanded(true);

		section.addExpansionListener(new ExpansionAdapter() {
			@Override
			public void expansionStateChanged(ExpansionEvent e) {
				form.reflow(false);
			}
		});
		gridData = new GridData(GridData.FILL_BOTH);
		section.setLayoutData(gridData);
	}

	// ---------------------------------------------------------------

	/**
	 * Creates the result section.
	 * @param parent the parent
	 */
	private void createResultSection(final Composite parent) {
		Section section = toolkit.createSection(parent, /* Section.DESCRIPTION | */Section.COMPACT);
		section.setActiveToggleColor(toolkit.getHyperlinkGroup().getActiveForeground());
		section.setToggleColor(toolkit.getColors().getColor(IFormColors.SEPARATOR));

		toolkit.createCompositeSeparator(section);
		Composite client = toolkit.createComposite(section, SWT.WRAP);
		client.setLayout(new GridLayout());

		// createText(client);

		section.setClient(client);
		section.setExpanded(true);

		section.addExpansionListener(new ExpansionAdapter() {
			@Override
			public void expansionStateChanged(ExpansionEvent e) {
				form.reflow(false);
			}
		});
		gridData = new GridData(GridData.FILL_BOTH);
		gridData.horizontalSpan = 2;
		section.setLayoutData(gridData);

	}

	// ---------------------------------------------------------------

	/**
	 * Creates the buttons.
	 * @param client the client
	 * @param table the table
	 * @param type the type
	 */
	private void createButtons(Composite client, final Table table, final int type) {
		if (type == 0) {
			Button changeBtn = GUIFactory.INSTANCE.createButton(client, "Set");
			changeBtn.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					// String openFile = Utils.openFile(true, filterPath);
					// if (openFile != null) {
					// table.getItem(0).setText(openFile);
					// xml = openFile;
					// }
				}
			});
		} else {
			Button deleteBtn = GUIFactory.INSTANCE.createButton(client, "Remove");
			deleteBtn.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					TableItem[] items = table.getItems();
					for (int i = 0; i < items.length; i++) {
						if (items[i].getChecked()) {
							xsds.remove(items[i].getText());
							items[i].dispose();
						}
					}
					table.update();
				}
			});
		}
	}

	// ---------------------------------------------------------------

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.ISelectionListener#selectionChanged(org.eclipse.ui.IWorkbenchPart, org.eclipse.jface.viewers.ISelection)
	 */
	// private Table createTable(Composite client, int type) {
	// GUI_FACTORY.createTable(client, type == 0 ? SWT.MULTI : SWT.CHECK);
	// Table table = toolkit.createTable(client, type == 0 ? SWT.MULTI :
	// SWT.CHECK);
	// gridData = new GridData(GridData.FILL_BOTH);
	// // gridData.heightHint = 100;
	// // gridData.widthHint = 50;
	// gridData.verticalSpan = 3;
	// table.setLayoutData(gridData);
	// toolkit.paintBordersFor(client);
	// table.setLinesVisible(true);
	//
	// if (type == 0) {
	// new TableItem(table, SWT.NO);
	// }
	// }

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		// TODO Auto-generated method stub

	}
}