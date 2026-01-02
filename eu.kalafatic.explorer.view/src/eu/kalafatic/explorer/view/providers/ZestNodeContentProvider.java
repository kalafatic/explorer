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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.viewers.IGraphEntityContentProvider;

import eu.kalafatic.explorer.model.explorer.Device;
import eu.kalafatic.explorer.model.explorer.Node;
import eu.kalafatic.explorer.view.hack.SubtreeContributionItem;

/**
 * The Class class ZestNodeContentProvider.
 * @author Petr Kalafatic
 * @version 3.0.0
 * @project Gemini
 */
@SuppressWarnings({ "unused" })
public class ZestNodeContentProvider extends ArrayContentProvider
/* AModelContentProvider */implements IGraphEntityContentProvider {

	/**
	 * Instantiates a new zest node content provider.
	 * @param viewer the viewer
	 */
	public ZestNodeContentProvider(GraphViewer viewer) {
		super();
	}

	// ---------------------------------------------------------------
	// ---------------------------------------------------------------

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ArrayContentProvider#getElements(java.lang.Object)
	 */
	@Override
	public Object[] getElements(Object element) {
		if (element instanceof HashMap<?, ?>) {
			Map<?, ?> map = (Map<?, ?>) element;
			return getAllChildren(map.entrySet(), new ArrayList<Object>());
		} else if (element instanceof EMap<?, ?>) {
			EMap<?, ?> map = (EMap<?, ?>) element;
			return getAllChildren(map.entrySet(), new ArrayList<Object>());
		} else if (element instanceof Node) {
			Node node = (Node) element;
			if (!node.getChildren().isEmpty()) {
				return getAllChildren(node.getChildren().entrySet(), new ArrayList<Object>());
			}
		}
		return new Object[] { element };
	}

	// ---------------------------------------------------------------

	/**
	 * Gets the all children.
	 * @param collection the collection
	 * @param allChildren the all children
	 * @return the all children
	 */
	private Object[] getAllChildren(Collection<?> collection, List<Object> allChildren) {
		for (Object object : collection) {
			if (object instanceof HashMap<?, ?>) {
				HashMap<?, ?> map = (HashMap<?, ?>) object;
				allChildren.add(map);
				getAllChildren(map.values(), allChildren);

			} else if (object instanceof EcoreEMap<?, ?>) {
				EcoreEMap<?, ?> eMap = (EcoreEMap<?, ?>) object;
				EStructuralFeature eStructuralFeature = eMap.getEStructuralFeature();
				allChildren.add(eMap);
				getAllChildren(eMap.values(), allChildren);

			} else if (object instanceof Entry<?, ?>) {
				Entry<?, ?> entry = (Entry<?, ?>) object;
				allChildren.add(entry.getValue());
				if (entry.getValue() instanceof Collection) {
					getAllChildren(((Collection<?>) entry.getValue()), allChildren);
				} else if (entry.getValue() instanceof Device) {
					if (SubtreeContributionItem.filter.equals(SubtreeContributionItem.EFilter.PORTS)) {
						allChildren.addAll(((Device) entry.getValue()).getOpenPorts());
					}
					getAllChildren(((Device) entry.getValue()).getChildren(), allChildren);
				}
				// } else if (object instanceof Node) {
				// allChildren.add(object);
				// getAllChildren(((Node) object).getChildren(), allChildren);
			}
		}
		return allChildren.toArray();
	}

	// ---------------------------------------------------------------

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.zest.core.viewers.IGraphEntityContentProvider#getConnectedTo (java.lang.Object)
	 */
	@Override
	public Object[] getConnectedTo(Object element) {
		List<Object> allChildren = new ArrayList<Object>();
		if (element instanceof Device) {
			if (SubtreeContributionItem.filter.equals(SubtreeContributionItem.EFilter.PORTS)) {
				allChildren.addAll(((Device) element).getOpenPorts());
			}
			allChildren.addAll(((Device) element).getChildren().values());
		} else if (element instanceof Node) {
			allChildren.addAll(((Node) element).getChildren().values());
		} else if (element instanceof HashMap<?, ?>) {
			HashMap<?, ?> map = (HashMap<?, ?>) element;
			allChildren.addAll(map.values());
		} else if (element instanceof Entry<?, ?>) {
			Entry<?, ?> entry = (Entry<?, ?>) element;
			 allChildren.add(entry.getValue());
		} else if (element instanceof EcoreEMap<?, ?>) {
			EcoreEMap<?, ?> eMap = (EcoreEMap<?, ?>) element;
			allChildren.addAll(eMap.values());
		} else if (element instanceof List<?>) {
			List<?> list = (List<?>) element;
			allChildren.addAll(list);

		}
		return allChildren.toArray();
	}
}
