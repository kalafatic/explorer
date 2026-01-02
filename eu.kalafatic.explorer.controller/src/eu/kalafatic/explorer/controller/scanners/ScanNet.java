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

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;

/**
 * The Class class ScanNet.
 * @author Petr Kalafatic
 * @project Gemini
 * @version 3.0.0
 */
public class ScanNet {

	/**
	 * The main method.
	 * @param args the arguments
	 * @throws Exception the exception
	 */
	public static void main(String[] args) throws Exception {
		InetAddress localHost = Inet4Address.getLocalHost();
		NetworkInterface networkInterface = NetworkInterface.getByInetAddress(localHost);
		String ipAddress = localHost.getHostAddress();
		int[] bounds = ScanNet.rangeFromCidr(ipAddress + "/12");
		// int[] bounds = ScanNet.rangeFromCidr("169.254.42.0/16");

		for (int i = bounds[0]; i <= bounds[1]; i++) {
			String address = InetRange.intToIp(i);
			InetAddress ip = InetAddress.getByName(address);

			if (ip.isReachable(100)) { // Try for one tenth of a second
				System.out.printf("Address %s is reachable\n", ip);
			}
		}

		System.err.println();
	}

	/**
	 * Range from cidr.
	 * @param cidrIp the cidr ip
	 * @return the int[]
	 */
	public static int[] rangeFromCidr(String cidrIp) {
		int maskStub = 1 << 31;
		String[] atoms = cidrIp.split("/");
		int mask = Integer.parseInt(atoms[1]);
		System.out.println(mask);

		int[] result = new int[2];
		result[0] = InetRange.ipToInt(atoms[0]) & (maskStub >> (mask - 1)); // lower
																			// bound
		result[1] = InetRange.ipToInt(atoms[0]); // upper bound
		System.out.println(InetRange.intToIp(result[0]));
		System.out.println(InetRange.intToIp(result[1]));

		return result;
	}

	/**
	 * The Class class InetRange.
	 * @author Petr Kalafatic
	 * @project Gemini
	 * @version 3.0.0
	 */
	static class InetRange {

		/**
		 * Ip to int.
		 * @param ipAddress the ip address
		 * @return the int
		 */
		public static int ipToInt(String ipAddress) {
			try {
				byte[] bytes = InetAddress.getByName(ipAddress).getAddress();
				int octet1 = (bytes[0] & 0xFF) << 24;
				int octet2 = (bytes[1] & 0xFF) << 16;
				int octet3 = (bytes[2] & 0xFF) << 8;
				int octet4 = bytes[3] & 0xFF;
				int address = octet1 | octet2 | octet3 | octet4;

				return address;
			} catch (Exception e) {
				e.printStackTrace();

				return 0;
			}
		}

		/**
		 * Int to ip.
		 * @param ipAddress the ip address
		 * @return the string
		 */
		public static String intToIp(int ipAddress) {
			int octet1 = (ipAddress & 0xFF000000) >>> 24;
			int octet2 = (ipAddress & 0xFF0000) >>> 16;
			int octet3 = (ipAddress & 0xFF00) >>> 8;
			int octet4 = ipAddress & 0xFF;

			return new StringBuffer().append(octet1).append('.').append(octet2).append('.').append(octet3).append('.').append(octet4).toString();
		}
	}
}
