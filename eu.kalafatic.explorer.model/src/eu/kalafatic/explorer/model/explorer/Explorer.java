/**
 */
package eu.kalafatic.explorer.model.explorer;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Explorer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.kalafatic.explorer.model.explorer.Explorer#getChildren <em>Children</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.kalafatic.explorer.model.explorer.ExplorerPackage#getExplorer()
 * @model
 * @generated
 */
public interface Explorer extends EObject {
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
	 * @see eu.kalafatic.explorer.model.explorer.ExplorerPackage#getExplorer_Children()
	 * @model mapType="eu.kalafatic.explorer.model.explorer.StringToNodeMapEntry<org.eclipse.emf.ecore.EString, eu.kalafatic.explorer.model.explorer.Node>"
	 * @generated
	 */
	EMap<String, Node> getChildren();

} // Explorer
