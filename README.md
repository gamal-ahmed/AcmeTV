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
7. MYSQL (DBMS)
8. Eclipse 3.6

Note :project is well structred using design patterns , OOD , Clean codeing , well commented , documented and unit tested


<code>dao.factory.DAOFactory</code> This class represents a DAO factory for a SQL database. You can use <code>{@link #getInstance(String)}</code> to obtain a new instance for the given databasename.
<code>dao.InvoiceDAOJDBC</code> This class represents a concrete JDBC implementation of the
 <code> {@link InvoiceDAO}</code> interface
<code>webservice.Invoices</code> invoices restfull API to deal with the invoices system 

## Run
install and run the application just in few steps :

### install
1. clone or download the code 
2. run database script located in AcmeTV/SQL/Script.sql
3. update database properties in <code>dao.factory.DAOFactory @{getInstance()}</code> 
<pre>
	String url = "jdbc:mysql://localhost:3306/dbName";
		String driverClassName = "com.mysql.jdbc.Driver";
		String password = "";
		String username = "";
</pre>
4. run following commands 
<pre>
  $ cd AcmeTV
  $ mvn package
</pre>
5. download tomcat 6.0 Binary Distribution for your operating system from there :https://tomcat.apache.org/download-60.cgi
6. copy the war file "Acme_Tv.war" in the target folder to apache-tomcat 6.0 directory\apache-tomcat-6.0.45\webapps 
7. run startup script in apache-tomcat 6.0 directory\apache-tomcat-6.0.45\bin


### run
1. Invoices per month 
Request : http://localhost:8080/Acme_tv/sysapi/v1.0/invoices/?customerId=1&month=8
</br>
sample Response :
<pre>
{"invoices": [{
   "invoiceId": 2,
   "customerId": 1,
   "addressId": 8212155,
   "invoiceType": "ShopPurchase",
   "invoiceTypeLocalized": "q",
   "invoiceDate": "Feb 2, 2016",
   "invoiceNumber": 2,
   "startDate": "Aug 1, 2016",
   "paymentDueDate": "Mar 1, 2016",
   "endDate": "Aug 1, 2016",
   "periodDescription": "w",
   "vatAmount": 3,
   "amount": 2,
   "totalAmount": "4"
}]}
</pre>

2. Invoices per month 
Request : http://localhost:8080/Acme_tv/sysapi/v1.0/invoices/shop/?customerId=1&filter=shop&month=8
</br>
sample Response :
<pre>
{"invoices": [
      {
      "invoiceId": 2,
      "customerId": 1,
      "addressId": 8212155,
      "invoiceType": "ShopPurchase",
      "invoiceTypeLocalized": "q",
      "invoiceDate": "Feb 2, 2016",
      "invoiceNumber": 2,
      "startDate": "Aug 1, 2016",
      "paymentDueDate": "Mar 1, 2016",
      "endDate": "Aug 1, 2016",
      "periodDescription": "w",
      "vatAmount": 3,
      "amount": 2,
      "totalAmount": "4"
   },
      {
      "invoiceId": 19,
      "customerId": 1,
      "addressId": 8212156,
      "invoiceType": "ShopPurchase",
      "invoiceTypeLocalized": "q",
      "invoiceDate": "Feb 2, 2016",
      "invoiceNumber": 2,
      "startDate": "Aug 1, 2016",
      "paymentDueDate": "Mar 1, 2016",
      "endDate": "Aug 1, 2016",
      "periodDescription": "w",
      "vatAmount": 3,
      "amount": 2,
      "totalAmount": "4"
   }
]}
</pre>

3. Invoices per month 
Request : http://localhost:8080/Acme_tv/sysapi/v1.0/invoices/?customerId=1&month=8
</br>
sample Response :
<pre>
{"invoices": [{
   "invoiceId": 2,
   "customerId": 1,
   "addressId": 8212155,
   "invoiceType": "ShopPurchase",
   "invoiceTypeLocalized": "q",
   "invoiceDate": "Feb 2, 2016",
   "invoiceNumber": 2,
   "startDate": "Aug 1, 2016",
   "paymentDueDate": "Mar 1, 2016",
   "endDate": "Aug 1, 2016",
   "periodDescription": "w",
   "vatAmount": 3,
   "amount": 2,
   "totalAmount": "4"
}]}
</pre>


4. Invoices history per address
Request : http://localhost:8080/Acme_tv/sysapi/v1.0/invoices/address/?customerId=1&addressId=8212155
</br>
sample Response :
<pre>
{"invoices": [{
   "invoiceId": 2,
   "customerId": 1,
   "addressId": 8212155,
   "invoiceType": "ShopPurchase",
   "invoiceTypeLocalized": "q",
   "invoiceDate": "Feb 2, 2016",
   "invoiceNumber": 2,
   "startDate": "Aug 1, 2016",
   "paymentDueDate": "Mar 1, 2016",
   "endDate": "Aug 1, 2016",
   "periodDescription": "w",
   "vatAmount": 3,
   "amount": 2,
   "totalAmount": "4"
}]}
</pre>

5. Invoices history full
sample Request : http://localhost:8080/Acme_tv/sysapi/v1.0/invoices/history/?customerId=1
</br>
sample Response :
<pre>
{"invoices": [
      {
      "invoiceId": 2,
      "customerId": 1,
      "addressId": 8212155,
      "invoiceType": "ShopPurchase",
      "invoiceTypeLocalized": "q",
      "invoiceDate": "Feb 2, 2016",
      "invoiceNumber": 2,
      "startDate": "Aug 1, 2016",
      "paymentDueDate": "Mar 1, 2016",
      "endDate": "Aug 1, 2016",
      "periodDescription": "w",
      "vatAmount": 3,
      "amount": 2,
      "totalAmount": "4"
   },
      {
      "invoiceId": 19,
      "customerId": 1,
      "addressId": 8212156,
      "invoiceType": "ShopPurchase",
      "invoiceTypeLocalized": "q",
      "invoiceDate": "Feb 2, 2016",
      "invoiceNumber": 2,
      "startDate": "Aug 1, 2016",
      "paymentDueDate": "Mar 1, 2016",
      "endDate": "Aug 1, 2016",
      "periodDescription": "w",
      "vatAmount": 3,
      "amount": 2,
      "totalAmount": "4"
   }
]}
</pre>



#Code Documentaion 
AcmTV/doc
