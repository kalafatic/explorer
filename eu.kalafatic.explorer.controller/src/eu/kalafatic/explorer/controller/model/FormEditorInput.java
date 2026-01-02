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

import java.io.File;
import java.util.Map;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

/**
 * The Class class FormEditorInput.
 * @author Petr Kalafatic
 * @project Gemini
 * @version 3.0.0
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class FormEditorInput implements IEditorInput {

	/** The file. */
	private File file;

	/** The project. */
	private Map project;

	/**
	 * Instantiates a new form editor input.
	 * @param file the file
	 * @param project the project
	 */
	public FormEditorInput(File file, Map project) {
		this.file = file;
		this.project = project;
	}

	// ---------------------------------------------------------------
	// ---------------------------------------------------------------

	/**
	 * Gets the sub project.
	 * @param key the key
	 * @return the sub project
	 */
	public Map getSubProject(String key) {
		// List<Map> children = (List<Map>) project.get(EProject.CHILDREN.name());
		// for (Map map : children) {
		// if (((String) project.get(EProject.CHILDREN.name())).equalsIgnoreCase(key)) {
		// return map;
		// }
		// }
		return null;
	}

	// ---------------------------------------------------------------

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.IEditorInput#exists()
	 */
	@Override
	public boolean exists() {
		return file.exists();
	}

	// ---------------------------------------------------------------

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.IEditorInput#getImageDescriptor()
	 */
	@Override
	public ImageDescriptor getImageDescriptor() {
		return PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_OBJ_ELEMENT);
	}

	// ---------------------------------------------------------------

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.IEditorInput#getName()
	 */
	@Override
	public String getName() {
		return "vgn"/* (String) project.get(EProject.KEY.name()) */;
	}

	// ---------------------------------------------------------------

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.IEditorInput#getPersistable()
	 */
	@Override
	public IPersistableElement getPersistable() {
		return null;
	}

	// ---------------------------------------------------------------

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.IEditorInput#getToolTipText()
	 */
	@Override
	public String getToolTipText() {
		return "XML based project maintain";
	}

	// ---------------------------------------------------------------

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
	 */
	@Override
	public Object getAdapter(Class adapter) {
		return null;
	}

	// ---------------------------------------------------------------

	/**
	 * Gets the file.
	 * @return the file
	 */
	public File getFile() {
		return file;
	}

	// ---------------------------------------------------------------

	/**
	 * Gets the project.
	 * @return the project
	 */
	public Map getProject() {
		return project;
	}
}