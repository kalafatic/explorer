/**
 */
package eu.kalafatic.explorer.model.explorer;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.kalafatic.explorer.model.explorer.Port#getNumber <em>Number</em>}</li>
 *   <li>{@link eu.kalafatic.explorer.model.explorer.Port#getName <em>Name</em>}</li>
 *   <li>{@link eu.kalafatic.explorer.model.explorer.Port#getProtocols <em>Protocols</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.kalafatic.explorer.model.explorer.ExplorerPackage#getPort()
 * @model
 * @generated
 */
public interface Port extends EObject {
	/**
	 * Returns the value of the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number</em>' attribute.
	 * @see #setNumber(int)
	 * @see eu.kalafatic.explorer.model.explorer.ExplorerPackage#getPort_Number()
	 * @model
	 * @generated
	 */
	int getNumber();

	/**
	 * Sets the value of the '{@link eu.kalafatic.explorer.model.explorer.Port#getNumber <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number</em>' attribute.
	 * @see #getNumber()
	 * @generated
	 */
	void setNumber(int value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see eu.kalafatic.explorer.model.explorer.ExplorerPackage#getPort_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link eu.kalafatic.explorer.model.explorer.Port#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Protocols</b></em>' attribute.
	 * The literals are from the enumeration {@link eu.kalafatic.explorer.model.explorer.EProtocols}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Protocols</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Protocols</em>' attribute.
	 * @see eu.kalafatic.explorer.model.explorer.EProtocols
	 * @see #setProtocols(EProtocols)
	 * @see eu.kalafatic.explorer.model.explorer.ExplorerPackage#getPort_Protocols()
	 * @model
	 * @generated
	 */
	EProtocols getProtocols();

	/**
	 * Sets the value of the '{@link eu.kalafatic.explorer.model.explorer.Port#getProtocols <em>Protocols</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Protocols</em>' attribute.
	 * @see eu.kalafatic.explorer.model.explorer.EProtocols
	 * @see #getProtocols()
	 * @generated
	 */
	void setProtocols(EProtocols value);

} // Port
