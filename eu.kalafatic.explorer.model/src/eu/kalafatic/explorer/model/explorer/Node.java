/**
 */
package eu.kalafatic.explorer.model.explorer;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.kalafatic.explorer.model.explorer.Node#getParent <em>Parent</em>}</li>
 *   <li>{@link eu.kalafatic.explorer.model.explorer.Node#getChildren <em>Children</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.kalafatic.explorer.model.explorer.ExplorerPackage#getNode()
 * @model
 * @generated
 */
public interface Node extends EObject {
	/**
	 * Returns the value of the '<em><b>Parent</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' containment reference.
	 * @see #setParent(Node)
	 * @see eu.kalafatic.explorer.model.explorer.ExplorerPackage#getNode_Parent()
	 * @model containment="true"
	 * @generated
	 */
	Node getParent();

	/**
	 * Sets the value of the '{@link eu.kalafatic.explorer.model.explorer.Node#getParent <em>Parent</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' containment reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(Node value);

	/**
	 * Returns the value of the '<em><b>Children</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link eu.kalafatic.explorer.model.explorer.Node},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' map.
	 * @see eu.kalafatic.explorer.model.explorer.ExplorerPackage#getNode_Children()
	 * @model mapType="eu.kalafatic.explorer.model.explorer.StringToNodeMapEntry<org.eclipse.emf.ecore.EString, eu.kalafatic.explorer.model.explorer.Node>"
	 * @generated
	 */
	EMap<String, Node> getChildren();

} // Node
