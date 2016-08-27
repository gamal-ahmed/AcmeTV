package dao.model;

import java.io.Serializable;

/**
 * This class represents the Cutomer model. This model class can be used
 * thoroughout all layers, the data layer, the controller layer and the view
 * layer.
 *
 * @author Ahmed Gamal
 */
public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long customer_id;
	private String address;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
		return (other instanceof Address) && (id != null) ? id
				.equals(((Address) other).id) : (other == this);
	}

	/**
	 * The Customer ID is unique for each Customer. So Customer with same ID
	 * should return same hashcode.
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return (id != null) ? (this.getClass().hashCode() + id.hashCode())
				: super.hashCode();
	}

	/**
	 * Returns the String representation of this Customer. Not required, it just
	 * pleases reading logs.
	 * 
	 * @see java.lang.Object#toString()
	 */
//	@Override
//	public String toString() {
//		return String.format("Customer[id=%d,email=%s,name=%s]", id, email,
//				name);
//	}
}
