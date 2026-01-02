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

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import eu.kalafatic.utils.eclipse.ConsoleUtils;

/**
 * The Class class ScanTask.
 * @author Petr Kalafatic
 * @project Gemini
 * @version 3.0.0
 */
public class ScanTask extends Task {

	/** The host. */
	private String host;

	/** The timeout. */
	private int port, timeout;

	/**
	 * Instantiates a new scan task.
	 * @param parameters the parameters
	 */
	public ScanTask(Object... parameters) {
		super(parameters);
		try {
			this.host = InetAddress.getByName((String) parameters[0]).getHostName();
			this.port = (int) parameters[1];
			this.timeout = (int) parameters[2];
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

	/*
	 * (non-Javadoc)
	 * @see eu.kalafatic.explorer.controller.factories.ExecutorFactory.Task#run()
	 */
	@Override
	public void run() {
		try {
			Socket socket = new Socket();
			// System.err.println("ScanPortTask-" + ip + ":" + port);

			ConsoleUtils.INSTANCE.printToConsole("Console", "ScanPortTask-" + host + ":" + port);

			socket.connect(new InetSocketAddress(host, port), timeout);
			socket.close();
			result = socket;
			setChanged();
			notifyObservers(this);
		} catch (Exception ex) {}
	}
}
