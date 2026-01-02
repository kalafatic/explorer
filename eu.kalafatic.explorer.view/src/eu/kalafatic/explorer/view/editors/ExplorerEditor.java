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
package eu.kalafatic.explorer.view.editors;

import java.io.StringWriter;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FontDialog;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.ISaveablePart;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.SharedHeaderFormEditor;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.MultiPageEditorSite;

import eu.kalafatic.explorer.controller.model.FormEditorInput;
import eu.kalafatic.explorer.view.actions.PulldownAction;
import eu.kalafatic.explorer.view.editors.pages.GraphPage;
import eu.kalafatic.explorer.view.editors.pages.InterfacePage;
import eu.kalafatic.explorer.view.editors.pages.OverviewPage;
import eu.kalafatic.explorer.view.pages.AProjectPage;

//import eu.kalafatic.explorer.view.hack.Form;
//import eu.kalafatic.explorer.view.hack.IManagedForm;
//import eu.kalafatic.explorer.view.hack.ScrolledForm;
//import eu.kalafatic.explorer.view.hack.SharedHeaderFormEditor;
//import eu.kalafatic.explorer.view.pages.GraphPage;

/**
 * The Class class ExplorerEditor.
 * @author Petr Kalafatic
 * @version 3.0.0
 * @project Gemini
 */
