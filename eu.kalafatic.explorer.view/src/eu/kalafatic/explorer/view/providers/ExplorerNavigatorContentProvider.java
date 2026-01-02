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

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import eu.kalafatic.explorer.model.explorer.Device;
import eu.kalafatic.explorer.model.explorer.Node;

/**
 * The Class class ExplorerNavigatorContentProvider.
 * @author Petr Kalafatic
 * @version 3.0.0
 * @project Gemini
 */
public class ExplorerNavigatorContentProvider implements IStructuredContentProvider, ITreeContentProvider {

	// ---------------------------------------------------------------
	// ---------------------------------------------------------------
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
	 */
	@Override
	public Object[] getElements(Object parent) {
		return getChildren(parent);
	}

	// ---------------------------------------------------------------

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
	 */
	@Override
	public Object getParent(Object element) {
		if (element instanceof Node) {
			return ((Node) element).getParent();
		}
		return null;
	}

	// ---------------------------------------------------------------

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
	 */
	@Override
	public Object[] getChildren(Object element) {
		if (element instanceof Node) {
			return ((Node) element).getChildren().values().toArray();

		} else if (element instanceof HashMap<?, ?>) {
			HashMap<?, ?> map = (HashMap<?, ?>) element;
			return map.values().toArray();

		} else if (element instanceof EcoreEMap<?, ?>) {
			EcoreEMap<?, ?> eMap = (EcoreEMap<?, ?>) element;
			return eMap.values().toArray();

		} else if (element instanceof List<?>) {
			List<?> list = (List<?>) element;
			return list.toArray();
		}
		return new Object[0];
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
					allChildren.addAll(((Device) entry.getValue()).getOpenPorts());
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
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
	 */
	@Override
	public boolean hasChildren(Object element) {
		if (element instanceof Node) {
			return !((Node) element).getChildren().isEmpty();
		} else if (element instanceof HashMap<?, ?>) {
			Map<?, ?> map = (Map<?, ?>) element;
			return !map.isEmpty();
		} else if (element instanceof EMap<?, ?>) {
			EMap<?, ?> map = (EMap<?, ?>) element;
			return !map.isEmpty();
		}
		return false;
	}

	// ---------------------------------------------------------------

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 */
	@Override
	public void inputChanged(Viewer v, Object oldInput, Object newInput) {}

	// ---------------------------------------------------------------
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 */
	@Override
	public void dispose() {}
}
