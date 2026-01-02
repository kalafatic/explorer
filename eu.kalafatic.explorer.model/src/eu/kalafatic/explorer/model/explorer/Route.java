/**
 */
package eu.kalafatic.explorer.model.explorer;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Route</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.kalafatic.explorer.model.explorer.Route#getNetTarget <em>Net Target</em>}</li>
 *   <li>{@link eu.kalafatic.explorer.model.explorer.Route#getGateway <em>Gateway</em>}</li>
 *   <li>{@link eu.kalafatic.explorer.model.explorer.Route#getInterface <em>Interface</em>}</li>
 *   <li>{@link eu.kalafatic.explorer.model.explorer.Route#getMetrics <em>Metrics</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.kalafatic.explorer.model.explorer.ExplorerPackage#getRoute()
 * @model
 * @generated
 */
public interface Route extends Device {
	/**
	 * Returns the value of the '<em><b>Net Target</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Net Target</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Net Target</em>' attribute.
	 * @see #setNetTarget(String)
	 * @see eu.kalafatic.explorer.model.explorer.ExplorerPackage#getRoute_NetTarget()
	 * @model
	 * @generated
	 */
	String getNetTarget();

	/**
	 * Sets the value of the '{@link eu.kalafatic.explorer.model.explorer.Route#getNetTarget <em>Net Target</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Net Target</em>' attribute.
	 * @see #getNetTarget()
	 * @generated
	 */
	void setNetTarget(String value);

	/**
	 * Returns the value of the '<em><b>Gateway</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gateway</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gateway</em>' attribute.
	 * @see #setGateway(String)
	 * @see eu.kalafatic.explorer.model.explorer.ExplorerPackage#getRoute_Gateway()
	 * @model
	 * @generated
	 */
	String getGateway();

	/**
	 * Sets the value of the '{@link eu.kalafatic.explorer.model.explorer.Route#getGateway <em>Gateway</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gateway</em>' attribute.
	 * @see #getGateway()
	 * @generated
	 */
	void setGateway(String value);

	/**
	 * Returns the value of the '<em><b>Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interface</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interface</em>' attribute.
	 * @see #setInterface(String)
	 * @see eu.kalafatic.explorer.model.explorer.ExplorerPackage#getRoute_Interface()
	 * @model
	 * @generated
	 */
	String getInterface();

	/**
	 * Sets the value of the '{@link eu.kalafatic.explorer.model.explorer.Route#getInterface <em>Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interface</em>' attribute.
	 * @see #getInterface()
	 * @generated
	 */
	void setInterface(String value);

	/**
	 * Returns the value of the '<em><b>Metrics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metrics</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metrics</em>' attribute.
	 * @see #setMetrics(int)
	 * @see eu.kalafatic.explorer.model.explorer.ExplorerPackage#getRoute_Metrics()
	 * @model
	 * @generated
	 */
	int getMetrics();

	/**
	 * Sets the value of the '{@link eu.kalafatic.explorer.model.explorer.Route#getMetrics <em>Metrics</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metrics</em>' attribute.
	 * @see #getMetrics()
	 * @generated
	 */
	void setMetrics(int value);

} // Route
