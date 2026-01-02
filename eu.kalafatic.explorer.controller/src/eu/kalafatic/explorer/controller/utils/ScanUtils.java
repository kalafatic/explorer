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

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import eu.kalafatic.explorer.controller.factories.ExecutorFactory;
import eu.kalafatic.explorer.controller.model.workers.ScanTask;
import eu.kalafatic.explorer.controller.model.workers.Task;
import eu.kalafatic.explorer.controller.model.workers.TaskObserver;
import eu.kalafatic.explorer.model.explorer.Device;
import eu.kalafatic.explorer.model.explorer.ExplorerFactory;
import eu.kalafatic.explorer.model.explorer.Port;
import eu.kalafatic.utils.net.SubnetUtils;

/**
 * The Class class ScanUtils.
 * @author Petr Kalafatic
 * @project Gemini
 * @version 3.0.0
 */
public class ScanUtils {

	/** The Constant INSTANCE. */
	public static final ScanUtils INSTANCE = new ScanUtils();

	// ---------------------------------------------------------------
	// ---------------------------------------------------------------

	/**
	 * Scan open ports.
	 * @param device the device
	 */
	public static void scanOpenPorts(final Device device) {
		TaskObserver observer = new TaskObserver() {
			@Override
			public void update(Observable o, Object arg) {
				try {
					Task t = (Task) o;
					Socket socket = (Socket) t.getResult();

					synchronized (device) {
						Port port=ExplorerFactory.eINSTANCE.createPort();
						port.setNumber(socket.getPort());
						device.getOpenPorts().put(socket.getPort(), port);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		List<Task> taskList = new ArrayList<Task>();

		for (Port port : device.getOpenPorts().values()) {
			Task task = new ScanTask(device.getHost(), port.getNumber(), 200);
			task.addObserver(observer);
			taskList.add(task);
		}
		ExecutorFactory.execute(taskList);
	}

	// ---------------------------------------------------------------

	/**
	 * Scan subnet.
	 * @param device the device
	 */
	public static void scanSubnet(final Device device) {
		TaskObserver observer = new TaskObserver() {
			@Override
			public void update(Observable o, Object arg) {
				try {
					Task t = (Task) o;
					Socket socket = (Socket) t.getResult();

					Device childNode = ExplorerFactory.eINSTANCE.createDevice();
					childNode.setIp(socket.getRemoteSocketAddress().toString());
					childNode.setHost(socket.getRemoteSocketAddress().toString());
					childNode.setParent(device);

					synchronized (device.getChildren()) {
						device.getChildren().put(socket.getRemoteSocketAddress().toString(), childNode);

					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		List<Task> taskList = new ArrayList<Task>();

		SubnetUtils subnetUtils = new SubnetUtils(device.getIp() + "/" + device.getMask());
		String[] allAddresses = subnetUtils.getInfo().getAllAddresses();

		for (String adress : allAddresses) {
			Task task = new ScanTask(adress, device.getPort(), 500);
			task.addObserver(observer);
			taskList.add(task);
		}
		ExecutorFactory.execute(taskList);
	}

	// ---------------------------------------------------------------

	/**
	 * Scan net.
	 * @param device the device
	 */
	private void scanNet(final Device device) {
		TaskObserver observer = new TaskObserver() {
			@Override
			public void update(Observable o, Object arg) {
				try {
					Task t = (Task) o;
					Socket socket = (Socket) t.getResult();

					Device childNode = ExplorerFactory.eINSTANCE.createDevice();
					childNode.setIp(socket.getRemoteSocketAddress().toString());
					childNode.setHost(socket.getRemoteSocketAddress().toString());
					childNode.setParent(device);

					synchronized (device.getChildren()) {
						device.getChildren().put(socket.getRemoteSocketAddress().toString(), childNode);

					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		List<Task> taskList = new ArrayList<Task>();

		SubnetUtils subnetUtils = new SubnetUtils(device.getIp() + "/" + device.getMask());
		String[] allAddresses = subnetUtils.getInfo().getAllAddresses();

		for (String adress : allAddresses) {
			Task task = new ScanTask(adress, device.getPort(), 500);
			task.addObserver(observer);
			taskList.add(task);
		}
		ExecutorFactory.execute(taskList);
	}

}
