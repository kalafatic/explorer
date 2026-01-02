package eu.kalafatic.explorer.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class xx {
	private static Display display;

	static String st = "\\nxv";

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		display = new Display();

		Shell s = new Shell(display);
		s.setLayout(new GridLayout());
		s.setLayoutData(new GridData(GridData.FILL_BOTH));
		s.setSize(200, 200);
		final Text t = new Text(s, SWT.MULTI/* | SWT.WRAP */);
		t.setLayoutData(new GridData(GridData.FILL_BOTH));

		FileInputStream fis = new FileInputStream(new File("x.txt"));
		byte[] b = new byte[128];
		fis.read(b);
		String string = new String(b);
		// String.format("%s", string);
		string = string.replaceAll("\\\\n", "\r\n");
		t.setText(string);

		t.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				try {
					FileOutputStream fos = new FileOutputStream(new File("x.txt"));
					String string = t.getText().replaceAll("\r\n", "\\\\n");
					fos.write(string.getBytes());

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});

		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {

			}
		});
		s.open();

		while (!s.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
		System.err.println();
	}
}
