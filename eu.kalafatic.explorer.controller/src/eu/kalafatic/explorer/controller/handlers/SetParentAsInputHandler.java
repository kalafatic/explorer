package eu.kalafatic.explorer.controller.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.zest.core.viewers.GraphViewer;

import eu.kalafatic.explorer.controller.model.ExplorerModelManager;
import eu.kalafatic.explorer.model.explorer.Explorer;
import eu.kalafatic.explorer.model.explorer.Node;
import eu.kalafatic.utils.interfaces.IViewer;

public class SetParentAsInputHandler extends AbstractHandler {

	// ---------------------------------------------------------------
	// ---------------------------------------------------------------

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands .ExecutionEvent)
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchPart activePart = HandlerUtil.getActivePart(event);

		if (activePart instanceof ViewPart) {
			ViewPart viewPart = (ViewPart) activePart;

			if (((IViewer) viewPart).getViewer() instanceof GraphViewer) {
				GraphViewer viewer = (GraphViewer) ((IViewer) viewPart).getViewer();

				ISelection selection = viewer.getSelection();
				Object selected = ((IStructuredSelection) selection).getFirstElement();

				if (selected instanceof Node) {
					Node node = (Node) selected;
					if (node.getParent() == null) {
						Explorer explorer = ExplorerModelManager.getInstance().getModel();
						viewer.setInput(explorer.getChildren());
					} else {
						viewer.setInput(node.getParent());
					}
				} else if (selected instanceof EMap<?, ?>) {
					EMap<?, ?> map = (EMap<?, ?>) selected;
					viewer.setInput(map);
				}
				viewer.refresh();
			}
		}
		return null;
	}
}
