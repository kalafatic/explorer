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
package eu.kalafatic.explorer.controller.factories;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

import eu.kalafatic.explorer.controller.Activator;
import eu.kalafatic.explorer.controller.model.workers.Task;

/**
 * A factory for creating Executor objects.
 */
public class ExecutorFactory {

	/**
	 * Creates a new Executor object.
	 * @return the thread pool executor
	 */
	public static ThreadPoolExecutor createExecutor() {
		return createExecutor(10);
	}

	/**
	 * Creates a new Executor object.
	 * @param timeout the timeout
	 * @return the thread pool executor
	 */
	public static ThreadPoolExecutor createExecutor(long timeout) {
		return createExecutor(16, 64, timeout);
	}

	/**
	 * Creates a new Executor object.
	 * @param corePoolSize the core pool size
	 * @param maxPoolSize the max pool size
	 * @param timeout the timeout
	 * @return the thread pool executor
	 */
	public static ThreadPoolExecutor createExecutor(int corePoolSize, int maxPoolSize, long timeout) {
		return new ThreadPoolExecutor(corePoolSize, maxPoolSize, timeout, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), Executors.defaultThreadFactory());
	}

	/**
	 * Execute.
	 * @param taskList the task list
	 */
	public static void execute(final List<Task> taskList) {
		Job job = new Job("Executor") {

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				monitor.beginTask("Executor is scanning...", 100);

				ThreadPoolExecutor executor = createExecutor();
				int percent = 1;
				executor.getQueue().addAll(taskList);
				executor.prestartAllCoreThreads();
				executor.shutdown();

				while (!executor.isTerminated()) {
					if (monitor.isCanceled()) {
						executor.shutdownNow();
						return new Status(IStatus.CANCEL, Activator.PLUGIN_ID, "Canceled");
					}
					if (executor.getCompletedTaskCount() > (percent * (taskList.size() / 100))) {
						monitor.worked(1);
						percent++;
					}
				}
				return new Status(IStatus.OK, Activator.PLUGIN_ID, "Finished all threads");
			}

		};
		job.schedule();
	}

	/**
	 * Port is open.
	 * @param es the es
	 * @param ip the ip
	 * @param port the port
	 * @param timeout the timeout
	 * @return the future
	 */
	public static Future<Boolean> portIsOpen(final ExecutorService es, final String ip, final int port, final int timeout) {
		return es.submit(new Callable<Boolean>() {
			@Override
			public Boolean call() {
				try {
					Socket socket = new Socket();
					socket.connect(new InetSocketAddress(ip, port), timeout);
					System.err.println(port);
					socket.close();
					return true;
				} catch (Exception ex) {
					return false;
				}
			}
		});
	}

	/**
	 * Run port scanner.
	 */
	public static void runPortScanner() {
		final ExecutorService es = Executors.newFixedThreadPool(20);
		final String ip = "127.0.0.1";
		final int timeout = 200;
		final List<Future<Boolean>> futures = new ArrayList<>();
		// for (int port = 1; port <= 65535; port++) {
		for (int port = 1; port <= 2054; port++) {
			futures.add(portIsOpen(es, ip, port, timeout));
		}
		es.shutdown();
		int openPorts = 0;
		try {
			for (final Future<Boolean> f : futures) {
				if (f.get()) {
					openPorts++;
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		System.out.println("There are " + openPorts + " open ports on host " + ip + " (probed with a timeout of " + timeout + "ms)");
	}

	public static void main(String[] args) {
		runPortScanner();
	}
}
