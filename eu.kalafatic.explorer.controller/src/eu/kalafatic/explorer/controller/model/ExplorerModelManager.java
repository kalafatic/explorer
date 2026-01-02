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
package eu.kalafatic.explorer.controller.model;

import java.net.InetAddress;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import eu.kalafatic.explorer.controller.utils.Utils;
import eu.kalafatic.explorer.model.explorer.Device;
import eu.kalafatic.explorer.model.explorer.Explorer;
import eu.kalafatic.explorer.model.explorer.ExplorerFactory;
import eu.kalafatic.explorer.model.explorer.ExplorerPackage;
import eu.kalafatic.explorer.model.explorer.Port;
import eu.kalafatic.utils.model.AModelManager;
import eu.kalafatic.utils.model.ModelUtils;

/**
 * The Class class ExplorerModelManager.
 * @author Petr Kalafatic
 * @project Gemini
 * @version 3.0.0
 */
public class ExplorerModelManager extends AModelManager {

	/** The MODE l_ name. */
	private final String MODEL_NAME = "Model.explorer";

	/** The INSTANCE. */
	private volatile static ExplorerModelManager INSTANCE;

	/**
	 * Instantiates a new explorer model manager.
	 */
	public ExplorerModelManager() {
		initModel();
	}

	/**
	 * Gets the single instance of ExplorerModelManager.
	 * @return single instance of ExplorerModelManager
	 */
	public static ExplorerModelManager getInstance() {
		if (INSTANCE == null) {
			synchronized (ExplorerModelManager.class) {
				INSTANCE = new ExplorerModelManager();
			}
		}
		return INSTANCE;
	}

	// ---------------------------------------------------------------
	// ---------------------------------------------------------------

	/**
	 * Inits the model.
	 */
	@Override
	public void initModel() {
		try {
			// String models =
			// PREFERENCES.get(ECorePreferences.MODELS_LOC.getName(),
			// (String) ECorePreferences.MODELS_LOC.getDef());

			String models = "C:\\GE\\workspace\\models";

			super.initModel(models, "Explorer", MODEL_NAME);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ---------------------------------------------------------------

	/**
	 * Creates the model.
	 */
	@Override
	public void createModel() {
		try {
			ResourceSetImpl resourceSet = new ResourceSetImpl();
			// Register the appropriate resource factory to handle all file
			// extensions.
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());

			// Register the package to ensure it is available during loading.
			resourceSet.getPackageRegistry().put(ExplorerPackage.eNS_URI, ExplorerPackage.eINSTANCE);

			resource = resourceSet.createResource(modelURI);
			model = ExplorerFactory.eINSTANCE.createExplorer();
			resource.getContents().add(getModel());
			resource.save(ModelUtils.SAVE_OPTIONS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ---------------------------------------------------------------

	/**
	 * Sets the up explorer.
	 */
	@Override
	public void setUpModel() {
		try {
			Device gateway = Utils.getGateway();

			Device localHost = ExplorerFactory.eINSTANCE.createDevice();
			localHost.setIp(InetAddress.getLocalHost().getHostAddress());
			localHost.setHost(InetAddress.getLocalHost().getCanonicalHostName());

			Port defaultPort=ExplorerFactory.eINSTANCE.createPort();
			defaultPort.setNumber(80);

			localHost.getOpenPorts().put(80, defaultPort);

			localHost.getChildren().put(gateway.getHost(), gateway);
			getModel().getChildren().put(localHost.getHost(), localHost);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ---------------------------------------------------------------

	/**
	 * Gets the explorer.
	 * @return the explorer
	 */
	@Override
	public Explorer getModel() {
		return (Explorer) model;
	}



}
