package eu.kalafatic.explorer.core.utils;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class PrecisePortScanner {

	public static void main(String[] args) {

		String host = "localhost";

		if (args.length > 0) {
			host = args[0];
		}

		try {
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
