# AcmeTV
Acme is a cable TV company that bills his customers on a monthly basis. The invoices sent are connected to a customer's address. Customers
can have multiple addresses resulting in a monthly invoice per address.

## Technologies and Tools used in this project:
1. RESTEasy 2.2.1.GA
2. JDK 1.8
3. Maven 3.0.3
4. Apache Tomcat 6.0
5. Eclipse 3.6

Note :project is well structred using design patterns , OOD , Clean codeing and well commented , documented


<code>dao.factory.DAOFactory</code> This class represents a DAO factory for a SQL database. You can use <code>{@link #getInstance(String)}</code> to obtain a new instance for the given databasename.
<code>dao.InvoiceDAOJDBC</code> This class represents a concrete JDBC implementation of the
 <code> {@link InvoiceDAO}</code> interface
<code>webservice.Invoices</code> invoices restfull API to deal with the invoices system 

## Run

Run Below commands to build the project
<pre>
        $ cd AcmeTV
        $ mvn package
</pre> 

