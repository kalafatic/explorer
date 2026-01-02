///*******************************************************************************
// * Copyright (c) 2010, Petr Kalafatic (gemini@kalafatic.eu).
// * All rights reserved. This program and the accompanying materials
// * are made available under the terms of the GNU GPL Version 3 
// * which accompanies this distribution, and is available at
// * http://www.gnu.org/licenses/gpl.txt  
// * 
// * Contributors:
// *     Petr Kalafatic - initial API and implementation
// ******************************************************************************/
//package eu.kalafatic.explorer.controller.utils;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.Inet4Address;
//import java.net.NetworkInterface;
//import java.util.Enumeration;
//import java.util.StringTokenizer;
//
//import org.eclipse.osgi.framework.internal.core.Tokenizer;
//
///**
// * The Class class ParseRoute.
// * @author Petr Kalafatic
// * @project Gemini
// * @version 3.0.0
// */
//public class ParseRoute {
//	
//	/** The _gateway. */
//	private String _gateway;
//	
//	/** The _ip. */
//	private String _ip;
//	
//	/** The _instance. */
//	private static ParseRoute _instance;
//
//	/**
//	 * The main method.
//	 * @param args the arguments
//	 */
//	public static void main(String[] args) {
//		try {
//			ParseRoute pr = ParseRoute.getInstance();
//			System.out.println("Gateway: " + pr.getGateway());
//			System.out.println("IP: " + pr.getLocalIPAddress());
//		} catch (Exception e) {
//			System.out.println(e);
//			e.printStackTrace();
//		}
//	}
//
//	/**
//	 * Instantiates a new parses the route.
//	 */
//	private ParseRoute() {
//		parse();
//	}
//
//	/**
//	 * Checks if is windows.
//	 * @return true, if is windows
//	 */
//	private static boolean isWindows() {
//		String os = System.getProperty("os.name").toUpperCase();
//		return os.contains("WINDOWS");
//	}
//
//	/**
//	 * Checks if is linux.
//	 * @return true, if is linux
//	 */
//	private static boolean isLinux() {
//		String os = System.getProperty("os.name").toUpperCase();
//		return os.contains("LINUX");
//	}
//
//	/**
//	 * Gets the local ip address.
//	 * @return the local ip address
//	 */
//	public String getLocalIPAddress() {
//		return _ip;
//	}
//
//	/**
//	 * Gets the gateway.
//	 * @return the gateway
//	 */
//	public String getGateway() {
//		return _gateway;
//	}
//
//	/**
//	 * Gets the single instance of ParseRoute.
//	 * @return single instance of ParseRoute
//	 */
//	public static ParseRoute getInstance() {
//		if (_instance == null) {
//			_instance = new ParseRoute();
//		}
//		return _instance;
//	}
//
//	/**
//	 * Parses the.
//	 */
//	private void parse() {
//		if (isWindows()) {
//			parseWindows();
//		} else if (isLinux()) {
//			parseLinux();
//		}
//	}
//
//	/**
//	 * Parses the windows.
//	 */
//	private void parseWindows() {
//		try {
//			Process pro = Runtime.getRuntime().exec("cmd.exe /c route print");
//			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(pro.getInputStream()));
//
//			String line;
//			while ((line = bufferedReader.readLine()) != null) {
//				line = line.trim();
//				StringTokenizer tokenizer = new StringTokenizer(line, " ", true);
//
//				String[] tokens = new StringTokenizer.parse(line, ' ', true, true);// line.split(" ");
//				.
//					_gateway = tokens[2];
//					_ip = tokens[3];
//					return;
//				}
//			}
//			// pro.waitFor();
//		} catch (
///** The e. */
//IOException e) {
//			System.err.println(e);
//			e.printStackTrace();
//		}
//	}
//
//	/**
//	 * Parses the linux.
//	 */
//	private void parseLinux() {
//		try {
//			BufferedReader reader = new BufferedReader(new FileReader("/proc/net/route"));
//			String line;
//			while ((line = reader.readLine()) != null) {
//				line = line.trim();
//				String[] tokens = Tokenizer.parse(line, '\t', true, true);// line.split(" ");
//				if (tokens.length > 1 && tokens[1].equals("00000000")) {
//					String gateway = tokens[2]; // 0102A8C0
//					if (gateway.length() == 8) {
//						String[] s4 = new String[4];
//						s4[3] = String.valueOf(Integer.parseInt(gateway.substring(0, 2), 16));
//						s4[2] = String.valueOf(Integer.parseInt(gateway.substring(2, 4), 16));
//						s4[1] = String.valueOf(Integer.parseInt(gateway.substring(4, 6), 16));
//						s4[0] = String.valueOf(Integer.parseInt(gateway.substring(6, 8), 16));
//						_gateway = s4[0] + "." + s4[1] + "." + s4[2] + "." + s4[3];
//					}
//					String iface = tokens[0];
//					NetworkInterface nif = NetworkInterface.getByName(iface);
//					Enumeration addrs = nif.getInetAddresses();
//					while (addrs.hasMoreElements()) {
//						Object obj = addrs.nextElement();
//						if (obj instanceof Inet4Address) {
//							_ip = obj.toString();
//							if (_ip.startsWith("/")) {
//								_ip = _ip.substring(1);
//							}
//							return;
//						}
//					}
//					return;
//				}
//			}
//			reader.close();
//		} catch (IOException e) {
//			System.err.println(e);
//			e.printStackTrace();
//		}
//	}
//
// }
