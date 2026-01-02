/**
 */
package eu.kalafatic.explorer.model.explorer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>EDevice Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see eu.kalafatic.explorer.model.explorer.ExplorerPackage#getEDeviceType()
 * @model
 * @generated
 */
public enum EDeviceType implements Enumerator {
	/**
	 * The '<em><b>Computer</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COMPUTER_VALUE
	 * @generated
	 * @ordered
	 */
	COMPUTER(0, "Computer", "Computer"),

	/**
	 * The '<em><b>Router</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROUTER_VALUE
	 * @generated
	 * @ordered
	 */
	ROUTER(1, "Router", "Router"),

	/**
	 * The '<em><b>Switch</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SWITCH_VALUE
	 * @generated
	 * @ordered
	 */
	SWITCH(2, "Switch", "Switch");

	/**
	 * The '<em><b>Computer</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Computer</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COMPUTER
	 * @model name="Computer"
	 * @generated
	 * @ordered
	 */
	public static final int COMPUTER_VALUE = 0;

	/**
	 * The '<em><b>Router</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Router</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ROUTER
	 * @model name="Router"
	 * @generated
	 * @ordered
	 */
	public static final int ROUTER_VALUE = 1;

	/**
	 * The '<em><b>Switch</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Switch</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SWITCH
	 * @model name="Switch"
	 * @generated
	 * @ordered
	 */
	public static final int SWITCH_VALUE = 2;

	/**
	 * An array of all the '<em><b>EDevice Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final EDeviceType[] VALUES_ARRAY =
		new EDeviceType[] {
			COMPUTER,
			ROUTER,
			SWITCH,
		};

	/**
	 * A public read-only list of all the '<em><b>EDevice Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<EDeviceType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>EDevice Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EDeviceType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EDeviceType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>EDevice Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EDeviceType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EDeviceType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>EDevice Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EDeviceType get(int value) {
		switch (value) {
			case COMPUTER_VALUE: return COMPUTER;
			case ROUTER_VALUE: return ROUTER;
			case SWITCH_VALUE: return SWITCH;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDeviceType(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
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
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //EDeviceType
