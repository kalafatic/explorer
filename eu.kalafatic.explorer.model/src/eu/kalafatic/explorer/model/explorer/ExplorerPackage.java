/**
 */
package eu.kalafatic.explorer.model.explorer;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see eu.kalafatic.explorer.model.explorer.ExplorerFactory
 * @model kind="package"
 * @generated
 */
public interface ExplorerPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "explorer";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///explorer.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "explorer";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExplorerPackage eINSTANCE = eu.kalafatic.explorer.model.explorer.impl.ExplorerPackageImpl.init();

	/**
	 * The meta object id for the '{@link eu.kalafatic.explorer.model.explorer.impl.ExplorerImpl <em>Explorer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.kalafatic.explorer.model.explorer.impl.ExplorerImpl
	 * @see eu.kalafatic.explorer.model.explorer.impl.ExplorerPackageImpl#getExplorer()
	 * @generated
	 */
	int EXPLORER = 0;

	/**
	 * The feature id for the '<em><b>Children</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPLORER__CHILDREN = 0;

	/**
	 * The number of structural features of the '<em>Explorer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPLORER_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link eu.kalafatic.explorer.model.explorer.impl.NodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.kalafatic.explorer.model.explorer.impl.NodeImpl
	 * @see eu.kalafatic.explorer.model.explorer.impl.ExplorerPackageImpl#getNode()
	 * @generated
	 */
	int NODE = 3;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__PARENT = 0;

	/**
	 * The feature id for the '<em><b>Children</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__CHILDREN = 1;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link eu.kalafatic.explorer.model.explorer.impl.DeviceImpl <em>Device</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.kalafatic.explorer.model.explorer.impl.DeviceImpl
	 * @see eu.kalafatic.explorer.model.explorer.impl.ExplorerPackageImpl#getDevice()
	 * @generated
	 */
	int DEVICE = 1;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__PARENT = NODE__PARENT;

	/**
	 * The feature id for the '<em><b>Children</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__CHILDREN = NODE__CHILDREN;

	/**
	 * The feature id for the '<em><b>Ip</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__IP = NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__HOST = NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Mask</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__MASK = NODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Interfaces</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__INTERFACES = NODE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__TYPE = NODE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Port</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__PORT = NODE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Open Ports</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__OPEN_PORTS = NODE_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Device</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_FEATURE_COUNT = NODE_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link eu.kalafatic.explorer.model.explorer.impl.RouteImpl <em>Route</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.kalafatic.explorer.model.explorer.impl.RouteImpl
	 * @see eu.kalafatic.explorer.model.explorer.impl.ExplorerPackageImpl#getRoute()
	 * @generated
	 */
	int ROUTE = 2;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE__PARENT = DEVICE__PARENT;

	/**
	 * The feature id for the '<em><b>Children</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE__CHILDREN = DEVICE__CHILDREN;

	/**
	 * The feature id for the '<em><b>Ip</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE__IP = DEVICE__IP;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE__HOST = DEVICE__HOST;

	/**
	 * The feature id for the '<em><b>Mask</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE__MASK = DEVICE__MASK;

	/**
	 * The feature id for the '<em><b>Interfaces</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE__INTERFACES = DEVICE__INTERFACES;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE__TYPE = DEVICE__TYPE;

	/**
	 * The feature id for the '<em><b>Port</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE__PORT = DEVICE__PORT;

	/**
	 * The feature id for the '<em><b>Open Ports</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE__OPEN_PORTS = DEVICE__OPEN_PORTS;

	/**
	 * The feature id for the '<em><b>Net Target</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE__NET_TARGET = DEVICE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Gateway</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE__GATEWAY = DEVICE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE__INTERFACE = DEVICE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Metrics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE__METRICS = DEVICE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Route</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE_FEATURE_COUNT = DEVICE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link eu.kalafatic.explorer.model.explorer.impl.StringToNodeMapEntryImpl <em>String To Node Map Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.kalafatic.explorer.model.explorer.impl.StringToNodeMapEntryImpl
	 * @see eu.kalafatic.explorer.model.explorer.impl.ExplorerPackageImpl#getStringToNodeMapEntry()
	 * @generated
	 */
	int STRING_TO_NODE_MAP_ENTRY = 4;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_NODE_MAP_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_NODE_MAP_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>String To Node Map Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_NODE_MAP_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link eu.kalafatic.explorer.model.explorer.impl.PortImpl <em>Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.kalafatic.explorer.model.explorer.impl.PortImpl
	 * @see eu.kalafatic.explorer.model.explorer.impl.ExplorerPackageImpl#getPort()
	 * @generated
	 */
	int PORT = 5;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__NUMBER = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__NAME = 1;

	/**
	 * The feature id for the '<em><b>Protocols</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__PROTOCOLS = 2;

	/**
	 * The number of structural features of the '<em>Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link eu.kalafatic.explorer.model.explorer.impl.IntegerToPortMapEntryImpl <em>Integer To Port Map Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.kalafatic.explorer.model.explorer.impl.IntegerToPortMapEntryImpl
	 * @see eu.kalafatic.explorer.model.explorer.impl.ExplorerPackageImpl#getIntegerToPortMapEntry()
	 * @generated
	 */
	int INTEGER_TO_PORT_MAP_ENTRY = 6;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_TO_PORT_MAP_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_TO_PORT_MAP_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Integer To Port Map Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_TO_PORT_MAP_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link eu.kalafatic.explorer.model.explorer.EDeviceType <em>EDevice Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.kalafatic.explorer.model.explorer.EDeviceType
	 * @see eu.kalafatic.explorer.model.explorer.impl.ExplorerPackageImpl#getEDeviceType()
	 * @generated
	 */
	int EDEVICE_TYPE = 7;

	/**
	 * The meta object id for the '{@link eu.kalafatic.explorer.model.explorer.EProtocols <em>EProtocols</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.kalafatic.explorer.model.explorer.EProtocols
	 * @see eu.kalafatic.explorer.model.explorer.impl.ExplorerPackageImpl#getEProtocols()
	 * @generated
	 */
	int EPROTOCOLS = 8;


	/**
	 * Returns the meta object for class '{@link eu.kalafatic.explorer.model.explorer.Explorer <em>Explorer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Explorer</em>'.
	 * @see eu.kalafatic.explorer.model.explorer.Explorer
	 * @generated
	 */
	EClass getExplorer();

	/**
	 * Returns the meta object for the map '{@link eu.kalafatic.explorer.model.explorer.Explorer#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Children</em>'.
	 * @see eu.kalafatic.explorer.model.explorer.Explorer#getChildren()
	 * @see #getExplorer()
	 * @generated
	 */
	EReference getExplorer_Children();

	/**
	 * Returns the meta object for class '{@link eu.kalafatic.explorer.model.explorer.Device <em>Device</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Device</em>'.
	 * @see eu.kalafatic.explorer.model.explorer.Device
	 * @generated
	 */
	EClass getDevice();

	/**
	 * Returns the meta object for the attribute '{@link eu.kalafatic.explorer.model.explorer.Device#getIp <em>Ip</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ip</em>'.
	 * @see eu.kalafatic.explorer.model.explorer.Device#getIp()
	 * @see #getDevice()
	 * @generated
	 */
	EAttribute getDevice_Ip();

	/**
	 * Returns the meta object for the attribute '{@link eu.kalafatic.explorer.model.explorer.Device#getHost <em>Host</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Host</em>'.
	 * @see eu.kalafatic.explorer.model.explorer.Device#getHost()
	 * @see #getDevice()
	 * @generated
	 */
	EAttribute getDevice_Host();

	/**
	 * Returns the meta object for the attribute '{@link eu.kalafatic.explorer.model.explorer.Device#getMask <em>Mask</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mask</em>'.
	 * @see eu.kalafatic.explorer.model.explorer.Device#getMask()
	 * @see #getDevice()
	 * @generated
	 */
	EAttribute getDevice_Mask();

	/**
	 * Returns the meta object for the attribute list '{@link eu.kalafatic.explorer.model.explorer.Device#getInterfaces <em>Interfaces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Interfaces</em>'.
	 * @see eu.kalafatic.explorer.model.explorer.Device#getInterfaces()
	 * @see #getDevice()
	 * @generated
	 */
	EAttribute getDevice_Interfaces();

	/**
	 * Returns the meta object for the attribute '{@link eu.kalafatic.explorer.model.explorer.Device#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see eu.kalafatic.explorer.model.explorer.Device#getType()
	 * @see #getDevice()
	 * @generated
	 */
	EAttribute getDevice_Type();

	/**
	 * Returns the meta object for the containment reference '{@link eu.kalafatic.explorer.model.explorer.Device#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Port</em>'.
	 * @see eu.kalafatic.explorer.model.explorer.Device#getPort()
	 * @see #getDevice()
	 * @generated
	 */
	EReference getDevice_Port();

	/**
	 * Returns the meta object for the map '{@link eu.kalafatic.explorer.model.explorer.Device#getOpenPorts <em>Open Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Open Ports</em>'.
	 * @see eu.kalafatic.explorer.model.explorer.Device#getOpenPorts()
	 * @see #getDevice()
	 * @generated
	 */
	EReference getDevice_OpenPorts();

	/**
	 * Returns the meta object for class '{@link eu.kalafatic.explorer.model.explorer.Route <em>Route</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Route</em>'.
	 * @see eu.kalafatic.explorer.model.explorer.Route
	 * @generated
	 */
	EClass getRoute();

	/**
	 * Returns the meta object for the attribute '{@link eu.kalafatic.explorer.model.explorer.Route#getNetTarget <em>Net Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Net Target</em>'.
	 * @see eu.kalafatic.explorer.model.explorer.Route#getNetTarget()
	 * @see #getRoute()
	 * @generated
	 */
	EAttribute getRoute_NetTarget();

	/**
	 * Returns the meta object for the attribute '{@link eu.kalafatic.explorer.model.explorer.Route#getGateway <em>Gateway</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Gateway</em>'.
	 * @see eu.kalafatic.explorer.model.explorer.Route#getGateway()
	 * @see #getRoute()
	 * @generated
	 */
	EAttribute getRoute_Gateway();

	/**
	 * Returns the meta object for the attribute '{@link eu.kalafatic.explorer.model.explorer.Route#getInterface <em>Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Interface</em>'.
	 * @see eu.kalafatic.explorer.model.explorer.Route#getInterface()
	 * @see #getRoute()
	 * @generated
	 */
	EAttribute getRoute_Interface();

	/**
	 * Returns the meta object for the attribute '{@link eu.kalafatic.explorer.model.explorer.Route#getMetrics <em>Metrics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Metrics</em>'.
	 * @see eu.kalafatic.explorer.model.explorer.Route#getMetrics()
	 * @see #getRoute()
	 * @generated
	 */
	EAttribute getRoute_Metrics();

	/**
	 * Returns the meta object for class '{@link eu.kalafatic.explorer.model.explorer.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see eu.kalafatic.explorer.model.explorer.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for the containment reference '{@link eu.kalafatic.explorer.model.explorer.Node#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Parent</em>'.
	 * @see eu.kalafatic.explorer.model.explorer.Node#getParent()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Parent();

	/**
	 * Returns the meta object for the map '{@link eu.kalafatic.explorer.model.explorer.Node#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Children</em>'.
	 * @see eu.kalafatic.explorer.model.explorer.Node#getChildren()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Children();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>String To Node Map Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String To Node Map Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString"
	 *        valueType="eu.kalafatic.explorer.model.explorer.Node" valueContainment="true"
	 * @generated
	 */
	EClass getStringToNodeMapEntry();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToNodeMapEntry()
	 * @generated
	 */
	EAttribute getStringToNodeMapEntry_Key();

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToNodeMapEntry()
	 * @generated
	 */
	EReference getStringToNodeMapEntry_Value();

	/**
	 * Returns the meta object for class '{@link eu.kalafatic.explorer.model.explorer.Port <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port</em>'.
	 * @see eu.kalafatic.explorer.model.explorer.Port
	 * @generated
	 */
	EClass getPort();

	/**
	 * Returns the meta object for the attribute '{@link eu.kalafatic.explorer.model.explorer.Port#getNumber <em>Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number</em>'.
	 * @see eu.kalafatic.explorer.model.explorer.Port#getNumber()
	 * @see #getPort()
	 * @generated
	 */
	EAttribute getPort_Number();

	/**
	 * Returns the meta object for the attribute '{@link eu.kalafatic.explorer.model.explorer.Port#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see eu.kalafatic.explorer.model.explorer.Port#getName()
	 * @see #getPort()
	 * @generated
	 */
	EAttribute getPort_Name();

	/**
	 * Returns the meta object for the attribute '{@link eu.kalafatic.explorer.model.explorer.Port#getProtocols <em>Protocols</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Protocols</em>'.
	 * @see eu.kalafatic.explorer.model.explorer.Port#getProtocols()
	 * @see #getPort()
	 * @generated
	 */
	EAttribute getPort_Protocols();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Integer To Port Map Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer To Port Map Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EIntegerObject"
	 *        valueType="eu.kalafatic.explorer.model.explorer.Port" valueContainment="true"
	 * @generated
	 */
	EClass getIntegerToPortMapEntry();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getIntegerToPortMapEntry()
	 * @generated
	 */
	EAttribute getIntegerToPortMapEntry_Key();

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getIntegerToPortMapEntry()
	 * @generated
	 */
	EReference getIntegerToPortMapEntry_Value();

	/**
	 * Returns the meta object for enum '{@link eu.kalafatic.explorer.model.explorer.EDeviceType <em>EDevice Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EDevice Type</em>'.
	 * @see eu.kalafatic.explorer.model.explorer.EDeviceType
	 * @generated
	 */
	EEnum getEDeviceType();

	/**
	 * Returns the meta object for enum '{@link eu.kalafatic.explorer.model.explorer.EProtocols <em>EProtocols</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EProtocols</em>'.
	 * @see eu.kalafatic.explorer.model.explorer.EProtocols
	 * @generated
	 */
	EEnum getEProtocols();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ExplorerFactory getExplorerFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link eu.kalafatic.explorer.model.explorer.impl.ExplorerImpl <em>Explorer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.kalafatic.explorer.model.explorer.impl.ExplorerImpl
		 * @see eu.kalafatic.explorer.model.explorer.impl.ExplorerPackageImpl#getExplorer()
		 * @generated
		 */
		EClass EXPLORER = eINSTANCE.getExplorer();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPLORER__CHILDREN = eINSTANCE.getExplorer_Children();

		/**
		 * The meta object literal for the '{@link eu.kalafatic.explorer.model.explorer.impl.DeviceImpl <em>Device</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.kalafatic.explorer.model.explorer.impl.DeviceImpl
		 * @see eu.kalafatic.explorer.model.explorer.impl.ExplorerPackageImpl#getDevice()
		 * @generated
		 */
		EClass DEVICE = eINSTANCE.getDevice();

		/**
		 * The meta object literal for the '<em><b>Ip</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVICE__IP = eINSTANCE.getDevice_Ip();

		/**
		 * The meta object literal for the '<em><b>Host</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVICE__HOST = eINSTANCE.getDevice_Host();

		/**
		 * The meta object literal for the '<em><b>Mask</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVICE__MASK = eINSTANCE.getDevice_Mask();

		/**
		 * The meta object literal for the '<em><b>Interfaces</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVICE__INTERFACES = eINSTANCE.getDevice_Interfaces();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVICE__TYPE = eINSTANCE.getDevice_Type();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEVICE__PORT = eINSTANCE.getDevice_Port();

		/**
		 * The meta object literal for the '<em><b>Open Ports</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEVICE__OPEN_PORTS = eINSTANCE.getDevice_OpenPorts();

		/**
		 * The meta object literal for the '{@link eu.kalafatic.explorer.model.explorer.impl.RouteImpl <em>Route</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.kalafatic.explorer.model.explorer.impl.RouteImpl
		 * @see eu.kalafatic.explorer.model.explorer.impl.ExplorerPackageImpl#getRoute()
		 * @generated
		 */
		EClass ROUTE = eINSTANCE.getRoute();

		/**
		 * The meta object literal for the '<em><b>Net Target</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROUTE__NET_TARGET = eINSTANCE.getRoute_NetTarget();

		/**
		 * The meta object literal for the '<em><b>Gateway</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROUTE__GATEWAY = eINSTANCE.getRoute_Gateway();

		/**
		 * The meta object literal for the '<em><b>Interface</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROUTE__INTERFACE = eINSTANCE.getRoute_Interface();

		/**
		 * The meta object literal for the '<em><b>Metrics</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROUTE__METRICS = eINSTANCE.getRoute_Metrics();

		/**
		 * The meta object literal for the '{@link eu.kalafatic.explorer.model.explorer.impl.NodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.kalafatic.explorer.model.explorer.impl.NodeImpl
		 * @see eu.kalafatic.explorer.model.explorer.impl.ExplorerPackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__PARENT = eINSTANCE.getNode_Parent();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__CHILDREN = eINSTANCE.getNode_Children();

		/**
		 * The meta object literal for the '{@link eu.kalafatic.explorer.model.explorer.impl.StringToNodeMapEntryImpl <em>String To Node Map Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.kalafatic.explorer.model.explorer.impl.StringToNodeMapEntryImpl
		 * @see eu.kalafatic.explorer.model.explorer.impl.ExplorerPackageImpl#getStringToNodeMapEntry()
		 * @generated
		 */
		EClass STRING_TO_NODE_MAP_ENTRY = eINSTANCE.getStringToNodeMapEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_TO_NODE_MAP_ENTRY__KEY = eINSTANCE.getStringToNodeMapEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRING_TO_NODE_MAP_ENTRY__VALUE = eINSTANCE.getStringToNodeMapEntry_Value();

		/**
		 * The meta object literal for the '{@link eu.kalafatic.explorer.model.explorer.impl.PortImpl <em>Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.kalafatic.explorer.model.explorer.impl.PortImpl
		 * @see eu.kalafatic.explorer.model.explorer.impl.ExplorerPackageImpl#getPort()
		 * @generated
		 */
		EClass PORT = eINSTANCE.getPort();

		/**
		 * The meta object literal for the '<em><b>Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT__NUMBER = eINSTANCE.getPort_Number();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT__NAME = eINSTANCE.getPort_Name();

		/**
		 * The meta object literal for the '<em><b>Protocols</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT__PROTOCOLS = eINSTANCE.getPort_Protocols();

		/**
		 * The meta object literal for the '{@link eu.kalafatic.explorer.model.explorer.impl.IntegerToPortMapEntryImpl <em>Integer To Port Map Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.kalafatic.explorer.model.explorer.impl.IntegerToPortMapEntryImpl
		 * @see eu.kalafatic.explorer.model.explorer.impl.ExplorerPackageImpl#getIntegerToPortMapEntry()
		 * @generated
		 */
		EClass INTEGER_TO_PORT_MAP_ENTRY = eINSTANCE.getIntegerToPortMapEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER_TO_PORT_MAP_ENTRY__KEY = eINSTANCE.getIntegerToPortMapEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTEGER_TO_PORT_MAP_ENTRY__VALUE = eINSTANCE.getIntegerToPortMapEntry_Value();

		/**
		 * The meta object literal for the '{@link eu.kalafatic.explorer.model.explorer.EDeviceType <em>EDevice Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.kalafatic.explorer.model.explorer.EDeviceType
		 * @see eu.kalafatic.explorer.model.explorer.impl.ExplorerPackageImpl#getEDeviceType()
		 * @generated
		 */
		EEnum EDEVICE_TYPE = eINSTANCE.getEDeviceType();

		/**
		 * The meta object literal for the '{@link eu.kalafatic.explorer.model.explorer.EProtocols <em>EProtocols</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.kalafatic.explorer.model.explorer.EProtocols
		 * @see eu.kalafatic.explorer.model.explorer.impl.ExplorerPackageImpl#getEProtocols()
		 * @generated
		 */
		EEnum EPROTOCOLS = eINSTANCE.getEProtocols();

	}

} //ExplorerPackage
