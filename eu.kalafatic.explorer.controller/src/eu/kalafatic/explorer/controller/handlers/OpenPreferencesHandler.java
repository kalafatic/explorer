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
package eu.kalafatic.explorer.controller.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import eu.kalafatic.explorer.model.explorer.Node;

/**
 * The Class class OpenPreferencesHandler.
 * @author Petr Kalafatic
 * @project Gemini
 * @version 3.0.0
 */
public class OpenPreferencesHandler extends AbstractHandler {

	/** The PREFERENCE s_ parameter. */
	public final String PREFERENCES_PARAMETER = "eu.kalafatic.explorer.controller.handlers.PREFERENCES_PARAMETER";

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands .ExecutionEvent)
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);

		if (selection instanceof IStructuredSelection) {
			Object firstElement = ((IStructuredSelection) selection).getFirstElement();

			String parameter = event.getParameter(PREFERENCES_PARAMETER);

			if (parameter.equals("scan")) {
				if (firstElement instanceof Node) {

					// scanOpenPorts((Node) firstElement);
				}
			} else if (parameter.equals("subnet")) {
				// scanReachableNeighbors((Node) firstElement);
				// openPortRangeDialog();
			} else if (parameter.equals("subnet")) {

			}

		}
		// ConsoleUtils.printToConsole("", "dd");
		return null;
	}
}
