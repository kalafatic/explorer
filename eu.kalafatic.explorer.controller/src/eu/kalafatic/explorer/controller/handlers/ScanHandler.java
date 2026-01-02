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
package eu.kalafatic.explorer.controller.handlers;

import java.util.Set;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.handlers.HandlerUtil;

import eu.kalafatic.explorer.controller.dialogs.ScanPortsDialog;
import eu.kalafatic.explorer.controller.dialogs.ScanSubnetDialog;
import eu.kalafatic.explorer.controller.model.ExplorerModelManager;
import eu.kalafatic.explorer.controller.utils.ScanUtils;
import eu.kalafatic.explorer.model.explorer.Device;
import eu.kalafatic.explorer.model.explorer.ExplorerFactory;
import eu.kalafatic.explorer.model.explorer.Port;

/**
 * The Class class ScanHandler.
 * @author Petr Kalafatic
 * @project Gemini
 * @version 3.0.0
 */
public class ScanHandler extends AbstractHandler {

	/** The SCA n_ parameter. */
	public final String SCAN_PARAMETER = "eu.kalafatic.explorer.controller.handlers.ScanHandler.SCAN_PARAMETER";

	// ---------------------------------------------------------------
	// ---------------------------------------------------------------
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands .ExecutionEvent)
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		try {
			ISelection selection = HandlerUtil.getCurrentSelection(event);

			if (selection instanceof IStructuredSelection) {
				Object firstElement = ((IStructuredSelection) selection).getFirstElement();

				String parameter = event.getParameter(SCAN_PARAMETER);

//				if (firstElement == null) {
//					ScanPortsDialog scanPortsDialog = new ScanPortsDialog();
//					int open = scanPortsDialog.open();
//					final Device device = ExplorerFactory.eINSTANCE.createDevice();
////					device.setIp(scanPortsDialog.getAddress().getHostAddress());
////					device.setHost(scanPortsDialog.getAddress().getHostName());
////					firstElement = device;
////
////					ExplorerModelManager.getInstance().getModel().getChildren().put(device.getHost(), device);
//
//				}

				if (parameter.equals("openPorts")) {

					ScanPortsDialog scanPortsDialog = new ScanPortsDialog(firstElement);
					int result = scanPortsDialog.open();
					if (result  == Window.OK) {
						final Device device = ExplorerFactory.eINSTANCE.createDevice();
						device.setIp(scanPortsDialog.getHost());
						device.setHost(scanPortsDialog.getHost());
						setOpenPorts(device, scanPortsDialog.getPortsToScan());

						ExplorerModelManager.getInstance().getModel().getChildren().put(device.getHost(), device);
						ScanUtils.scanOpenPorts(device);
					}
				} else if (parameter.equals("subnet")) {
					ScanSubnetDialog scanPortsDialog = new ScanSubnetDialog(firstElement);
					int result = scanPortsDialog.open();
					if (result  == Window.OK) {
						final Device device = ExplorerFactory.eINSTANCE.createDevice();
						device.setIp(scanPortsDialog.getHost());
						device.setHost(scanPortsDialog.getHost());
						setOpenPorts(device, scanPortsDialog.getPortsToScan());

						ExplorerModelManager.getInstance().getModel().getChildren().put(device.getHost(), device);
						ScanUtils.scanSubnet(device);
					}

				} else if (parameter.equals("net")) {

					ScanSubnetDialog scanPortsDialog = new ScanSubnetDialog(firstElement);
					int result = scanPortsDialog.open();
					if (result  == Window.OK) {
						final Device device = ExplorerFactory.eINSTANCE.createDevice();
						device.setIp(scanPortsDialog.getHost());
						device.setHost(scanPortsDialog.getHost());
						setOpenPorts(device, scanPortsDialog.getPortsToScan());

						ExplorerModelManager.getInstance().getModel().getChildren().put(device.getHost(), device);
						ScanUtils.scanSubnet(device);
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// ---------------------------------------------------------------

	void setOpenPorts(Device device, Set<Integer> portNumbers) {
		for (Integer integer : portNumbers) {
			Port port = ExplorerFactory.eINSTANCE.createPort();
			port.setNumber(integer);

			device.getOpenPorts().put(integer, port);
		}
	}

}