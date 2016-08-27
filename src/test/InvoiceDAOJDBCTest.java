package test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import dao.InvoiceDAOJDBC;
import dao.factory.DAOFactory;
import dao.model.Invoice;

public class InvoiceDAOJDBCTest {

	@Test
	public void testGetShopInvoicesOfCustomersPerMonth() {
		
		// (Long invoiceId, Long addressId,
		// String invoiceType, Long invoiceNumber, Long amount,
		// Date startDate, Date endDate, S'string nvoiceTypeLocalized,
		// Date paymentDueDate, String periodDescription, Long vatAmount,
		// String totalAmount,Date invoiceDate)
		int x = 3;
		System.out.println(x);

		List<Invoice> invoices = new ArrayList<Invoice>();
		Invoice s = creatInvoice(new Long(1),new Long(2), new Long(8212154),
				"AdvancePayment", new Long(1), new Long(32), new Date(
						"8/1/2016 1:00:00 AM"),
				new Date("8/1/2016 12:00:00 AM"), "Voorschot", new Date(
						"3/1/2016 12:00:00 AM"), "dasda", new Long(432),
				"423423", new Date("2/2/2016 12:00:00 AM"));
		Invoice s2 = creatInvoice(new Long(2),new Long(1), new Long(8212155),
				"AdvancePayment", new Long(2), new Long(2), new Date(
						"8/1/2016 1:00:00 AM"),
				new Date("8/1/2016 12:00:00 AM"), "q", new Date(
						"3/1/2016 12:00:00 AM"), "w", new Long(3),
				"4", new Date("2/2/2016 12:00:00 AM"));
		invoices.add(s2);
		DAOFactory factory = DAOFactory.getInstance("javabase.jdbc");
		InvoiceDAOJDBC invoicesJDBC = new InvoiceDAOJDBC(factory);
		assertEquals(invoices, invoicesJDBC.getInvoicesOfCustomersOfMonth(new Long(1), 8));
	}

	@Test
	public void testGetShopInvoicesOfPerAddress() {
	}

	@Test
	public void testGetInvoicesOfCustomer() {
	}

	@Test
	public void testGetInvoicesOfCustomersOfMonth() {

	}

	private Invoice creatInvoice(Long invoiceId, Long customerId,Long addressId,
			String invoiceType, Long invoiceNumber, Long amount,
			Date startDate, Date endDate, String nvoiceTypeLocalized,
			Date paymentDueDate, String periodDescription, Long vatAmount,
			String totalAmount, Date invoiceDate) {
		Invoice invoice = new Invoice();
		invoice.setCustomerId(customerId);
		invoice.setInvoiceId(invoiceId);
		invoice.setAddressId(addressId);
		invoice.setInvoiceType(invoiceType);
		invoice.setInvoiceNumber(invoiceNumber);
		invoice.setAmount(amount);
		invoice.setStartDate(startDate);
		invoice.setInvoiceDate(invoiceDate);
		invoice.setEndDate(endDate);
		invoice.setInvoiceTypeLocalized(nvoiceTypeLocalized);
		invoice.setPaymentDueDate(paymentDueDate);
		invoice.setPeriodDescription(periodDescription);
		invoice.setVatAmount(vatAmount);
		invoice.setTotalAmount(totalAmount);
		return invoice;
	}

}
