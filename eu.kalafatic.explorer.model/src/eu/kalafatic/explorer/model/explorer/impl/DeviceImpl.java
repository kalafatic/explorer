/**
 */
package eu.kalafatic.explorer.model.explorer.impl;

import eu.kalafatic.explorer.model.explorer.Device;
import eu.kalafatic.explorer.model.explorer.EDeviceType;
import eu.kalafatic.explorer.model.explorer.ExplorerPackage;
import eu.kalafatic.explorer.model.explorer.IntegerToPortMapEntry;
import eu.kalafatic.explorer.model.explorer.Port;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Device</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.kalafatic.explorer.model.explorer.impl.DeviceImpl#getIp <em>Ip</em>}</li>
 *   <li>{@link eu.kalafatic.explorer.model.explorer.impl.DeviceImpl#getHost <em>Host</em>}</li>
 *   <li>{@link eu.kalafatic.explorer.model.explorer.impl.DeviceImpl#getMask <em>Mask</em>}</li>
 *   <li>{@link eu.kalafatic.explorer.model.explorer.impl.DeviceImpl#getInterfaces <em>Interfaces</em>}</li>
 *   <li>{@link eu.kalafatic.explorer.model.explorer.impl.DeviceImpl#getType <em>Type</em>}</li>
 *   <li>{@link eu.kalafatic.explorer.model.explorer.impl.DeviceImpl#getPort <em>Port</em>}</li>
 *   <li>{@link eu.kalafatic.explorer.model.explorer.impl.DeviceImpl#getOpenPorts <em>Open Ports</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DeviceImpl extends NodeImpl implements Device {
	/**
	 * The default value of the '{@link #getIp() <em>Ip</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIp()
	 * @generated
	 * @ordered
	 */
	protected static final String IP_EDEFAULT = "0.0.0.0";

	/**
	 * The cached value of the '{@link #getIp() <em>Ip</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIp()
	 * @generated
	 * @ordered
	 */
	protected String ip = IP_EDEFAULT;

	/**
	 * The default value of the '{@link #getHost() <em>Host</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHost()
	 * @generated
	 * @ordered
	 */
	protected static final String HOST_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getHost() <em>Host</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHost()
	 * @generated
	 * @ordered
	 */
	protected String host = HOST_EDEFAULT;

	/**
	 * The default value of the '{@link #getMask() <em>Mask</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMask()
	 * @generated
	 * @ordered
	 */
	protected static final String MASK_EDEFAULT = "24";

	/**
	 * The cached value of the '{@link #getMask() <em>Mask</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMask()
	 * @generated
	 * @ordered
	 */
	protected String mask = MASK_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInterfaces() <em>Interfaces</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterfaces()
	 * @generated
	 * @ordered
	 */
	protected EList<Object> interfaces;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final EDeviceType TYPE_EDEFAULT = EDeviceType.COMPUTER;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected EDeviceType type = TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPort() <em>Port</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPort()
	 * @generated
	 * @ordered
	 */
	protected Port port;

	/**
	 * The cached value of the '{@link #getOpenPorts() <em>Open Ports</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOpenPorts()
	 * @generated
	 * @ordered
	 */
	protected EMap<Integer, Port> openPorts;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeviceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExplorerPackage.Literals.DEVICE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIp(String newIp) {
		String oldIp = ip;
		ip = newIp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExplorerPackage.DEVICE__IP, oldIp, ip));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHost() {
		return host;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHost(String newHost) {
		String oldHost = host;
		host = newHost;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExplorerPackage.DEVICE__HOST, oldHost, host));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMask() {
		return mask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMask(String newMask) {
		String oldMask = mask;
		mask = newMask;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExplorerPackage.DEVICE__MASK, oldMask, mask));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Object> getInterfaces() {
		if (interfaces == null) {
			interfaces = new EDataTypeUniqueEList<Object>(Object.class, this, ExplorerPackage.DEVICE__INTERFACES);
		}
		return interfaces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDeviceType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(EDeviceType newType) {
		EDeviceType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExplorerPackage.DEVICE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Port getPort() {
		return port;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPort(Port newPort, NotificationChain msgs) {
		Port oldPort = port;
		port = newPort;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExplorerPackage.DEVICE__PORT, oldPort, newPort);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPort(Port newPort) {
		if (newPort != port) {
			NotificationChain msgs = null;
			if (port != null)
				msgs = ((InternalEObject)port).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExplorerPackage.DEVICE__PORT, null, msgs);
			if (newPort != null)
				msgs = ((InternalEObject)newPort).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExplorerPackage.DEVICE__PORT, null, msgs);
			msgs = basicSetPort(newPort, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExplorerPackage.DEVICE__PORT, newPort, newPort));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<Integer, Port> getOpenPorts() {
		if (openPorts == null) {
			openPorts = new EcoreEMap<Integer,Port>(ExplorerPackage.Literals.INTEGER_TO_PORT_MAP_ENTRY, IntegerToPortMapEntryImpl.class, this, ExplorerPackage.DEVICE__OPEN_PORTS);
		}
		return openPorts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExplorerPackage.DEVICE__PORT:
				return basicSetPort(null, msgs);
			case ExplorerPackage.DEVICE__OPEN_PORTS:
				return ((InternalEList<?>)getOpenPorts()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExplorerPackage.DEVICE__IP:
				return getIp();
			case ExplorerPackage.DEVICE__HOST:
				return getHost();
			case ExplorerPackage.DEVICE__MASK:
				return getMask();
			case ExplorerPackage.DEVICE__INTERFACES:
				return getInterfaces();
			case ExplorerPackage.DEVICE__TYPE:
				return getType();
			case ExplorerPackage.DEVICE__PORT:
				return getPort();
			case ExplorerPackage.DEVICE__OPEN_PORTS:
				if (coreType) return getOpenPorts();
				else return getOpenPorts().map();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ExplorerPackage.DEVICE__IP:
				setIp((String)newValue);
				return;
			case ExplorerPackage.DEVICE__HOST:
				setHost((String)newValue);
				return;
			case ExplorerPackage.DEVICE__MASK:
				setMask((String)newValue);
				return;
			case ExplorerPackage.DEVICE__INTERFACES:
				getInterfaces().clear();
				getInterfaces().addAll((Collection<? extends Object>)newValue);
				return;
			case ExplorerPackage.DEVICE__TYPE:
				setType((EDeviceType)newValue);
				return;
			case ExplorerPackage.DEVICE__PORT:
				setPort((Port)newValue);
				return;
			case ExplorerPackage.DEVICE__OPEN_PORTS:
				((EStructuralFeature.Setting)getOpenPorts()).set(newValue);
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
			case ExplorerPackage.DEVICE__IP:
				setIp(IP_EDEFAULT);
				return;
			case ExplorerPackage.DEVICE__HOST:
				setHost(HOST_EDEFAULT);
				return;
			case ExplorerPackage.DEVICE__MASK:
				setMask(MASK_EDEFAULT);
				return;
			case ExplorerPackage.DEVICE__INTERFACES:
				getInterfaces().clear();
				return;
			case ExplorerPackage.DEVICE__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case ExplorerPackage.DEVICE__PORT:
				setPort((Port)null);
				return;
			case ExplorerPackage.DEVICE__OPEN_PORTS:
				getOpenPorts().clear();
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
			case ExplorerPackage.DEVICE__IP:
				return IP_EDEFAULT == null ? ip != null : !IP_EDEFAULT.equals(ip);
			case ExplorerPackage.DEVICE__HOST:
				return HOST_EDEFAULT == null ? host != null : !HOST_EDEFAULT.equals(host);
			case ExplorerPackage.DEVICE__MASK:
				return MASK_EDEFAULT == null ? mask != null : !MASK_EDEFAULT.equals(mask);
			case ExplorerPackage.DEVICE__INTERFACES:
				return interfaces != null && !interfaces.isEmpty();
			case ExplorerPackage.DEVICE__TYPE:
				return type != TYPE_EDEFAULT;
			case ExplorerPackage.DEVICE__PORT:
				return port != null;
			case ExplorerPackage.DEVICE__OPEN_PORTS:
				return openPorts != null && !openPorts.isEmpty();
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
		result.append(" (ip: ");
		result.append(ip);
		result.append(", host: ");
		result.append(host);
		result.append(", mask: ");
		result.append(mask);
		result.append(", interfaces: ");
		result.append(interfaces);
		result.append(", type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //DeviceImpl
