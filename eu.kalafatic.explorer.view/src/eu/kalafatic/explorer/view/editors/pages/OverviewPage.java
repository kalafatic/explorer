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

import java.util.Collections;
import java.util.Map;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchPart;

import eu.kalafatic.explorer.view.editors.ExplorerEditor;
import eu.kalafatic.explorer.view.pages.AProjectPage;

/**
 * The Class class OverviewPage.
 * @author Petr Kalafatic
 * @version 3.0.0
 * @project Gemini
 */
@SuppressWarnings("rawtypes")
public class OverviewPage extends AProjectPage {

	/** The Constant ID. */
	public static final String ID = "eu.kalafatic.maintain.core.editors.pages.OverviewPage";

	/**
	 * Instantiates a new overview page.
	 * @param explorerEditor the explorer editor
	 * @param index the index
	 */
	public OverviewPage(ExplorerEditor explorerEditor, int index) {
		this(explorerEditor, ID, "Overview", index, Collections.EMPTY_MAP);
	}

	/**
	 * Instantiates a new overview page.
	 * @param editor the editor
	 * @param id the id
	 * @param title the title
	 * @param index the index
	 * @param input the input
	 */
	private OverviewPage(ExplorerEditor editor, String id, String title, int index, Map input) {
		super(editor, id, title, index, input);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.ISelectionListener#selectionChanged(org.eclipse.ui.IWorkbenchPart, org.eclipse.jface.viewers.ISelection)
	 */
	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		// TODO Auto-generated method stub

	}
}