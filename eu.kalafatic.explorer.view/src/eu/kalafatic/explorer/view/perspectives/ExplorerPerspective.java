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
package eu.kalafatic.explorer.view.perspectives;

import org.eclipse.ui.IPageLayout;

import eu.kalafatic.utils.factories.CorePerspectiveFactory;

/**
 * The Class class ExplorerPerspective.
 * @author Petr Kalafatic
 * @version 3.0.0
 * @project Gemini
 */
public class ExplorerPerspective extends CorePerspectiveFactory {

	/** The Constant ID. */
	public static final String ID = "eu.kalafatic.explorer.view.perspectives.ExplorerPerspective";

	// ---------------------------------------------------------------
	// ---------------------------------------------------------------

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.IPerspectiveFactory#createInitialLayout(org.eclipse.ui.IPageLayout)
	 */
	@Override
	public void createInitialLayout(IPageLayout layout) {
		try {
			super.createInitialLayout(layout);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
