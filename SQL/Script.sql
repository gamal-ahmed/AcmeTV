create database invoices_system;

CREATE TABLE invoices_system.`invoice` (
  `invoiceId` int(11) NOT NULL AUTO_INCREMENT,
  `customerId` int(11) DEFAULT NULL,
  `addressId` int(11) DEFAULT NULL,
  `invoiceType` varchar(255) DEFAULT NULL,
  `invoiceTypeLocalized` varchar(255) DEFAULT NULL,
  `invoiceDate` datetime DEFAULT NULL,
  `paymentDueDate` datetime DEFAULT NULL,
  `invoiceNumber` varchar(500) DEFAULT NULL,
  `startDate` datetime DEFAULT NULL,
  `endDate` datetime DEFAULT NULL,
  `periodDescription` varchar(500) DEFAULT NULL,
  `amount` varchar(500) DEFAULT NULL,
  `vatAmount` varchar(500) DEFAULT NULL,
  `totalAmount` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`invoiceId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


INSERT INTO `invoice`(`customerId`,`addressId`,`invoiceType`,`invoiceTypeLocalized`,`invoiceDate`,`paymentDueDate`,`invoiceNumber`,`startDate`,`endDate`,`periodDescription`,`amount`,`vatAmount`,`totalAmount`) VALUES (2,8212154,'AdvancePayment','Voorschot','2016-02-02 00:00:00','2016-03-01 00:00:00','1','2016-08-01 01:00:00','2016-08-01 00:00:00','invoices_systema','32','432','423423');
INSERT INTO `invoice`(`customerId`,`addressId`,`invoiceType`,`invoiceTypeLocalized`,`invoiceDate`,`paymentDueDate`,`invoiceNumber`,`startDate`,`endDate`,`periodDescription`,`amount`,`vatAmount`,`totalAmount`) VALUES (1,8212155,'ShopPurchase','q','2016-02-02 00:00:00','2016-03-01 00:00:00','2','2016-08-01 01:00:00','2016-08-01 00:00:00','w','2','3','4');


CREATE TABLE invoices_system.`customer` (
  `customerId` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`customerId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


INSERT INTO `customer`(`email`,`name`) VALUES ('a','w');
