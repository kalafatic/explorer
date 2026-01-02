/**
 */
package eu.kalafatic.explorer.model.explorer.impl;

import eu.kalafatic.explorer.model.explorer.ExplorerPackage;
import eu.kalafatic.explorer.model.explorer.Route;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Route</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.kalafatic.explorer.model.explorer.impl.RouteImpl#getNetTarget <em>Net Target</em>}</li>
 *   <li>{@link eu.kalafatic.explorer.model.explorer.impl.RouteImpl#getGateway <em>Gateway</em>}</li>
 *   <li>{@link eu.kalafatic.explorer.model.explorer.impl.RouteImpl#getInterface <em>Interface</em>}</li>
 *   <li>{@link eu.kalafatic.explorer.model.explorer.impl.RouteImpl#getMetrics <em>Metrics</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RouteImpl extends DeviceImpl implements Route {
	/**
	 * The default value of the '{@link #getNetTarget() <em>Net Target</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNetTarget()
	 * @generated
	 * @ordered
	 */
	protected static final String NET_TARGET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNetTarget() <em>Net Target</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNetTarget()
	 * @generated
	 * @ordered
	 */
	protected String netTarget = NET_TARGET_EDEFAULT;

	/**
	 * The default value of the '{@link #getGateway() <em>Gateway</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGateway()
	 * @generated
	 * @ordered
	 */
	protected static final String GATEWAY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGateway() <em>Gateway</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGateway()
	 * @generated
	 * @ordered
	 */
	protected String gateway = GATEWAY_EDEFAULT;

	/**
	 * The default value of the '{@link #getInterface() <em>Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterface()
	 * @generated
	 * @ordered
	 */
	protected static final String INTERFACE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInterface() <em>Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterface()
	 * @generated
	 * @ordered
	 */
	protected String interface_ = INTERFACE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMetrics() <em>Metrics</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetrics()
	 * @generated
	 * @ordered
	 */
	protected static final int METRICS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMetrics() <em>Metrics</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetrics()
	 * @generated
	 * @ordered
	 */
	protected int metrics = METRICS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RouteImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExplorerPackage.Literals.ROUTE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNetTarget() {
		return netTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNetTarget(String newNetTarget) {
		String oldNetTarget = netTarget;
		netTarget = newNetTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExplorerPackage.ROUTE__NET_TARGET, oldNetTarget, netTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGateway() {
		return gateway;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGateway(String newGateway) {
		String oldGateway = gateway;
		gateway = newGateway;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExplorerPackage.ROUTE__GATEWAY, oldGateway, gateway));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInterface() {
		return interface_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterface(String newInterface) {
		String oldInterface = interface_;
		interface_ = newInterface;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExplorerPackage.ROUTE__INTERFACE, oldInterface, interface_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMetrics() {
		return metrics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetrics(int newMetrics) {
		int oldMetrics = metrics;
		metrics = newMetrics;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExplorerPackage.ROUTE__METRICS, oldMetrics, metrics));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExplorerPackage.ROUTE__NET_TARGET:
				return getNetTarget();
			case ExplorerPackage.ROUTE__GATEWAY:
				return getGateway();
			case ExplorerPackage.ROUTE__INTERFACE:
				return getInterface();
			case ExplorerPackage.ROUTE__METRICS:
				return getMetrics();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ExplorerPackage.ROUTE__NET_TARGET:
				setNetTarget((String)newValue);
				return;
			case ExplorerPackage.ROUTE__GATEWAY:
				setGateway((String)newValue);
				return;
			case ExplorerPackage.ROUTE__INTERFACE:
				setInterface((String)newValue);
				return;
			case ExplorerPackage.ROUTE__METRICS:
				setMetrics((Integer)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ExplorerPackage.ROUTE__NET_TARGET:
				setNetTarget(NET_TARGET_EDEFAULT);
				return;
			case ExplorerPackage.ROUTE__GATEWAY:
				setGateway(GATEWAY_EDEFAULT);
				return;
			case ExplorerPackage.ROUTE__INTERFACE:
				setInterface(INTERFACE_EDEFAULT);
				return;
			case ExplorerPackage.ROUTE__METRICS:
				setMetrics(METRICS_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ExplorerPackage.ROUTE__NET_TARGET:
				return NET_TARGET_EDEFAULT == null ? netTarget != null : !NET_TARGET_EDEFAULT.equals(netTarget);
			case ExplorerPackage.ROUTE__GATEWAY:
				return GATEWAY_EDEFAULT == null ? gateway != null : !GATEWAY_EDEFAULT.equals(gateway);
			case ExplorerPackage.ROUTE__INTERFACE:
				return INTERFACE_EDEFAULT == null ? interface_ != null : !INTERFACE_EDEFAULT.equals(interface_);
			case ExplorerPackage.ROUTE__METRICS:
				return metrics != METRICS_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (netTarget: ");
		result.append(netTarget);
		result.append(", gateway: ");
		result.append(gateway);
		result.append(", interface: ");
		result.append(interface_);
		result.append(", metrics: ");
		result.append(metrics);
		result.append(')');
		return result.toString();
	}

} //RouteImpl
