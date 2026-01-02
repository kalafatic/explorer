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
 * The Class class SaveHandler.
 * @author Petr Kalafatic
 * @project Gemini
 * @version 3.0.0
 */
public class SaveHandler extends AbstractHandler {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands
	 * .ExecutionEvent)
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		try {
			ISelection selection = HandlerUtil.getCurrentSelection(event);

			if (selection instanceof IStructuredSelection) {
				Object firstElement = ((IStructuredSelection) selection).getFirstElement();

				if (firstElement instanceof Node) {
					// ModelUtils.doSave((Node) firstElement);
					((Node) firstElement).eResource().save(null);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
