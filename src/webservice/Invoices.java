package webservice;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import webservice.response.InvoicesResponse;
import com.google.gson.Gson;
import dao.InvoiceDAOJDBC;
import dao.factory.DAOFactory;
import dao.model.Invoice;

@Path("/v1.0")
public class Invoices {

	// http://localhost/sysapi/v1.0/invoices/?customerId=1&month=3
	@GET
	@Path("/invoices")
	@Produces("application/json")
	public Response getInvoicesPerMonth(
			@QueryParam(value = "customerId") Long customerId,
			@QueryParam(value = "month") int month) {
		InvoicesResponse response = new InvoicesResponse();

		List<Invoice> invoicesList;
		DAOFactory factory = DAOFactory.getInstance("javabase.jdbc");
		InvoiceDAOJDBC invoicesJDBC = new InvoiceDAOJDBC(factory);

		invoicesList = invoicesJDBC.getInvoicesOfCustomersOfMonth(customerId,
				month);
		Gson gson = new Gson();
		response.setInvoices(invoicesList);
		String json = gson.toJson(response);
		return Response.status(200).entity(json).build();

	}

	// http://localhost/sysapi/v1.0/invoices/?customerId=1&filter=shop&month=3

	@GET
	@Path("/invoices/shop")
	@Produces("application/json")
	public Response shopInvoices(
			@QueryParam(value = "customerId") Long customerId,
			@QueryParam(value = "month") int month,
			@QueryParam(value = "filter") String filter) {
		InvoicesResponse response = new InvoicesResponse();

		List<Invoice> invoicesList;
		DAOFactory factory = DAOFactory.getInstance("javabase.jdbc");
		InvoiceDAOJDBC invoicesJDBC = new InvoiceDAOJDBC(factory);

		invoicesList = invoicesJDBC.getShopInvoicesOfCustomersPerMonth(
				customerId, month, filter);
		Gson gson = new Gson();
		response.setInvoices(invoicesList);
		String json = gson.toJson(response);
		return Response.status(200).entity(json).build();

	}

	// http://localhost/sysapi/v1.0/invoices/?customerId=1&addressId=8212BJ154
	@GET
	@Path("/invoices/address")
	@Produces("application/json")
	public Response invoicesHistoryPerAddress(
			@QueryParam(value = "customerId") Long customerId,
			@QueryParam(value = "address") String addressId) {
		InvoicesResponse response = new InvoicesResponse();

		List<Invoice> invoicesList;
		DAOFactory factory = DAOFactory.getInstance("javabase.jdbc");
		InvoiceDAOJDBC invoicesJDBC = new InvoiceDAOJDBC(factory);
		invoicesList = invoicesJDBC.getShopInvoicesOfPerAddress(customerId,
				addressId);
		Gson gson = new Gson();
		response.setInvoices(invoicesList);
		String json = gson.toJson(response);
		return Response.status(200).entity(json).build();

	}

	// http://localhost/sysapi/v1.0/invoices/?customerId=1
	@GET
	@Path("/invoices/history")
	@Produces("application/json")
	public Response allCustomerInvoices(
			@QueryParam(value = "customerId") Long customerId) {
		InvoicesResponse response = new InvoicesResponse();
		List<Invoice> invoicesList;

		DAOFactory factory = DAOFactory.getInstance("javabase.jdbc");
		InvoiceDAOJDBC invoicesJDBC = new InvoiceDAOJDBC(factory);
		invoicesList = invoicesJDBC.getInvoicesOfCustomer(customerId);
		response.setInvoices(invoicesList);
		Gson gson = new Gson();

		String json = gson.toJson(response);
		return Response.status(200).entity(json).build();

	}
}
