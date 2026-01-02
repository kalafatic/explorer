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
package eu.kalafatic.explorer.controller.model.workers;

import java.util.Observable;

/**
 * The Class class Task.
 * @author Petr Kalafatic
 * @project Gemini
 * @version 3.0.0
 */
public abstract class Task extends Observable implements Runnable {

	/** The parameters. */
	protected Object[] parameters;

	/** The result. */
	protected Object result;

	// ---------------------------------------------------------------
	// ---------------------------------------------------------------
	/**
	 * Instantiates a new task.
	 * @param parameters the parameters
	 */
	public Task(Object... parameters) {
		this.parameters = parameters;
	}

	// ---------------------------------------------------------------

	/**
	 * Gets the result.
	 * @return the result
	 */
	public Object getResult() {
		return result;
	}
}