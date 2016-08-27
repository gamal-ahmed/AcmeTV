package webservice.response;

import java.util.List;

import dao.model.Invoice;

public class InvoicesResponse {

	private List<Invoice>invoices;

	public List<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}
	
}
