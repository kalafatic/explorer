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
package eu.kalafatic.explorer.core.application;

import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchAdvisor;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

import eu.kalafatic.explorer.core.perspectives.ExplorerCorePerspective;

/**
 * The Class class ApplicationWorkbenchAdvisor.
 * @author Petr Kalafatic
 * @project Gemini
 * @version 3.0.0
 */
public class ApplicationWorkbenchAdvisor extends WorkbenchAdvisor {

	// ---------------------------------------------------------------
	// ---------------------------------------------------------------

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.application.WorkbenchAdvisor#createWorkbenchWindowAdvisor (org.eclipse.ui.application.IWorkbenchWindowConfigurer)
	 */
	@Override
	public WorkbenchWindowAdvisor createWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
		return new ApplicationWorkbenchWindowAdvisor(configurer);
	}

	// ---------------------------------------------------------------

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.application.WorkbenchAdvisor#getInitialWindowPerspectiveId ()
	 */
	@Override
	public String getInitialWindowPerspectiveId() {
		return ExplorerCorePerspective.ID;
	}
}
