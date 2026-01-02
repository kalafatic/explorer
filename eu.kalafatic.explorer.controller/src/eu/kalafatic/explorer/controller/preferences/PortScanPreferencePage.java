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
package eu.kalafatic.explorer.controller.preferences;

import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.PreferenceManager;
import org.eclipse.jface.preference.PreferenceNode;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.PlatformUI;

import eu.kalafatic.explorer.controller.Activator;
import eu.kalafatic.utils.factories.GUIFactory;

/**
 * The Class class PortScanPreferencePage.
 * @author Petr Kalafatic
 * @project Gemini
 * @version 3.0.0
 */
public class PortScanPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	/**
	 * Instantiates a new port scan preference page.
	 */
	public PortScanPreferencePage() {
		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("A demonstration of a preference page implementation");
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.preference.FieldEditorPreferencePage#createFieldEditors()
	 */
	@Override
	public void createFieldEditors() {
		// addField(new DirectoryFieldEditor(PreferenceConstants.P_PATH, "&Directory preference:", getFieldEditorParent()));
		// addField(new BooleanFieldEditor(PreferenceConstants.P_BOOLEAN, "&An example of a boolean preference", getFieldEditorParent()));
		//
		// addField(new RadioGroupFieldEditor(PreferenceConstants.P_CHOICE, "An example of a multiple-choice preference", 1, new String[][] { {
		// "&Choice 1", "choice1" }, { "C&hoice 2", "choice2" } },
		// getFieldEditorParent()));
		// addField(new StringFieldEditor(PreferenceConstants.P_STRING, "A &text preference:", getFieldEditorParent()));
		String[][] entryNamesAndValues = new String[][] { { "a", "b" } };
		addField(new ComboFieldEditor(PreferenceConstants.P_STRING, "A &text preference:", entryNamesAndValues, getFieldEditorParent()));

	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	@Override
	public void init(IWorkbench workbench) {
		// use workbenches's preference manager
		PreferenceManager preferenceManager = PlatformUI.getWorkbench().getPreferenceManager();
		// create a new PreferenceNode that will appear in the Preference window
		PreferenceNode node = new PreferenceNode(getTitle(), this);

		preferenceManager.addTo("eu.kalafatic.explorer.core.preferences", node);

	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.preference.PreferencePage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);

		// Composite buttonsParent = getDefaultsButton().getParent();

		// Button runButton = GUIFactory.INSTANCE.createButton(buttonsParent, "Run");
		//
		// buttonsParent.setLayout(new GridLayout(3, false));
		// buttonsParent.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_END));

		Group group = GUIFactory.INSTANCE.createGroup(getFieldEditorParent(), "fgn", 4);

		createIPRangeSelection(group);
	}

	/**
	 * @param group
	 */
	private void createIPRangeSelection(Group group) {
		Composite addressWidget = GUIFactory.INSTANCE.createComposite(group, 3);


		Combo combo = GUIFactory.INSTANCE.createCombo(group, "IP Version", SWT.DROP_DOWN);
		GUIFactory.INSTANCE.createLabel(group, "ss", (byte) 3);

		Text addressText = GUIFactory.INSTANCE.createText(group, "jj", true);


		GridData gridData = new GridData();
		gridData.widthHint = 20;

		for (int i = 0; i < 4; i++) {
			Composite composite = GUIFactory.INSTANCE.createComposite(group, 3, SWT.SHADOW_IN, 50);

			combo = GUIFactory.INSTANCE.createCombo(composite, "hj", SWT.NONE);
			combo.setLayoutData(gridData);
			GUIFactory.INSTANCE.createLabel(composite, 20).setText("-");
			combo = GUIFactory.INSTANCE.createCombo(composite, "hj", SWT.NONE);
			combo.setLayoutData(gridData);
		}
	}
}
