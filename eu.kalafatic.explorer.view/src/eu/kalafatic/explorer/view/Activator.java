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
package eu.kalafatic.explorer.view;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.internal.editors.text.EditorsPlugin;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.texteditor.AbstractDecoratedTextEditorPreferenceConstants;
import org.eclipse.ui.texteditor.AbstractTextEditor;
import org.osgi.framework.BundleContext;

/**
 * The Class class Activator.
 * @author Petr Kalafatic
 * @version 3.0.0
 * @project Gemini
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	/** The Constant PLUGIN_ID. */
	public static final String PLUGIN_ID = "eu.kalafatic.explorer.view"; //$NON-NLS-1$

	// The shared instance
	/** The plugin. */
	private static Activator plugin;

	/**
	 * Instantiates a new activator.
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
	 * )
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		IPreferenceStore store = EditorsPlugin.getDefault().getPreferenceStore();
		store.setValue(AbstractDecoratedTextEditorPreferenceConstants.EDITOR_LINE_NUMBER_RULER,
				true);
		useTextEditorPreferencePage(store);
	}

	/**
	 * Sets the text editor preference page.
	 * @param store the new text editor preference page
	 */
	public static void setTextEditorPreferencePage(IPreferenceStore store) {

		store.setValue(AbstractDecoratedTextEditorPreferenceConstants.EDITOR_CURRENT_LINE, true);
		store.setValue(AbstractDecoratedTextEditorPreferenceConstants.EDITOR_CURRENT_LINE_COLOR,
				true);

		store.setValue(AbstractDecoratedTextEditorPreferenceConstants.EDITOR_LINE_NUMBER_RULER,
				true);
		store.setValue(
				AbstractDecoratedTextEditorPreferenceConstants.EDITOR_LINE_NUMBER_RULER_COLOR, true);
		store.setValue(AbstractDecoratedTextEditorPreferenceConstants.EDITOR_OVERVIEW_RULER, true);

		store.setValue(AbstractDecoratedTextEditorPreferenceConstants.EDITOR_TAB_WIDTH, true);

		store.setValue(AbstractDecoratedTextEditorPreferenceConstants.EDITOR_PRINT_MARGIN, true);
		store.setValue(AbstractDecoratedTextEditorPreferenceConstants.EDITOR_PRINT_MARGIN_COLOR,
				true);
		store.setValue(AbstractDecoratedTextEditorPreferenceConstants.EDITOR_PRINT_MARGIN_COLUMN,
				true);

		store.setValue(AbstractDecoratedTextEditorPreferenceConstants.EDITOR_USE_CUSTOM_CARETS,
				true);
		store.setValue(AbstractDecoratedTextEditorPreferenceConstants.EDITOR_WIDE_CARET, true);

		store.setValue(
				AbstractDecoratedTextEditorPreferenceConstants.EDITOR_SELECTION_FOREGROUND_COLOR,
				true);
		store.setValue(
				AbstractDecoratedTextEditorPreferenceConstants.EDITOR_SELECTION_BACKGROUND_COLOR,
				true);
		store.setValue(
				AbstractDecoratedTextEditorPreferenceConstants.EDITOR_SELECTION_FOREGROUND_DEFAULT_COLOR,
				true);
		store.setValue(
				AbstractDecoratedTextEditorPreferenceConstants.EDITOR_SELECTION_BACKGROUND_DEFAULT_COLOR,
				true);
		store.setValue(AbstractTextEditor.PREFERENCE_COLOR_FOREGROUND, true);
		store.setValue(AbstractTextEditor.PREFERENCE_COLOR_BACKGROUND, true);
		store.setValue(AbstractTextEditor.PREFERENCE_COLOR_BACKGROUND_SYSTEM_DEFAULT, true);
		store.setValue(AbstractTextEditor.PREFERENCE_COLOR_FOREGROUND_SYSTEM_DEFAULT, true);

		store.setValue(
				AbstractDecoratedTextEditorPreferenceConstants.EDITOR_DISABLE_OVERWRITE_MODE, true);
	}

	/*
	 * reset to default, those constants are no longer maintain int CUIPlugin
	 * store.
	 */
	/**
	 * Use text editor preference page.
	 * @param store the store
	 */
	public static void useTextEditorPreferencePage(IPreferenceStore store) {

		store.setToDefault(AbstractDecoratedTextEditorPreferenceConstants.EDITOR_CURRENT_LINE);
		store.setToDefault(AbstractDecoratedTextEditorPreferenceConstants.EDITOR_CURRENT_LINE_COLOR);

		store.setToDefault(AbstractDecoratedTextEditorPreferenceConstants.EDITOR_LINE_NUMBER_RULER);
		store.setToDefault(AbstractDecoratedTextEditorPreferenceConstants.EDITOR_LINE_NUMBER_RULER_COLOR);
		store.setToDefault(AbstractDecoratedTextEditorPreferenceConstants.EDITOR_OVERVIEW_RULER);

		store.setToDefault(AbstractDecoratedTextEditorPreferenceConstants.EDITOR_TAB_WIDTH);

		store.setToDefault(AbstractDecoratedTextEditorPreferenceConstants.EDITOR_PRINT_MARGIN);
		store.setToDefault(AbstractDecoratedTextEditorPreferenceConstants.EDITOR_PRINT_MARGIN_COLOR);
		store.setToDefault(AbstractDecoratedTextEditorPreferenceConstants.EDITOR_PRINT_MARGIN_COLUMN);

		store.setToDefault(AbstractDecoratedTextEditorPreferenceConstants.EDITOR_USE_CUSTOM_CARETS);
		store.setToDefault(AbstractDecoratedTextEditorPreferenceConstants.EDITOR_WIDE_CARET);

		store.setToDefault(AbstractDecoratedTextEditorPreferenceConstants.EDITOR_SELECTION_FOREGROUND_COLOR);
		store.setToDefault(AbstractDecoratedTextEditorPreferenceConstants.EDITOR_SELECTION_BACKGROUND_COLOR);
		store.setToDefault(AbstractDecoratedTextEditorPreferenceConstants.EDITOR_SELECTION_FOREGROUND_DEFAULT_COLOR);
		store.setToDefault(AbstractDecoratedTextEditorPreferenceConstants.EDITOR_SELECTION_BACKGROUND_DEFAULT_COLOR);
		store.setToDefault(AbstractTextEditor.PREFERENCE_COLOR_FOREGROUND);
		store.setToDefault(AbstractTextEditor.PREFERENCE_COLOR_BACKGROUND);
		store.setToDefault(AbstractTextEditor.PREFERENCE_COLOR_BACKGROUND_SYSTEM_DEFAULT);
		store.setToDefault(AbstractTextEditor.PREFERENCE_COLOR_FOREGROUND_SYSTEM_DEFAULT);

		store.setToDefault(AbstractDecoratedTextEditorPreferenceConstants.EDITOR_DISABLE_OVERWRITE_MODE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
	 * )
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Gets the default.
	 * @return the default
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * Gets the image descriptor.
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}
}
