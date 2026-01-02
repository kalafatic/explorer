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
package eu.kalafatic.explorer.controller.scanners;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * The Class class PrecisePortScanner.
 * @author Petr Kalafatic
 * @project Gemini
 * @version 3.0.0
 */
public class PrecisePortScanner {

	/**
	 * The main method.
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		String host = "localhost";

		try {
			String hostAddress = InetAddress.getLocalHost().getHostAddress();
			System.out.println(InetAddress.getLocalHost().getHostAddress());
			InetAddress theAddress = InetAddress.getByName(host);
			boolean[] ports = new boolean[65536];
			for (int i = 1; i < 65536; i++) {
				try {
					Socket theSocket = new Socket(host, i);
					System.out.println("There is a server on port " + i + " of " + host);
					theSocket.close();
				} catch (IOException e) {
					// unexpected error
				}
			} // end for

		} // end try
		catch (UnknownHostException e) {
			System.err.println(e);
		}

	} // end main

} // end PortScanner
