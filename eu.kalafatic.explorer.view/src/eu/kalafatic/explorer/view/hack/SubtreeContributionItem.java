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
package eu.kalafatic.explorer.view.hack;

import java.util.List;
import java.util.Map;

import org.eclipse.jface.action.ContributionItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MenuAdapter;
import org.eclipse.swt.events.MenuEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.zest.core.viewers.GraphViewer;

import eu.kalafatic.utils.java.EnumUtils;
import eu.kalafatic.utils.parsers.StringUtils;

/**
 * The Class class SubtreeContributionItem.
 * @author Petr Kalafatic
 * @version 3.0.0
 * @project Gemini
 */
public class SubtreeContributionItem extends ContributionItem {

	public enum EFilter {
		PORTS, NO_PORTS;

		@Override
		public String toString() {
			return StringUtils.capitalizeFirstCharacters(true, StringUtils.splitJavaNames(name()));
		}
	}

	public static EFilter filter = EFilter.NO_PORTS;

	/** The viewer. */
	private GraphViewer viewer;

	/** The input map. */
	private Map<String, Object> inputMap;

	/** The combo. */
	private Combo combo;

	/** The menu. */
	private Menu fMenu;

	/**
	 * Instantiates a new subtree contribution item.
	 * @param viewer the viewer
	 * @param inputMap the input map
	 */
	public SubtreeContributionItem(GraphViewer viewer, Map<String, Object> inputMap) {
		this.viewer = viewer;
		this.inputMap = inputMap;
	}

	// ---------------------------------------------------------------
	// ---------------------------------------------------------------

	/** The menu adapter. */
	private final MenuAdapter menuAdapter = new MenuAdapter() {
		@Override
		public void menuShown(MenuEvent e) {
			refresh(true);
		}
	};

	// ---------------------------------------------------------------

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.action.ContributionItem#fill(org.eclipse.swt.widgets .Menu, int)
	 */
	@Override
	public void fill(Menu menu, int index) {
		if (this.fMenu == null || this.fMenu != menu) {
			if (this.fMenu != null) {
				this.fMenu.removeMenuListener(menuAdapter);
				this.fMenu = null;
			}
			this.fMenu = menu;
			menu.addMenuListener(menuAdapter);
		}
	}

	// ---------------------------------------------------------------

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.action.ContributionItem#fill(org.eclipse.swt.widgets .CoolBar, int)
	 */
	@Override
	public void fill(CoolBar parent, int index) {
		CoolItem item = new CoolItem(parent, SWT.DROP_DOWN);
		item.setMinimumSize(100, 50);
		Combo combo = createCombo(parent);
		item.setControl(combo);
	}

	// ---------------------------------------------------------------

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.action.ContributionItem#fill(org.eclipse.swt.widgets .ToolBar, int)
	 */
	@Override
	public void fill(ToolBar parent, int index) {
		ToolItem item = new ToolItem(parent, SWT.SEPARATOR, index);
		Combo combo = createCombo(parent);
		item.setControl(combo);
		item.setWidth(combo.computeSize(SWT.DEFAULT, SWT.DEFAULT, true).x);
	}

	// ---------------------------------------------------------------

	/**
	 * Creates the combo.
	 * @param parent the parent
	 * @return the combo
	 */
	private Combo createCombo(Composite parent) {
//		Composite c =new Composite(parent, SWT.BORDER);
//
//		GridLayout gd=new GridLayout();
////		gd.verticalSpacing=20;
////		gd.marginTop=10;
//		c.setLayout(gd);
//		c.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		this.combo = new Combo(parent, SWT.DROP_DOWN | SWT.READ_ONLY);
		GridData gridData = new GridData(GridData.FILL_BOTH);
//		gridData.widthHint = 50;
//		gridData.heightHint = 10;
		this.combo.setLayoutData(gridData);
//		combo.setLayout(gd);

		List<String> enumItems = EnumUtils.getEnumItems(EFilter.values());
		this.combo.setItems(enumItems.toArray(new String[enumItems.size()]));
		combo.select(0);

		this.combo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int selection = combo.getSelectionIndex();
				if (selection > 0) {
					doLayout(combo.getItem(selection));
				} else {
					doLayout(combo.getItem(0));
				}
			}
		});
		this.combo.pack();
		return this.combo;
	}

	// ---------------------------------------------------------------

	/**
	 * Do layout.
	 * @param name the name
	 */

	private void doLayout(final String layoutName) {
		Display.getDefault().asyncExec(new Runnable() {
			@SuppressWarnings({ "unused" })
			@Override
			public void run() {
				if (!viewer.getGraphControl().isVisible()) {
					return;
				}
				filter = (EFilter) EnumUtils.getByName(EFilter.values(), layoutName);
				viewer.getGraphControl().layout(true, true);
				viewer.refresh(true);
			}
		});
	}

	// ---------------------------------------------------------------

	/**
	 * Refresh.
	 * @param rebuild the rebuild
	 */
	public void refresh(boolean rebuild) {
		if (combo != null && !combo.isDisposed()) {
			refreshCombo(rebuild);
		} else if (fMenu != null && !fMenu.isDisposed()) {
			refreshMenu(rebuild);
		}
	}

	// ---------------------------------------------------------------

	/**
	 * Refresh menu.
	 * @param rebuild the rebuild
	 */
	private void refreshMenu(boolean rebuild) {
		fMenu.setEnabled(false);

		if (rebuild) {

			MenuItem[] oldItems = fMenu.getItems();
			for (int i = 0; i < oldItems.length; i++) {
				if (oldItems[i].getData() == this) {
					oldItems[i].dispose();
				}
			}
			for (EFilter enumItem : EFilter.values()) {
				MenuItem item = new MenuItem(fMenu, SWT.RADIO);
				item.setText(enumItem.toString());
				item.setData(this);
				item.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						MenuItem source = (MenuItem) e.getSource();
						doLayout(source.getText());
					}
				});
			}
		}

		MenuItem[] items = fMenu.getItems();
		for (int i = 0; i < items.length; i++) {
			MenuItem item = items[i];
			if (item.getData() == this) {
				item.setSelection(false);

				if (filter.toString().equalsIgnoreCase(item.getText())) {
					item.setSelection(true);
				}
			}
		}
		fMenu.setEnabled(true);
	}

	// ---------------------------------------------------------------

	/**
	 * Refresh combo.
	 * @param rebuild the rebuild
	 */
	private void refreshCombo(final boolean rebuild) {
		// lock.lock();
		// try {
		// Display.getDefault().asyncExec(new Runnable() {
		// @Override
		// ÙÕù ¡c×
		// });
		// }
	}
}