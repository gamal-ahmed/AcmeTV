# AcmeTV
Acme is a cable TV company that bills his customers on a monthly basis. The invoices sent are connected to a customer's address. Customers
can have multiple addresses resulting in a monthly invoice per address.

## Technologies and Tools used in this project:
1. RESTEasy 2.2.1.GA
2. JDK 1.8
3. Maven 3.0.3
4. Apache Tomcat 6.0
5. junit 4.0
6. log4j 1.2.17
7. Eclipse 3.6

Note :project is well structred using design patterns , OOD , Clean codeing , well commented , documented and unit tested


<code>dao.factory.DAOFactory</code> This class represents a DAO factory for a SQL database. You can use <code>{@link #getInstance(String)}</code> to obtain a new instance for the given databasename.
<code>dao.InvoiceDAOJDBC</code> This class represents a concrete JDBC implementation of the
 <code> {@link InvoiceDAO}</code> interface
<code>webservice.Invoices</code> invoices restfull API to deal with the invoices system 

## Run
install and run the application just in few steps :

### install
1. download tomcat 6.0 Binary Distribution for your operating system from there :https://tomcat.apache.org/download-60.cgi
2. download the build Acme_tv.war AcmeTV/build
3. run database script located in AcmeTV/SQL/Script.sql
4. copy the war file "Acme_Tv.war" to apache-tomcat 6.0 directory\apache-tomcat-6.0.45\webapps 
5. run startup script in apache-tomcat 6.0 directory\apache-tomcat-6.0.45\bin


### run
1.
