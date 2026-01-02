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
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * The Class class NetworkScan.
 * @author Petr Kalafatic
 * @project Gemini
 * @version 3.0.0
 */
public class NetworkScan implements Runnable {

	/** The devices. */
	static Map devices = null;

	/** The flag. */
	String flag = "30";

	// search for local IP that is not 127.0.0.1 (other methods are not
	// reliable)
	/**
	 * Gets the local address.
	 * @return the local address
	 */
	public String[] getLocalAddress() {
		Enumeration<NetworkInterface> nets;
		try {
			nets = NetworkInterface.getNetworkInterfaces();
		} catch (SocketException e) {
			return null;
		}
		for (NetworkInterface netint : Collections.list(nets)) {
			Enumeration<InetAddress> inetAddresses = netint.getInetAddresses();
			for (InetAddress inetAddress : Collections.list(inetAddresses)) {
				if (!inetAddress.isLoopbackAddress()
						&& inetAddress
								.getHostAddress()
								.matches(
										"(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)")) {
					// System.out.println("IP Address:"+inetAddress.getHostAddress());
					return inetAddress.getHostAddress().split("\\.");
				}
			}
		}
		return null;
	}

	/**
	 * Update.
	 * @return the string
	 */
	public String Update() {
		// System.out.println("nnnnnn ############################################ update########################################################################");
		String devicesData = "";
		if (devices != null && !devices.isEmpty()) {
			Set s = devices.entrySet();
			Iterator i = s.iterator();

			while (i.hasNext()) { // System.out.println("Devices"+i.next());

				// System.out.println(i.next());
				String[] tmp = i.next().toString().split("=");

				devicesData += "," + tmp[0] + ":" + tmp[1];
				/*
				 * try { if (InetAddress.getByName(tmp[0]).isReachable(1000)) {
				 * devicesData+=tmp[0]+":"+tmp[1]+":Active,"; } else {
				 * devicesData+=tmp[0]+":"+tmp[1]+":InActive,"; } } catch
				 * (UnknownHostException e) { // TODO Auto-generated catch block
				 * e.printStackTrace(); } catch (IOException e) { // TODO
				 * Auto-generated catch block e.printStackTrace(); }
				 */

			}
		}
		// System.out.println("################################################################################################################"+devicesData);
		return devicesData;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// System.out.println("Running..."+flag);
		if (devices == null) {
			devices = new HashMap();
			// System.out.println("Map Created...");
		}
		String startIP, stopIP;
		String[] local = getLocalAddress();

		collectDeviceDetailsThreaad(local, "1", "7");

		System.out.println(flag + " milli sec-->" + System.currentTimeMillis());
		switch (Integer.parseInt(flag)) {

		case 1:
			collectDeviceDetailsThreaad(local, "1", "7");
			break;
		case 2:
			collectDeviceDetailsThreaad(local, "8", "15");
			break;
		case 3:
			collectDeviceDetailsThreaad(local, "16", "22");
			break;
		case 4:
			collectDeviceDetailsThreaad(local, "23", "29");
			break;
		case 5:
			collectDeviceDetailsThreaad(local, "30", "36");
			break;
		case 6:
			collectDeviceDetailsThreaad(local, "37", "43");
			break;
		case 7:
			collectDeviceDetailsThreaad(local, "44", "50");
			break;
		case 8:
			collectDeviceDetailsThreaad(local, "51", "57");
			break;
		case 9:
			collectDeviceDetailsThreaad(local, "58", "64");
			break;
		case 10:
			collectDeviceDetailsThreaad(local, "65", "71");
			break;
		case 11:
			collectDeviceDetailsThreaad(local, "72", "78");
			break;
		case 12:
			collectDeviceDetailsThreaad(local, "79", "85");
			break;
		case 13:
			collectDeviceDetailsThreaad(local, "86", "92");
			break;
		case 14:
			collectDeviceDetailsThreaad(local, "93", "99");
			break;
		case 15:
			collectDeviceDetailsThreaad(local, "100", "106");
			break;
		case 16:
			collectDeviceDetailsThreaad(local, "107", "113");
			break;
		case 17:
			collectDeviceDetailsThreaad(local, "114", "120");
			break;
		case 18:
			collectDeviceDetailsThreaad(local, "121", "127");
			break;
		case 19:
			collectDeviceDetailsThreaad(local, "128", "134");
			break;
		case 20:
			collectDeviceDetailsThreaad(local, "135", "141");
			break;
		case 21:
			collectDeviceDetailsThreaad(local, "142", "148");
			break;
		case 22:
			collectDeviceDetailsThreaad(local, "149", "155");
			break;
		case 23:
			collectDeviceDetailsThreaad(local, "156", "162");
			break;
		case 24:
			collectDeviceDetailsThreaad(local, "163", "169");
			break;
		case 25:
			collectDeviceDetailsThreaad(local, "170", "176");
			break;
		case 26:
			collectDeviceDetailsThreaad(local, "177", "183");
			break;
		case 27:
			collectDeviceDetailsThreaad(local, "184", "190");
			break;
		case 28:
			collectDeviceDetailsThreaad(local, "191", "197");
			break;
		case 29:
			collectDeviceDetailsThreaad(local, "198", "204");
			break;
		case 30:
			collectDeviceDetailsThreaad(local, "205", "211");
			break;
		case 31:
			collectDeviceDetailsThreaad(local, "212", "218");
			break;
		case 32:
			collectDeviceDetailsThreaad(local, "219", "225");
			break;
		case 33:
			collectDeviceDetailsThreaad(local, "226", "232");
			break;
		case 34:
			collectDeviceDetailsThreaad(local, "233", "239");
			break;
		case 35:
			collectDeviceDetailsThreaad(local, "240", "247");
			break;
		case 36:
			collectDeviceDetailsThreaad(local, "248", "255");
			break;

		}

	}

	/**
	 * Collect device details threaad.
	 * @param local the local
	 * @param startingIP the starting ip
	 * @param endingIP the ending ip
	 */
	public void collectDeviceDetailsThreaad(String[] local, String startingIP, String endingIP) {

		// String startIP, stopIP;
		//
		// // startIP="192.168.1.1";
		// startIP = local[0] + "." + local[1] + "." + local[2] + "." +
		// startingIP;
		// stopIP = local[0] + "." + local[1] + "." + local[2] + "." + endingIP;
		// String[] from = startIP.split("\\.");
		// String[] to = stopIP.split("\\.");
		// int[] start = new int[4], stop = new int[4];
		// for (int i = 0; i < 4; i++) {
		// start[i] = Integer.parseInt(from[i]);
		// stop[i] = Integer.parseInt(to[i]);
		// }
		// for (int a = start[0]; a <= stop[0]; a++) {
		// for (int b = start[1]; b <= stop[1]; b++) {
		// for (int c = start[2]; c <= stop[2]; c++) {
		// for (int d = start[3]; d <= stop[3]; d++) {
		// // if (!run) return;
		// try {
		//
		// if (InetAddress.getByName(a + "." + b + "." + c + "." +
		// d).isReachable(
		// 2000)) {
		//
		// devices.put(a + "." + b + "." + c + "." + d,
		// InetAddress.getByName(a + "." + b + "." + c + "." + d)
		// .getHostName() + ":Active");
		//
		// } else {
		// if (devices.containsKey(a + "." + b + "." + c + "." + d)) {
		//
		// devices.put(a + "." + b + "." + c + "." + d, InetAddress
		// .getByName(a + "." + b + "." + c + "." + d)
		// .getHostName()
		// + ":InActive");
		//
		// }
		// }
		// } catch (IOException e) {
		//
	}
}