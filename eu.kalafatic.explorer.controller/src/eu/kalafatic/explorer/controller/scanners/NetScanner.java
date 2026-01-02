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

import java.net.InetAddress;

/**
 * The Class class NetScanner.
 * @author Petr Kalafatic
 * @project Gemini
 * @version 3.0.0
 */
public class NetScanner implements Runnable {

	/** The str. */
	String str;

	/** The nub. */
	int nub;

	/**
	 * Instantiates a new net scanner.
	 * @param str the str
	 * @param nub the nub
	 */
	public NetScanner(String str, int nub) {
		this.str = str;
		this.nub = nub;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		try {
			for (int i = nub; i < nub + 10; i++) {

				System.out.println(".......");
				System.out.println(str);
				System.out.println(nub);
				if (InetAddress.getByName(str + "." + i).isReachable(1000)) {
					System.err.println("host" + str + "." + i + " is connected");
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * The main method.
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// System.out.println("give subnet");
		// Scanner out = new Scanner(System.in);
		// NetScanner n = new NetScanner(out.next());
		Thread t[] = new Thread[25];
		for (int i = 0; i < 10; i++) {
			t[i] = new Thread(new NetScanner("192.168.2", i * 10));
			// t[i] = new Thread(new NetScanner("10.124.168",i*10));
		}
		for (int i = 0; i < 25; i++) {
			t[i].start();
		}

	}

}