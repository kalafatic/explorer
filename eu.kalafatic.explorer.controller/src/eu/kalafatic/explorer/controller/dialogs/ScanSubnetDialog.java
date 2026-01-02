package eu.kalafatic.explorer.controller.dialogs;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import eu.kalafatic.utils.factories.GUIFactory;
import eu.kalafatic.utils.net.NetUtils;
import eu.kalafatic.utils.parsers.StringUtils;

public class ScanSubnetDialog extends TitleAreaDialog {

	static int TITLE_LABEL_WIDTH = 150;

	static String host = "localhost";

	static String ranges = "";

	static Set<Integer> portsToScan = new HashSet<Integer>();

	private Text consoleText;

	private Text hostText;

	private Object element;

	public ScanSubnetDialog(Object element) {
		this(new Shell(Display.getDefault()), element);
	}

	public ScanSubnetDialog(Composite parent, Object element) {
		this(parent.getShell(), element);
	}

	public ScanSubnetDialog(Shell shell, Object element) {
		super(shell);
		this.element = element;
		setShellStyle(getShellStyle() | SWT.RESIZE);
	}


	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText("Set scan settings");
	}

	@Override
	protected Point getInitialSize() {
		return new Point(400, 380);
	}

	@Override
	public void create() {
		super.create();
		setTitle(StringUtils.split(getClass().getSimpleName()));
		setMessage(StringUtils.split(getClass().getSimpleName()));
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		final Composite area = GUIFactory.INSTANCE.createComposite(parent);
		Composite group = GUIFactory.INSTANCE.createGroup(area, "Set target device to scan", 1, 1);

		Composite container = GUIFactory.INSTANCE.createContainer(group, 2);
		GUIFactory.INSTANCE.createLabel(container, "Address", "", TITLE_LABEL_WIDTH);
		hostText = GUIFactory.INSTANCE.createText(container, SWT.BORDER, host, "", 0, true, true);
		hostText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				if (NetUtils.validateHostOrAddress(hostText.getText())) {
					GUIFactory.INSTANCE.decorate(hostText, false);
					host = NetUtils.getHost(hostText.getText());
				} else {
					GUIFactory.INSTANCE.decorate(hostText, true);
				}
			}
		});
		container = GUIFactory.INSTANCE.createContainer(group, 2);
		GUIFactory.INSTANCE.createLabel(container, "Ports", "", TITLE_LABEL_WIDTH);
		final Combo combo = GUIFactory.INSTANCE.createCombo(container, SWT.READ_ONLY, "Ports", 0, "Well known", "Values");
		combo.select(0);

		container = GUIFactory.INSTANCE.createContainer(area, 1);
		group = GUIFactory.INSTANCE.createGroup(container, "Ports to scan", 1, 1);

		consoleText = GUIFactory.INSTANCE.createText(group, /* SWT.BORDER | */SWT.MULTI, "", "", 0, 100, true, true);

		combo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				consoleText.setEditable(!"Well known".equals(combo.getText()));
				System.out.println(!"Well known".equals(combo.getText()));
			}
		});

		area.layout(true, true);
		return area;
	}

	@Override
	protected void okPressed() {
		ranges = consoleText.getText();
		super.okPressed();
	}

	public static String getHost() {
		return host;
	}

	public static Set<Integer> getPortsToScan() {
		return new HashSet<Integer>(StringUtils.parseIntegers(ranges));
	}

}