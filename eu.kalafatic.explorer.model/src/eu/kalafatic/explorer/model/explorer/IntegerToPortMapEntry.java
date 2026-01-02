/**
 */
package eu.kalafatic.explorer.model.explorer;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Integer To Port Map Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.kalafatic.explorer.model.explorer.IntegerToPortMapEntry#getKey <em>Key</em>}</li>
 *   <li>{@link eu.kalafatic.explorer.model.explorer.IntegerToPortMapEntry#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.kalafatic.explorer.model.explorer.ExplorerPackage#getIntegerToPortMapEntry()
 * @model
 * @generated
 */
public interface IntegerToPortMapEntry extends EObject {
	/**
	 * Returns the value of the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Key</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Key</em>' attribute.
	 * @see #setKey(Integer)
	 * @see eu.kalafatic.explorer.model.explorer.ExplorerPackage#getIntegerToPortMapEntry_Key()
	 * @model
	 * @generated
	 */
	Integer getKey();

	/**
	 * Sets the value of the '{@link eu.kalafatic.explorer.model.explorer.IntegerToPortMapEntry#getKey <em>Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Key</em>' attribute.
	 * @see #getKey()
	 * @generated
	 */
	void setKey(Integer value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(Port)
	 * @see eu.kalafatic.explorer.model.explorer.ExplorerPackage#getIntegerToPortMapEntry_Value()
	 * @model containment="true"
	 * @generated
	 */
	Port getValue();

	/**
	 * Sets the value of the '{@link eu.kalafatic.explorer.model.explorer.IntegerToPortMapEntry#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Port value);

} // IntegerToPortMapEntry
