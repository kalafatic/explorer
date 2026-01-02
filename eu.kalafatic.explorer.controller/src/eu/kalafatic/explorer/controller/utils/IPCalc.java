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
package eu.kalafatic.explorer.controller.utils;


/**
 * The Class class IPCalc.
 * @author Petr Kalafatic
 * @project Gemini
 * @version 3.0.0
 */
public class IPCalc {

	/** The base i pnumeric. */
	private int baseIPnumeric;
	
	/** The netmask numeric. */
	private int netmaskNumeric;
	// used for host range
	/** The first ip. */
	private String firstIP;
	
	/** The last ip. */
	private String lastIP;

	/**
	 * Instantiates a new iP calc.
	 * @param IPinCIDRFormat the i pin cidr format
	 * @throws NumberFormatException the number format exception
	 */
	public IPCalc(String IPinCIDRFormat) throws NumberFormatException {

		String[] st = IPinCIDRFormat.split("\\/");
		if (st.length != 2) {
			throw new NumberFormatException("Invalid CIDR format '" + IPinCIDRFormat + "', should be: xx.xx.xx.xx/xx");
		}
		String symbolicIP = st[0];
		String symbolicCIDR = st[1];

		Integer numericCIDR = new Integer(symbolicCIDR);
		if (numericCIDR > 32) {
			throw new NumberFormatException("CIDR can not be greater than 32");
		}

		// Get IP
		st = symbolicIP.split("\\.");
		if (st.length != 4) {
			throw new NumberFormatException("Invalid IP address: " + symbolicIP);
		}

		int i = 24;
		baseIPnumeric = 0;

		for (int n = 0; n < st.length; n++) {
			int value = Integer.parseInt(st[n]);
			if (value != (value & 0xff)) {
				throw new NumberFormatException("Invalid IP address: " + symbolicIP);
			}
			baseIPnumeric += value << i;
			i -= 8;
		}

		// Get netmask
		if (numericCIDR < 8) {
			throw new NumberFormatException("Netmask CIDR can not be less than 8");
		}
		netmaskNumeric = 0xffffffff;
		netmaskNumeric = netmaskNumeric << (32 - numericCIDR);
	}

	/**
	 * Gets the iP.
	 * @return the iP
	 */
	public String getIP() {
		return convertNumericIpToSymbolic(baseIPnumeric);
	}

	/**
	 * Convert numeric ip to symbolic.
	 * @param ip the ip
	 * @return the string
	 */
	private String convertNumericIpToSymbolic(Integer ip) {
		StringBuffer sb = new StringBuffer(15);
		for (int shift = 24; shift > 0; shift -= 8) {
			// process 3 bytes, from high order byte down.
			sb.append(Integer.toString((ip >>> shift) & 0xff));
			sb.append('.');
		}
		sb.append(Integer.toString(ip & 0xff));
		return sb.toString();
	}

	/**
	 * Gets the netmask.
	 * @return the netmask
	 */
	public String getNetmask() {
		StringBuffer sb = new StringBuffer(15);
		for (int shift = 24; shift > 0; shift -= 8) {
			// process 3 bytes, from high order byte down.
			sb.append(Integer.toString((netmaskNumeric >>> shift) & 0xff));
			sb.append('.');
		}
		sb.append(Integer.toString(netmaskNumeric & 0xff));
		return sb.toString();
	}

	/**
	 * Gets the host address range.
	 * @return the host address range
	 */
	public void getHostAddressRange() {

		int numberOfBits;
		for (numberOfBits = 0; numberOfBits < 32; numberOfBits++) {
			if ((netmaskNumeric << numberOfBits) == 0) {
				break;
			}
		}
		Integer numberOfIPs = 0;
		for (int n = 0; n < (32 - numberOfBits); n++) {
			numberOfIPs = numberOfIPs << 1;
			numberOfIPs = numberOfIPs | 0x01;
		}

		Integer baseIP = baseIPnumeric & netmaskNumeric;
		firstIP = convertNumericIpToSymbolic(baseIP + 1);
		lastIP = convertNumericIpToSymbolic(baseIP + numberOfIPs - 1);
	}

