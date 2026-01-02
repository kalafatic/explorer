/**
 */
package eu.kalafatic.explorer.model.explorer.impl;

import eu.kalafatic.explorer.model.explorer.EProtocols;
import eu.kalafatic.explorer.model.explorer.ExplorerPackage;
import eu.kalafatic.explorer.model.explorer.Port;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Port</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.kalafatic.explorer.model.explorer.impl.PortImpl#getNumber <em>Number</em>}</li>
 *   <li>{@link eu.kalafatic.explorer.model.explorer.impl.PortImpl#getName <em>Name</em>}</li>
 *   <li>{@link eu.kalafatic.explorer.model.explorer.impl.PortImpl#getProtocols <em>Protocols</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PortImpl extends EObjectImpl implements Port {
	/**
	 * The default value of the '{@link #getNumber() <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumber()
	 * @generated
	 * @ordered
	 */
	protected static final int NUMBER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNumber() <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumber()
	 * @generated
	 * @ordered
	 */
	protected int number = NUMBER_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getProtocols() <em>Protocols</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProtocols()
	 * @generated
	 * @ordered
	 */
	protected static final EProtocols PROTOCOLS_EDEFAULT = EProtocols.TCP;

	/**
	 * The cached value of the '{@link #getProtocols() <em>Protocols</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProtocols()
	 * @generated
	 * @ordered
	 */
	protected EProtocols protocols = PROTOCOLS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PortImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExplorerPackage.Literals.PORT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumber(int newNumber) {
		int oldNumber = number;
		number = newNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExplorerPackage.PORT__NUMBER, oldNumber, number));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExplorerPackage.PORT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EProtocols getProtocols() {
		return protocols;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProtocols(EProtocols newProtocols) {
		EProtocols oldProtocols = protocols;
		protocols = newProtocols == null ? PROTOCOLS_EDEFAULT : newProtocols;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExplorerPackage.PORT__PROTOCOLS, oldProtocols, protocols));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExplorerPackage.PORT__NUMBER:
				return getNumber();
			case ExplorerPackage.PORT__NAME:
				return getName();
			case ExplorerPackage.PORT__PROTOCOLS:
				return getProtocols();
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
			case ExplorerPackage.PORT__NUMBER:
				setNumber((Integer)newValue);
				return;
			case ExplorerPackage.PORT__NAME:
				setName((String)newValue);
				return;
			case ExplorerPackage.PORT__PROTOCOLS:
				setProtocols((EProtocols)newValue);
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
			case ExplorerPackage.PORT__NUMBER:
				setNumber(NUMBER_EDEFAULT);
				return;
			case ExplorerPackage.PORT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ExplorerPackage.PORT__PROTOCOLS:
				setProtocols(PROTOCOLS_EDEFAULT);
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
			case ExplorerPackage.PORT__NUMBER:
				return number != NUMBER_EDEFAULT;
			case ExplorerPackage.PORT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ExplorerPackage.PORT__PROTOCOLS:
				return protocols != PROTOCOLS_EDEFAULT;
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
		result.append(" (number: ");
		result.append(number);
		result.append(", name: ");
		result.append(name);
		result.append(", protocols: ");
		result.append(protocols);
		result.append(')');
		return result.toString();
	}

} //PortImpl
