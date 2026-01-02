package eu.kalafatic.explorer.core.utils;

import java.net.InetAddress;

public class NetScanner implements Runnable {
	String str;
	int nub;

	public NetScanner(String str, int nub) {
		this.str = str;
		this.nub = nub;
	}

	@Override
	public void run() {
		try {
			for (int i = nub; i < nub + 10; i++) {

				System.out.println(".......");
				System.out.println(str);
				System.out.println(nub);
				if (InetAddress.getByName(str + "." + i).isReachable(1000)) {
					System.err.println("host" + str + "." + i + "is connected");
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		// System.out.println("give subnet");
		// Scanner out = new Scanner(System.in);
		// NetScanner n = new NetScanner(out.next());
		Thread t[] = new Thread[25];
		for (int i = 0; i < 10; i++) {
			t[i] = new Thread(new NetScanner("169.254.42", i * 10));
			// t[i] = new Thread(new NetScanner("10.124.168",i*10));
		}
		for (int i = 0; i < 25; i++) {
			t[i].start();
		}

	}

}