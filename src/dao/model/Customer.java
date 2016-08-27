package dao.model;

import java.io.Serializable;

/**
 * This class represents the Cutomer model. This model class can be used
 * thoroughout all layers, the data layer, the controller layer and the view
 * layer.
 *
 * @author Ahmed Gamal
 */
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long customerId;
	private String email;
	private String name;

	

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// Object overrides
	// ---------------------------------------------------------------------------

	/**
	 * The Customer ID is unique for each Customer. So this should compare
	 * Customer by ID only.
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object other) {
		return (other instanceof Customer) && (customerId != null) ? customerId
				.equals(((Customer) other).customerId) : (other == this);
	}

	/**
	 * The Customer ID is unique for each Customer. So Customer with same ID
	 * should return same hashcode.
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return (customerId != null) ? (this.getClass().hashCode() + customerId.hashCode())
				: super.hashCode();
	}

	/**
	 * Returns the String representation of this Customer. Not required, it just
	 * pleases reading logs.
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("Customer[id=%d,email=%s,name=%s]", customerId, email,
				name);
	}
}