public class ExplorerEditor extends SharedHeaderFormEditor implements ISaveablePart,
		ISelectionListener, IResourceChangeListener {

	/** The Constant ID. */
	public static final String ID = "eu.kalafatic.explorer.view.editors.ExplorerEditor";

	/** The editor. */
	private TextEditor editor;

	/** The font. */
	private Font font;

	/** The editor input. */
	private FormEditorInput editorInput;

	/** The text. */
	private StyledText text;
	
	/** The form. */
	private Form form;

	/** The pages. */
	public Map<Object, Object> pages = new LinkedHashMap<Object, Object>();

	/**
	 * Instantiates a new explorer editor.
	 */
	public ExplorerEditor() {
		super();
		ResourcesPlugin.getWorkspace().addResourceChangeListener(this);
	}

	// ---------------------------------------------------------------
	// ---------------------------------------------------------------

	/* (non-Javadoc)
	 * @see org.eclipse.ui.forms.editor.SharedHeaderFormEditor#createHeaderContents(org.eclipse.ui.forms.IManagedForm)
	 */
	@Override
	protected void createHeaderContents(IManagedForm headerForm) {
		FormToolkit toolkit = headerForm.getToolkit();
		ScrolledForm scrolledForm = headerForm.getForm();
		form = scrolledForm.getForm();
		toolkit.decorateFormHeading(form);

		form.setText("Explorer Editor");
		// form.setImage(FConstants.SETTINGS_IMG);

		form.getToolBarManager().add(new PulldownAction("Structure"));
		form.getToolBarManager().add(new PulldownAction("Actions"));
		form.getToolBarManager().update(true);

		// form.getMenuManager().add(new PulldownAction());

		form.addMessageHyperlinkListener(new HyperlinkAdapter());
		form.setMessage("This is an error message", IMessageProvider.ERROR);

		getSite().getPage().addSelectionListener(this);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.MultiPageEditorPart#createSite(org.eclipse.ui.IEditorPart)
	 */
	@Override
	protected IEditorSite createSite(IEditorPart page) {
		IEditorSite site = null;
		if (page == editor) {
			site = new MultiPageEditorSite(this, page) {
				@Override
				public String getId() {
					// Sets this ID so nested editor is configured for XML
					// source
					return "jj" + ".source"; //$NON-NLS-1$;
				}
			};
		} else {
			site = super.createSite(page);
		}
		return site;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.forms.editor.FormEditor#addPages()
	 */
	@Override
	protected void addPages() {
		try {
			// editorInput = (FormEditorInput) getEditorInput();
			// Map project = editorInput.getProject();

			int index = 0;
			// addPage(project, new OverviewPage(this, index++, project));

			// List<Map> children = (List<Map>)
			// project.get(EProject.CHILDREN.name());

			// for (Map input : children) {
			// addPage(input, new ProjectPage(this, index++, input));
			// }
			//
			// addPage(new GraphPage(this, index++));
			//
			// createXMLEditorPage();
			// createXSDEditorPage();

			addPage(new InterfacePage(this, index++));
			addPage(new GraphPage(this, form, index++));
			addPage(new OverviewPage(this, index++));

			createPage0();
			// createPage1();
			// addPage(new Object(), new ProjectPage(this, index++, null));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ---------------------------------------------------------------

	/**
	 * Adds the page.
	 * @param projectPage the project page
	 * @return the int
	 * @throws PartInitException the part init exception
	 */
	public int addPage(AProjectPage projectPage) throws PartInitException {
		pages.put(projectPage.getId(), projectPage);
		return super.addPage(projectPage);
	}

	// ---------------------------------------------------------------

	/**
	 * Adds the page.
	 * @param input the input
	 * @param projectPage the project page
	 * @return the int
	 * @throws PartInitException the part init exception
	 */
	public int addPage(Map input, AProjectPage projectPage) throws PartInitException {
		pages.put(input, projectPage);
		return super.addPage(projectPage);
	}

	// ---------------------------------------------------------------

	/**
	 * Creates the page0.
	 */
	void createPage0() {
		try {
			editor = new TextEditor();

			editor.addPartPropertyListener(new IPropertyChangeListener() {

				@Override
				public void propertyChange(PropertyChangeEvent event) {
					// TODO Auto-generated method stub
					System.err.println();
				}
			});

			Display.getDefault().asyncExec(new Runnable() {
				@Override
				public void run() {
					IAction action = editor.getAction("delete");

					if (action != null) {
						// action.setEnabled(false);
					}
				}
			});

			int index = addPage(editor, getEditorInput());
			setPageText(index, editor.getTitle());

		} catch (PartInitException e) {
			ErrorDialog.openError(getSite().getShell(), "Error creating nested text editor", null,
					e.getStatus());
		}
	}

	/**
	 * Creates the page1.
	 */
	void createPage1() {

		Composite composite = new Composite(getContainer(), SWT.NONE);
		GridLayout layout = new GridLayout();
		composite.setLayout(layout);
		layout.numColumns = 2;

		Button fontButton = new Button(composite, SWT.NONE);
		GridData gd = new GridData(GridData.BEGINNING);
		gd.horizontalSpan = 2;
		fontButton.setLayoutData(gd);
		fontButton.setText("Change Font...");

		fontButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				setFont();
			}
		});

		int index = addPage(composite);
		setPageText(index, "Properties");
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.forms.editor.SharedHeaderFormEditor#dispose()
	 */
	@Override
	public void dispose() {
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
		super.dispose();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.EditorPart#doSave(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void doSave(IProgressMonitor monitor) {
		getEditor(0).doSave(monitor);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.EditorPart#doSaveAs()
	 */
	@Override
	public void doSaveAs() {
		IEditorPart editor = getEditor(0);
		editor.doSaveAs();
		setPageText(0, editor.getTitle());
		setInput(editor.getEditorInput());
	}

	/*
	 * (non-Javadoc) Method declared on IEditorPart
	 */
	/**
	 * Goto marker.
	 * @param marker the marker
	 */
	public void gotoMarker(IMarker marker) {
		setActivePage(0);
		IDE.gotoMarker(getEditor(0), marker);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.forms.editor.FormEditor#init(org.eclipse.ui.IEditorSite, org.eclipse.ui.IEditorInput)
	 */
	@Override
	public void init(IEditorSite site, IEditorInput editorInput) throws PartInitException {
		// if (!(editorInput instanceof IFileEditorInput)) {
		// throw new
		// PartInitException("Invalid Input: Must be IFileEditorInput");
		// }
		super.init(site, editorInput);
	}

	/*
	 * (non-Javadoc) Method declared on IEditorPart.
	 */
	@Override
	public boolean isSaveAsAllowed() {
		return true;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.forms.editor.FormEditor#pageChange(int)
	 */
	@Override
	protected void pageChange(int newPageIndex) {
		super.pageChange(newPageIndex);
		// if (newPageIndex == 2) {
		// sortWords();
		// }

		// editor.getAction("copy").setEnabled(newPageIndex == 0);
		// editor.getAction("paste").setEnabled(newPageIndex == 0);
		// editor.getAction("delete").setEnabled(newPageIndex == 0);
		//
		// if (newPageIndex != 0) {
		// IHandlerService hs = (IHandlerService)
		// PlatformUI.getWorkbench().getService(IHandlerService.class);
		// CommandService s1 = (CommandService)
		// PlatformUI.getWorkbench().getService(ICommandService.class);
		// Command command =
		// s1.getCommand(IWorkbenchCommandConstants.EDIT_DELETE);
		// // command.g
		// CopyHandler handler = new CopyHandler();
		//
		// Object iHandlerActivation =
		// hs.activateHandler(IWorkbenchCommandConstants.EDIT_DELETE, handler);
		//
		// System.err.println();
		// }

	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.resources.IResourceChangeListener#resourceChanged(org.eclipse.core.resources.IResourceChangeEvent)
	 */
	@Override
	public void resourceChanged(final IResourceChangeEvent event) {
		if (event.getType() == IResourceChangeEvent.PRE_CLOSE) {
			Display.getDefault().asyncExec(new Runnable() {
				@Override
				public void run() {
					IWorkbenchPage[] pages = getSite().getWorkbenchWindow().getPages();
					for (int i = 0; i < pages.length; i++) {
						if (((FileEditorInput) editor.getEditorInput()).getFile().getProject()
								.equals(event.getResource())) {
							IEditorPart editorPart = pages[i].findEditor(editor.getEditorInput());
							pages[i].closeEditor(editorPart, true);
						}
					}
				}
			});
		} else {
			Display.getDefault().asyncExec(new Runnable() {
				@Override
				public void run() {
					IMarker marker;
					try {
						marker = ((FileEditorInput) editor.getEditorInput()).getFile()
								.createMarker(IMarker.PROBLEM);
						marker.setAttribute(IMarker.MESSAGE, "A sample marker message");
						marker.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_HIGH);
						marker.setAttribute(IMarker.LINE_NUMBER, 1);

						Image image = PlatformUI.getWorkbench().getSharedImages()
								.getImage(ISharedImages.IMG_DEC_FIELD_ERROR);
						// editor.updatedTitleImage(image);
						setTitleImage(image);
					} catch (CoreException e) {

						e.printStackTrace();
					}
				}
			});

		}
	}

	/**
	 * Sets the font.
	 */
	void setFont() {
		FontDialog fontDialog = new FontDialog(getSite().getShell());
		fontDialog.setFontList(text.getFont().getFontData());
		FontData fontData = fontDialog.open();
		if (fontData != null) {
			if (font != null) {
				font.dispose();
			}
			font = new Font(text.getDisplay(), fontData);
			text.setFont(font);
		}
	}

	/**
	 * Sort words.
	 */
	void sortWords() {

		String editorText = editor.getDocumentProvider().getDocument(editor.getEditorInput()).get();

		StringTokenizer tokenizer = new StringTokenizer(editorText,
				" \t\n\r\f!@#\u0024%^&*()-_=+`~[]{};:'\",.<>/?|\\");
		ArrayList editorWords = new ArrayList();
		while (tokenizer.hasMoreTokens()) {
			editorWords.add(tokenizer.nextToken());
		}

		Collections.sort(editorWords, Collator.getInstance());
		StringWriter displayText = new StringWriter();
		for (int i = 0; i < editorWords.size(); i++) {
			displayText.write(((String) editorWords.get(i)));
			displayText.write(System.getProperty("line.separator"));
		}
		text.setText(displayText.toString());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.forms.editor.SharedHeaderFormEditor#isDirty()
	 */
	@Override
	public boolean isDirty() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.EditorPart#isSaveOnCloseNeeded()
	 */
	@Override
	public boolean isSaveOnCloseNeeded() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.ISelectionListener#selectionChanged(org.eclipse.ui.IWorkbenchPart, org.eclipse.jface.viewers.ISelection)
	 */
	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		// TODO Auto-generated method stub

	}

}
