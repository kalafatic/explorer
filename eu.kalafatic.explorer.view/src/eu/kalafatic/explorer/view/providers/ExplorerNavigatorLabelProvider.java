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
package eu.kalafatic.explorer.view.providers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.UIJob;

import eu.kalafatic.explorer.model.explorer.Device;
import eu.kalafatic.explorer.model.explorer.Node;
import eu.kalafatic.explorer.view.Activator;

/**
 * The Class class ExplorerNavigatorLabelProvider.
 * @author Petr Kalafatic
 * @version 3.0.0
 * @project Gemini
 */
public class ExplorerNavigatorLabelProvider extends LabelProvider {

	private static UIJob fNotifierJob;

	private static Set<Object> fChangedResources = new HashSet<Object>();

	ImageDescriptor imageDescriptor = Activator.getImageDescriptor("icons/ovr16/error_co.gif");
	static ExplorerNavigatorLabelProvider x;

	public ExplorerNavigatorLabelProvider() {
		x = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
	 */
	@Override
	public String getText(Object element) {
		if (element instanceof Device) {
			return ((Device) element).getHost();
		} else if (element instanceof Map<?, ?>) {
			Map<?, ?> map = (Map<?, ?>) element;
			return "Swarms".concat(" (" + map.size() + ")");
		} else if (element instanceof EMap<?, ?>) {
			EMap<?, ?> map = (EMap<?, ?>) element;
			return "Node".concat(" (" + map.size() + ")");
		}
		return element.toString();
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.viewers.LabelProvider#getImage(java.lang.Object)
	 */
	@Override
	public Image getImage(Object element) {
		String imageKey = ISharedImages.IMG_OBJ_ELEMENT;
		if (element instanceof Node) {
			imageKey = ISharedImages.IMG_OBJ_FOLDER;
		}
		return PlatformUI.getWorkbench().getSharedImages().getImage(imageKey);
	}

	public static void update(Object... collection) {
		boolean hasChanges = false;
		synchronized (fChangedResources) {
			hasChanges = fChangedResources.addAll(Arrays.asList(collection));
		}
		if (hasChanges) {
			if (fNotifierJob == null) {
				fNotifierJob = new UIJob(Display.getDefault(), "Update Java test decorations") {
					@Override
					public IStatus runInUIThread(IProgressMonitor monitor) {
						runPendingUpdates();
						return Status.OK_STATUS;
					}
				};
				fNotifierJob.setSystem(true);
			}
			fNotifierJob.schedule();
		}
	}

	private static void runPendingUpdates() {
		Object[] resourceToUpdate = null;
		synchronized (fChangedResources) {
			resourceToUpdate = fChangedResources.toArray();
			fChangedResources.clear();
		}
		if (resourceToUpdate.length > 0) {
			LabelProviderChangedEvent event = new LabelProviderChangedEvent(x, resourceToUpdate);

			x.fireLabelProviderChanged(event);
		}
	}
}