	/**
	 * Gets the number of hosts.
	 * @return the number of hosts
	 */
	public Long getNumberOfHosts() {
		int numberOfBits;
		for (numberOfBits = 0; numberOfBits < 32; numberOfBits++) {
			if ((netmaskNumeric << numberOfBits) == 0) {
				break;
			}
		}
		Double x = Math.pow(2, (32 - numberOfBits));
		if (x == -1) {
			x = 1D;
		}
		return x.longValue();
	}

	/**
	 * Gets the wildcard mask.
	 * @return the wildcard mask
	 */

	public String getWildcardMask() {
		Integer wildcardMask = netmaskNumeric ^ 0xffffffff;
		StringBuffer sb = new StringBuffer(15);
		for (int shift = 24; shift > 0; shift -= 8) {
			// process 3 bytes, from high order byte down.
			sb.append(Integer.toString((wildcardMask >>> shift) & 0xff));
			sb.append('.');
		}
		sb.append(Integer.toString(wildcardMask & 0xff));
		return sb.toString();

	}

	/**
	 * Gets the broadcast address.
	 * @return the broadcast address
	 */
	public String getBroadcastAddress() {
		if (netmaskNumeric == 0xffffffff) {
			return "0.0.0.0";
		}
		int numberOfBits;
		for (numberOfBits = 0; numberOfBits < 32; numberOfBits++) {
			if ((netmaskNumeric << numberOfBits) == 0) {
				break;
			}
		}
		Integer numberOfIPs = 0;
		for (int n = 0; n < (32 - numberOfBits); n++) {
			numberOfIPs = numberOfIPs << 1;
			numberOfIPs = numberOfIPs | 0x01;
		}
		Integer baseIP = baseIPnumeric & netmaskNumeric;
		Integer ourIP = baseIP + numberOfIPs;
		String ip = convertNumericIpToSymbolic(ourIP);
		return ip;
	}

	/**
	 * Show ip net.
	 * @param ipCidr the ip cidr
	 * @return the string
	 */
	public String showIpNet(String ipCidr) {

		String st[] = ipCidr.split("\\/");
		String symbolicIP = st[0];

		// IPCalcView gui = new IPCalcView();

		String symbolicCIDR = st[1];
		Integer numericCIDR = new Integer(symbolicCIDR);
		if (numericCIDR > 32) {
			// gui.label2.setText("CIDR can not be greater than 32");
			if (numericCIDR < 8) {
				// gui.label2.setText("Netmask CIDR can not be less than 8");
				netmaskNumeric = 0xffffffff;
			}
		}
		netmaskNumeric = netmaskNumeric << (32 - numericCIDR);
		String symbolicNet = this.getNetmask();

		return "IP Address: " + symbolicIP + "\n" + "Netmask: " + symbolicNet + "\n";

	} // close showIpCidr

	/**
	 * Show broadcast.
	 * @return the string
	 */
	public String showBroadcast() {
		String broadcast = this.getBroadcastAddress();
		return "Broadcast: " + broadcast + "\n";
	}

	/**
	 * Show wildcard.
	 * @return the string
	 */
	public String showWildcard() {
		String wildcard = this.getWildcardMask();
		return "Wildcard: " + wildcard + "\n";
	}

	/**
	 * Show num hosts.
	 * @return the string
	 */
	public String showNumHosts() {
		Long numberOfHosts = this.getNumberOfHosts() - 2;
		return "Number of Hosts in Range: " + numberOfHosts + "\n";
	}

	/**
	 * Show first and last.
	 * @return the string
	 */
	public String showFirstAndLast() {
		this.getHostAddressRange();
		String firstIP = this.firstIP;
		String LastIP = this.lastIP;
		return "First Available Host: " + firstIP + "\n" + "Last Available " + "Host: " + lastIP + "\n";
	}

}
