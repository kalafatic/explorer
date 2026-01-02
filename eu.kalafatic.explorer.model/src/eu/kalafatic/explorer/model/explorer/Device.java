/**
 */
package eu.kalafatic.explorer.model.explorer;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Device</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.kalafatic.explorer.model.explorer.Device#getIp <em>Ip</em>}</li>
 *   <li>{@link eu.kalafatic.explorer.model.explorer.Device#getHost <em>Host</em>}</li>
 *   <li>{@link eu.kalafatic.explorer.model.explorer.Device#getMask <em>Mask</em>}</li>
 *   <li>{@link eu.kalafatic.explorer.model.explorer.Device#getInterfaces <em>Interfaces</em>}</li>
 *   <li>{@link eu.kalafatic.explorer.model.explorer.Device#getType <em>Type</em>}</li>
 *   <li>{@link eu.kalafatic.explorer.model.explorer.Device#getPort <em>Port</em>}</li>
 *   <li>{@link eu.kalafatic.explorer.model.explorer.Device#getOpenPorts <em>Open Ports</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.kalafatic.explorer.model.explorer.ExplorerPackage#getDevice()
 * @model
 * @generated
 */
public interface Device extends Node {
	/**
	 * Returns the value of the '<em><b>Ip</b></em>' attribute.
	 * The default value is <code>"0.0.0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ip</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ip</em>' attribute.
	 * @see #setIp(String)
	 * @see eu.kalafatic.explorer.model.explorer.ExplorerPackage#getDevice_Ip()
	 * @model default="0.0.0.0"
	 * @generated
	 */
	String getIp();

	/**
	 * Sets the value of the '{@link eu.kalafatic.explorer.model.explorer.Device#getIp <em>Ip</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ip</em>' attribute.
	 * @see #getIp()
	 * @generated
	 */
	void setIp(String value);

	/**
	 * Returns the value of the '<em><b>Host</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Host</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Host</em>' attribute.
	 * @see #setHost(String)
	 * @see eu.kalafatic.explorer.model.explorer.ExplorerPackage#getDevice_Host()
	 * @model default=""
	 * @generated
	 */
	String getHost();

	/**
	 * Sets the value of the '{@link eu.kalafatic.explorer.model.explorer.Device#getHost <em>Host</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Host</em>' attribute.
	 * @see #getHost()
	 * @generated
	 */
	void setHost(String value);

	/**
	 * Returns the value of the '<em><b>Mask</b></em>' attribute.
	 * The default value is <code>"24"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mask</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mask</em>' attribute.
	 * @see #setMask(String)
	 * @see eu.kalafatic.explorer.model.explorer.ExplorerPackage#getDevice_Mask()
	 * @model default="24"
	 * @generated
	 */
	String getMask();

	/**
	 * Sets the value of the '{@link eu.kalafatic.explorer.model.explorer.Device#getMask <em>Mask</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mask</em>' attribute.
	 * @see #getMask()
	 * @generated
	 */
	void setMask(String value);

	/**
	 * Returns the value of the '<em><b>Interfaces</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Object}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interfaces</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interfaces</em>' attribute list.
	 * @see eu.kalafatic.explorer.model.explorer.ExplorerPackage#getDevice_Interfaces()
	 * @model
	 * @generated
	 */
	EList<Object> getInterfaces();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link eu.kalafatic.explorer.model.explorer.EDeviceType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see eu.kalafatic.explorer.model.explorer.EDeviceType
	 * @see #setType(EDeviceType)
	 * @see eu.kalafatic.explorer.model.explorer.ExplorerPackage#getDevice_Type()
	 * @model
	 * @generated
	 */
	EDeviceType getType();

	/**
	 * Sets the value of the '{@link eu.kalafatic.explorer.model.explorer.Device#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see eu.kalafatic.explorer.model.explorer.EDeviceType
	 * @see #getType()
	 * @generated
	 */
	void setType(EDeviceType value);

	/**
	 * Returns the value of the '<em><b>Port</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Port</em>' containment reference.
	 * @see #setPort(Port)
	 * @see eu.kalafatic.explorer.model.explorer.ExplorerPackage#getDevice_Port()
	 * @model containment="true"
	 * @generated
	 */
	Port getPort();

	/**
	 * Sets the value of the '{@link eu.kalafatic.explorer.model.explorer.Device#getPort <em>Port</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port</em>' containment reference.
	 * @see #getPort()
	 * @generated
	 */
	void setPort(Port value);

	/**
	 * Returns the value of the '<em><b>Open Ports</b></em>' map.
	 * The key is of type {@link java.lang.Integer},
	 * and the value is of type {@link eu.kalafatic.explorer.model.explorer.Port},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Open Ports</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Open Ports</em>' map.
	 * @see eu.kalafatic.explorer.model.explorer.ExplorerPackage#getDevice_OpenPorts()
	 * @model mapType="eu.kalafatic.explorer.model.explorer.IntegerToPortMapEntry<org.eclipse.emf.ecore.EIntegerObject, eu.kalafatic.explorer.model.explorer.Port>"
	 * @generated
	 */
	EMap<Integer, Port> getOpenPorts();

} // Device
