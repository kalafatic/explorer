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
package eu.kalafatic.explorer.core.perspectives;

import org.eclipse.ui.IPageLayout;

import eu.kalafatic.utils.factories.CorePerspectiveFactory;

/**
 * The Class class Perspective.
 * @author Petr Kalafatic
 * @project Gemini
 * @version 3.0.0
 */
public class ExplorerCorePerspective extends CorePerspectiveFactory {

	public static final String ID = "eu.kalafatic.explorer.core.perspectives.ExplorerCorePerspective";

	/**
	 * (non-Javadoc)
	 * @see org.eclipse.ui.IPerspectiveFactory#createInitialLayout(org.eclipse.ui .IPageLayout)
	 */
	@Override
	public void createInitialLayout(IPageLayout layout) {
		super.createInitialLayout(layout);
	}
}
