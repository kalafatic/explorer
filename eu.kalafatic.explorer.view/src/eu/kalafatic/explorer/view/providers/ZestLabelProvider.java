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

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.UpdateListener;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.jface.viewers.IFontProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;
import org.eclipse.zest.core.viewers.EntityConnectionData;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.viewers.IEntityConnectionStyleProvider;
import org.eclipse.zest.core.viewers.ISelfStyleProvider;
import org.eclipse.zest.core.widgets.Graph;
import org.eclipse.zest.core.widgets.GraphConnection;
import org.eclipse.zest.core.widgets.GraphNode;
import org.eclipse.zest.core.widgets.ZestStyles;
import org.eclipse.zest.layouts.LayoutEntity;

import eu.kalafatic.explorer.model.explorer.Device;
import eu.kalafatic.explorer.model.explorer.Node;
import eu.kalafatic.explorer.model.explorer.Port;
import eu.kalafatic.explorer.model.explorer.Route;
import eu.kalafatic.utils.constants.FUIConstants;

/**
 * The Class class ZestLabelProvider.
 * @author Petr Kalafatic
 * @version 3.0.0
 * @project Gemini
 */
@SuppressWarnings("rawtypes")
public class ZestLabelProvider extends LabelProvider implements /*
																 * IImageFactory, IColorFactory , IFontFactory,
																 */IFontProvider, ISelfStyleProvider, IEntityConnectionStyleProvider {

	/** The viewer. */
	@SuppressWarnings("unused")
	private final GraphViewer viewer;

	/** The graph. */
	private final Graph graph;

	/**
	 * Instantiates a new zest label provider.
	 * @param viewer the viewer
	 */
	public ZestLabelProvider(GraphViewer viewer) {
		this.viewer = viewer;

		graph = viewer.getGraphControl();

		// graph.getViewport().getUpdateManager().addUpdateListener(new UpdateListener() {
		//
		// @Override
		// public void notifyPainting(Rectangle location, Map dirtyRegions) {
		// System.err.println("notifyPainting");
		//
		// if (dirtyRegions.values().contains(location)) {
		// return;
		// }
		//
		// Collection values = dirtyRegions.values();
		//
		// for (Object object : values) {
		//
		// final Rectangle dirty = (org.eclipse.draw2d.geometry.Rectangle) object;
		//
		// IFigure figureAt = graph.getFigureAt(dirty.x, dirty.y);
		//
		// // if (figureAt instanceof GraphLabel) {
		// // final GraphLabel label = (GraphLabel) figureAt;
		// //
		// // label.setText("sgfd");
		// //
		// // GC gc = new GC(graph);
		// // gc.setBackground(SAND_COLOR);
		// // gc.setForeground(FUIConstants.CYAN);
		// // gc.drawRectangle(location.x, location.y, location.width, 10);
		// //
		// // gc.setBackground(FUIConstants.BLUE);
		// // gc.fillGradientRectangle(dirty.x, dirty.y - 50, 50, 10, true);
		// //
		// // gc.dispose();
		// // System.err.println();
		// // }
		// }
		// }
		//
		// @Override
		// public void notifyValidating() {}
		// });
	}

	// ---------------------------------------------------------------
	// ---------------------------------------------------------------

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
	 */
	@Override
	public String getText(Object element) {
		if (element instanceof Map<?, ?>) {
			Map<?, ?> map = (Map<?, ?>) element;
			return "Swarms".concat(" (" + map.size() + ")");
		} else if (element instanceof EMap<?, ?>) {
			EMap<?, ?> map = (EMap<?, ?>) element;
			return "Node".concat(" (" + map.size() + ")");
		} else if (element instanceof EntityConnectionData) {
			EntityConnectionData entityConnectionData = (EntityConnectionData) element;
			if (entityConnectionData.dest instanceof Device) {
				Device node = (Device) entityConnectionData.dest;
				return "Machine ".concat(node.getIp());
			}
			return entityConnectionData.dest.toString();
		} else if (element instanceof Entry) {
			Entry entry = (Entry) element;
			return getText(entry.getValue());
//			return "Machine ".concat((String) entry.getKey());
		} else if (element instanceof Port) {
			Port port = (Port) element;
			return "Port ".concat(String.valueOf(port.getNumber()));
		} else if (element instanceof Route) {
			Route node = (Route) element;
			return "Route ".concat(node.getGateway());
		} else if (element instanceof Device) {
			Device node = (Device) element;
			return "Node ".concat(node.getHost());
		} else if (element instanceof Integer) {
			return "Port ".concat(element.toString());
		}
		return (element == null) ? "null" : element.toString();
		// return null;
	}

	// ---------------------------------------------------------------

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.viewers.LabelProvider#getImage(java.lang.Object)
	 */
	@Override
	public Image getImage(Object element) {
		if (element instanceof EntityConnectionData) {
			// EntityConnectionData entityConnectionData =
			// (EntityConnectionData) element;
			// return FUIConstants.FILE_IMG;
			return null;
		}
		if (element instanceof HashMap<?, ?>) {
			return FUIConstants.FOLDER_IMG;

		} else if (element instanceof EcoreEMap<?, ?>) {
			return FUIConstants.DRIVE_IMG_2;
		} else if (element instanceof Node) {
			return FUIConstants.SETTINGS_IMG;
		} else if (element instanceof Integer) {
			return null;
		}
		return FUIConstants.FOLDER_IMG;
	}

	// ---------------------------------------------------------------

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.zest.core.viewers.ISelfStyleProvider#selfStyleConnection( java.lang.Object, org.eclipse.zest.core.widgets.GraphConnection)
	 */
	@Override
	public void selfStyleConnection(Object element, final GraphConnection connection) {

		if (element instanceof EntityConnectionData) {
			EntityConnectionData entityConnectionData = (EntityConnectionData) element;
			if (entityConnectionData.dest instanceof Route) {
				connection.setLineColor(FUIConstants.ORANGE_COLOR);
				connection.setLineWidth(1);
			} else if (entityConnectionData.dest instanceof Node) {
				connection.setLineColor(FUIConstants.ORANGE_COLOR);
				connection.setLineWidth(2);
			} else if (entityConnectionData.dest instanceof Integer) {
				connection.setLineColor(FUIConstants.SAND_COLOR);
				connection.setLineWidth(1);
			}
		}
	}

	// ---------------------------------------------------------------

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.zest.core.viewers.ISelfStyleProvider#selfStyleNode(java.lang .Object, org.eclipse.zest.core.widgets.GraphNode)
	 */
	@Override
	public void selfStyleNode(final Object element, final GraphNode graphNode) {
		final LayoutEntity layoutEntity = graphNode.getLayoutEntity();

		Point size = new Point(30, 16);

		int style = ZestStyles.NODES_NO_LAYOUT_RESIZE | ZestStyles.NODES_NO_LAYOUT_ANIMATION | ZestStyles.NODES_CACHE_LABEL | ZestStyles.NODES_NO_ANIMATION;
		graphNode.setBackgroundColor(FUIConstants.SAND_COLOR);
		graphNode.setNodeStyle(style);

		if (element instanceof HashMap<?, ?>) {
			size = new Point(60, 30);
			graphNode.setBackgroundColor(FUIConstants.SAND_COLOR);
			graphNode.setNodeStyle(style);

		} else if (element instanceof Map<?, ?>) {
			size = new Point(25, 25);
			graphNode.setBackgroundColor(FUIConstants.ORANGE_COLOR);
			graphNode.setNodeStyle(style);

		} else if (element instanceof Route) {
			size = new Point(120, 20);
			graphNode.setBackgroundColor(FUIConstants.SAND_COLOR);
			graphNode.setNodeStyle(style | ZestStyles.NODES_HIDE_TEXT | ZestStyles.NODES_FISHEYE);

		} else if (element instanceof Node) {
			size = new Point(100, 20);
			graphNode.setBackgroundColor(FUIConstants.ORANGE_COLOR);
			graphNode.setNodeStyle(style | ZestStyles.NODES_HIDE_TEXT | ZestStyles.NODES_FISHEYE);

			// } else if (element instanceof TrackerSession) {
			// size = new Point(60, 20);
			// graphNode.setBackgroundColor(SAND_COLOR);
			//
			// graphNode.setNodeStyle(style | ZestStyles.NODES_HIDE_TEXT
			// | ZestStyles.NODES_FISHEYE);
			//
			// } else if (element instanceof DwnldSession) {
			// graphNode.setBackgroundColor(GRASS_COLOR);
			// graphNode.setNodeStyle(style | ZestStyles.NODES_HIDE_TEXT
			// | ZestStyles.NODES_FISHEYE);
			//
			// } else if (element instanceof UpldSession) {
			// graphNode.setBackgroundColor(GRADIENT);
			// graphNode.setNodeStyle(style | ZestStyles.NODES_HIDE_TEXT
			// | ZestStyles.NODES_FISHEYE);

		} else {
			size = new Point(25, 10);
			graphNode.setBackgroundColor(FUIConstants.ORANGE_COLOR);
			graphNode.setNodeStyle(style | ZestStyles.NODES_HIDE_TEXT | ZestStyles.NODES_FISHEYE);
		}

		layoutEntity.setSizeInLayout(size.x, size.y);

		final Point size1 = size;

		IFigure figure = graphNode.getNodeFigure().getParent();

		figure.getUpdateManager().addUpdateListener(new UpdateListener() {
			@Override
			public void notifyValidating() {
				try {
					if (size1 == null) {
						layoutEntity.setSizeInLayout(15, 15);
					} else {
						layoutEntity.setSizeInLayout(size1.x, size1.y);
						// layoutEntity.setSizeInLayout(150, 20);
					}
					StringBuilder text = new StringBuilder("..");
					if (element instanceof Route) {
						Route route = (Route) element;
						text.append(route.getHost());
						text.append(route.getMask());
						text.append(route.getGateway());
						text.append(route.getMetrics());
					}

					IFigure tooltip = graphNode.getTooltip();
					if ((graphNode != null) && (!graphNode.isDisposed()) && (tooltip == null)) {
						Image image = Display.getDefault().getSystemImage(SWT.ICON_INFORMATION);
						tooltip = new Label(text.toString(), image);
						graphNode.setTooltip(tooltip);
					}
					if (tooltip != null) {
						tooltip.setVisible(true);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			@Override
			public void notifyPainting(Rectangle location, Map dirtyRegions) {}
		});
	}

	// ---------------------------------------------------------------

	/**
	 * Paint bitfield.
	 * @param graphNode the graph node
	 * @param session the session
	 */
	// private void paintBitfield(GraphNode graphNode, ClientSession session) {
	// if (session.getBitfield() == null) {
	// return;
	// }
	// if (session.eContainer().eContainer() instanceof SwarmSession) {
	// SwarmSession swarmSession = (SwarmSession) session.eContainer()
	// .eContainer();
	// ExtTorrent extTorrent = (ExtTorrent) swarmSession.getTorrent();
	//
	// float contaiment = BTUtils.INSTANCE
	// .getContaiment(session.getBitfield(),
	// extTorrent.getModelBitfield().length);
	//
	// org.eclipse.draw2d.geometry.Point location = graphNode
	// .getLocation();
	// GC gc = new GC(graph);
	// gc.setForeground(WHITE);
	// gc.setBackground(DARK_GREEN);
	//
	// // org.eclipse.draw2d.geometry.Rectangle rect = new
	// // Rectangle(location.x, location.y + 20, 100, 10);
	// gc.drawRectangle(location.x, location.y - 20, 100, 10);
	//
	// gc.fillGradientRectangle(location.x, location.y - 20,
	// (int) contaiment, 10, true);
	//
	// gc.setForeground(BLACK);
	// gc.setFont(INDEXES_FONT);
	// gc.drawString("sss", location.x, location.y - 20);
	// gc.dispose();
	// }
	//
	// }

	// ---------------------------------------------------------------

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.zest.core.viewers.IEntityConnectionStyleProvider# getConnectionStyle(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int getConnectionStyle(Object src, Object dest) {
		// if (src instanceof EcoreEMap) {
		// SwarmSession session = (SwarmSession) dest;
		// EList<String> activeSwarms = NetworkModelManager.getInstance()
		// .getClientNetwork().getActiveSwarms();
		// if (activeSwarms.contains(session.getAnnounce())) {
		// return ZestStyles.CONNECTIONS_DASH;
		// } else {
		// return ZestStyles.CONNECTIONS_SOLID;
		// }
		// }
		// if (dest instanceof TrackerSession) {
		// if (src instanceof SwarmSession) {
		// SwarmSession session = (SwarmSession) src;
		// if (session.isObtainingClients()) {
		// return ZestStyles.CONNECTIONS_DASH;
		// } else {
		// return ZestStyles.CONNECTIONS_SOLID;
		// }
		// }
		// } else if (dest instanceof DwnldSession) {
		// DwnldSession session = (DwnldSession) dest;
		// switch (session.getState()) {
		// case READY_TO_DOWNLOAD:
		// return ZestStyles.CONNECTIONS_DASH;
		// default:
		// return ZestStyles.CONNECTIONS_SOLID;
		// }
		// } else if (dest instanceof UpldSession) {
		// UpldSession session = (UpldSession) dest;
		// switch (session.getState()) {
		// case READY_TO_UPLOAD:
		return ZestStyles.CONNECTIONS_DASH | ZestStyles.CONNECTIONS_DIRECTED;
		// default:
		// return ZestStyles.CONNECTIONS_SOLID;
		// }
		// } else if (dest instanceof String) {
		// return ZestStyles.CONNECTIONS_DOT;
		// }
		// return 0;
	}

	// ---------------------------------------------------------------

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.zest.core.viewers.IEntityConnectionStyleProvider#getColor (java.lang.Object, java.lang.Object)
	 */
	@Override
	public Color getColor(Object src, Object dest) {
		return FUIConstants.SAND_COLOR;
	}

	// ---------------------------------------------------------------

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.zest.core.viewers.IEntityConnectionStyleProvider# getHighlightColor(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Color getHighlightColor(Object src, Object dest) {
		return FUIConstants.SAND_COLOR;
	}

	// ---------------------------------------------------------------

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.zest.core.viewers.IEntityConnectionStyleProvider#getLineWidth (java.lang.Object, java.lang.Object)
	 */
	@Override
	public int getLineWidth(Object src, Object dest) {
		return 1;
	}

	// ---------------------------------------------------------------

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.zest.core.viewers.IEntityConnectionStyleProvider#getTooltip (java.lang.Object)
	 */
	@Override
	public IFigure getTooltip(Object entity) {
		return null;
	}

	// ---------------------------------------------------------------

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IFontProvider#getFont(java.lang.Object)
	 */
	@Override
	public Font getFont(Object element) {
		return FUIConstants.ARIAL_8_FONT;
	}
}
