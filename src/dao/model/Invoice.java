package dao.model;

import java.io.Serializable;
import java.util.Date;

/**
 * This class represents the Invoice model. This model class can be used
 * thoroughout all layers, the data layer, the controller layer and the view
 * layer.
 *
 * @author Ahmed Gamal
 */

public class Invoice implements Serializable {

	private Long invoiceId;

	private Long customerId;
	private Long addressId;
	private String invoiceType;
	private String invoiceTypeLocalized;
	private Date invoiceDate;
	private Long invoiceNumber;
	private Date startDate;
	private Date paymentDueDate;
	private Date endDate;
	private String periodDescription;
	private Long vatAmount;
	private Long amount;
	private String totalAmount;
	private static final long serialVersionUID = 1L;

	public enum InvoiceType {
		AdvancePayment, ShopPurchase

	}



	public Long getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Long invoiceId) {
		this.invoiceId = invoiceId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}

	public String getInvoiceTypeLocalized() {
		return invoiceTypeLocalized;
	}

	public void setInvoiceTypeLocalized(String invoiceTypeLocalized) {
		this.invoiceTypeLocalized = invoiceTypeLocalized;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public Long getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(Long invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getPaymentDueDate() {
		return paymentDueDate;
	}

	public void setPaymentDueDate(Date paymentDueDate) {
		this.paymentDueDate = paymentDueDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getPeriodDescription() {
		return periodDescription;
	}

	public void setPeriodDescription(String periodDescription) {
		this.periodDescription = periodDescription;
	}

	public Long getVatAmount() {
		return vatAmount;
	}

	public void setVatAmount(Long vatAmount) {
		this.vatAmount = vatAmount;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	// Object overrides
	// ---------------------------------------------------------------------------

	/**
	 * The Invoice ID is unique for each Invoice. So this should compare Invoice
	 * by ID only.
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object other) {
		return (other instanceof Invoice) && (invoiceId != null) ? invoiceId
				.equals(((Invoice) other).invoiceId) : (other == this);
	}

	/**
	 * The Invoice ID is unique for each Invoice. So Invoice with same ID should
	 * return same hashcode.
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return (invoiceId != null) ? (this.getClass().hashCode() + invoiceId.hashCode())
				: super.hashCode();
	}

	/**
	 * Returns the String representation of this Invoice. Not required, it just
	 * pleases reading logs.
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("Invoice[id=%d,invoiceNumber=%s,totalAmount=%s]",
				invoiceId, invoiceNumber, totalAmount);
	}
}
