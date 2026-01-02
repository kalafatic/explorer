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

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.PreferenceManager;
import org.eclipse.jface.preference.PreferenceNode;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.PlatformUI;

import eu.kalafatic.explorer.controller.Activator;
import eu.kalafatic.utils.factories.GUIFactory;

/**
 * The Class class SubnetScanPreferencePage.
 * @author Petr Kalafatic
 * @project Gemini
 * @version 3.0.0
 */
public class SubnetScanPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	/**
	 * Instantiates a new subnet scan preference page.
	 */
	public SubnetScanPreferencePage() {
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
		addField(new DirectoryFieldEditor(PreferenceConstants.P_PATH, "&Directory preference:", getFieldEditorParent()));
		addField(new BooleanFieldEditor(PreferenceConstants.P_BOOLEAN, "&An example of a boolean preference", getFieldEditorParent()));

		addField(new RadioGroupFieldEditor(PreferenceConstants.P_CHOICE, "An example of a multiple-choice preference", 1, new String[][] { { "&Choice 1", "choice1" }, { "C&hoice 2", "choice2" } },
				getFieldEditorParent()));
		addField(new StringFieldEditor(PreferenceConstants.P_STRING, "A &text preference:", getFieldEditorParent()));
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

		Composite buttonsParent = getDefaultsButton().getParent();

		Button runButton = GUIFactory.INSTANCE.createButton(buttonsParent, "Run");

		buttonsParent.setLayout(new GridLayout(3, false));
		buttonsParent.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_END));
	}
}
