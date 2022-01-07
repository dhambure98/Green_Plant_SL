# //========================== Create PlantShop DATABASE ===========================================

DROP DATABASE IF EXISTS PlantShop;
CREATE DATABASE IF NOT EXISTS PlantShop;
SHOW DATABASES;
USE PlantShop;

# //========================== Create Customer Table ===============================================

DROP TABLE IF EXISTS Customer;
CREATE TABLE IF NOT EXISTS Customer(
    cId VARCHAR(10) NOT NULL ,
    cName VARCHAR(255) NOT NULL DEFAULT 'Unknown' ,
    cAddress TEXT ,
    NIC VARCHAR(20) NOT NULL ,
    cContact VARCHAR(20) NOT NULL,
    CONSTRAINT PRIMARY KEY (cId)
);
SHOW TABLES;
DESC Customer;

INSERT INTO Customer VALUES ('C-001','Nimal','Galle','9985422158V','0765521424');
INSERT INTO Customer VALUES ('C-002','Kamal','Colombo','9788542212V','0775521458');

# //========================== Create Delivery Table ===============================================

DROP TABLE IF EXISTS Delivery;
CREATE TABLE IF NOT EXISTS Delivery(
    dId VARCHAR(10) NOT NULL ,
    dDate DATE ,
    dTime VARCHAR(15) NOT NULL ,
    status VARCHAR(10),
    CONSTRAINT PRIMARY KEY (dId)
);
SHOW TABLES;
DESC Delivery;

INSERT INTO Delivery VALUES ('D-10010','2021.10.10','08.20','Conform');

# //========================== Create Order Table ===============================================

DROP TABLE IF EXISTS `Order`;
CREATE TABLE IF NOT EXISTS `Order`(
    orderId VARCHAR(10) NOT NULL,
    cId VARCHAR(10) NOT NULL,
    orderDate DATE,
    orderTime VARCHAR(10) NOT NULL,
    cost DOUBLE,
    CONSTRAINT PRIMARY KEY (orderId),
    CONSTRAINT FOREIGN KEY (cId) REFERENCES Customer (cId) ON DELETE CASCADE ON UPDATE CASCADE
);
SHOW TABLES;
DESC `Order`;

# //========================== Create Plant Table ===============================================

DROP TABLE IF EXISTS Plant;
CREATE TABLE IF NOT EXISTS Plant(
    plantId VARCHAR(10) NOT NULL ,
    plantName VARCHAR(225) NOT NULL DEFAULT 'Unknown' ,
    planType TEXT NOT NULL ,
    quantity INT NOT NULL ,
    plantCategory VARCHAR(45) NOT NULL ,
    description TEXT ,
    unitPrice DECIMAL(10,2) NOT NULL ,
    CONSTRAINT PRIMARY KEY (plantId)
);
SHOW TABLES;
DESC Plant;

INSERT INTO Plant VALUES ('P-101','Cactus','Indoor',10,'Palms','Planted from Seed',100.00);
INSERT INTO Plant VALUES ('P-102','Aloe Vera','Indoor',20,'Palms','Planted from Seed',270.00);
INSERT INTO Plant VALUES ('P-103','Miscanthus Dwarf','Indoor',8,'Palms','Planted from Seed',370.00);

# //========================== Create Customer_Order_Details Table ===============================

DROP TABLE IF EXISTS Customer_Order_Detail;
CREATE TABLE IF NOT EXISTS Customer_Order_Detail(
    oId VARCHAR(10) NOT NULL ,
    plantId VARCHAR(10) NOT NULL,
    quantity INT NOT NULL ,
    unitPrice DECIMAL(10,2) NOT NULL ,
    total_cost INT NOT NULL ,
    CONSTRAINT PRIMARY KEY (oId,plantId),
    CONSTRAINT FOREIGN KEY (oId) REFERENCES `Order` (oId) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FOREIGN KEY (plantId) REFERENCES Plant (plantId) ON DELETE CASCADE ON UPDATE CASCADE
);
SHOW TABLES;
DESC Customer_Order_Detail;

# //========================== Create Supplier Table ===========================================

DROP TABLE IF Exists Supplier;
CREATE TABLE IF NOT EXISTS Supplier(
    supId VARCHAR(10) NOT NULL ,
    supName VARCHAR(255) NOT NULL DEFAULT 'Unknown' ,
    supAddress TEXT ,
    companyName VARCHAR(100) NOT NULL ,
    supContact INT NOT NULL ,
    CONSTRAINT PRIMARY KEY (supId)
);
SHOW TABLES;
DESC Supplier;

INSERT INTO Supplier VALUES ('S-100','Mr. Rajarathran','Galle','Sathuta International Private Limited','0775428516');
INSERT INTO Supplier VALUES ('S-200','Mr. Kumara','Colombo','Alistair Steel SL','0765224851');

# //========================== Create Employee Table ===============================================

DROP TABLE IF EXISTS Employee;
CREATE TABLE IF NOT EXISTS Employee(
    empId VARCHAR(10) NOT NULL ,
    empName VARCHAR(255) NOT NULL DEFAULT 'Unknown' ,
    empAddress TEXT ,
    empContact VARCHAR(20) ,
    empType VARCHAR(20),
    salary DECIMAL(10,2) NOT NULL ,
    CONSTRAINT PRIMARY KEY (empId)
);

ALTER TABLE Employee
    ADD salary DECIMAL(10,2) NOT NULL ;

SHOW TABLES;
DESC Employee;

INSERT INTO Employee VALUES ('002','Cashier','Galle','+945524885','Cashier',20000.00);
INSERT INTO Employee VALUES ('003','Admin','Galle','+945524885','Admin',25000.00);


# //========================== Create Employee_Payment Table ===============================================

DROP TABLE IF EXISTS Employee_payment;
CREATE TABLE IF NOT EXISTS Employee_payment(
    paymentId VARCHAR(10) NOT NULL,
    empId VARCHAR(10) NOT NULL ,
    salary DECIMAL(10,2) NOT NULL ,
    date DATE ,
    paymentMethord VARCHAR(100) NOT NULL ,
    CONSTRAINT PRIMARY KEY (paymentId),
    CONSTRAINT FOREIGN KEY (empId) REFERENCES Employee (empId) ON DELETE CASCADE ON UPDATE CASCADE
);
SHOW TABLES;
DESC Employee_payment;

INSERT INTO Employee_payment VALUES ('Pay1100','002','20000.00','12.08.2021','Cash');

# //========================== Create User_Detail Table ======================================================

DROP TABLE IF EXISTS User_Detail;
CREATE TABLE IF NOT EXISTS User_Detail(
    uId VARCHAR(10) NOT NULL ,
    empId VARCHAR(10) NOT NULL ,
    uName VARCHAR(20) NOT NULL ,
    uPassword VARCHAR(20) NOT NULL ,
    type VARCHAR(20),
    CONSTRAINT PRIMARY KEY (uId),
    CONSTRAINT FOREIGN KEY (empId) REFERENCES Employee (empId) ON DELETE CASCADE ON UPDATE CASCADE
);
SHOW TABLES;
DESC User_Detail;

INSERT INTO User_Detail VALUES ('001','002','Cashier','1234','Cashier');
INSERT INTO User_Detail VALUES ('002','003','Admin','1234','Admin');


# //========================== Create Supply_Order Table ==================================================

DROP TABLE IF EXISTS Supply_Order;
CREATE TABLE IF NOT EXISTS Supply_Order(
    sup_order_Id VARCHAR(10) NOT NULL ,
    sup_order_Date DATE ,
    sup_order_Type VARCHAR(50) NOT NULL ,
    CONSTRAINT PRIMARY KEY (sup_order_Id)
);
SHOW TABLES;
DESC Supply_Order;

# //========================== Create Supplier_Order_Detail Table ======================================================

DROP TABLE IF EXISTS Supplier_Order_Detail;
CREATE TABLE IF NOT EXISTS Supplier_Order_Detail(
    supId VARCHAR(10),
    sup_order_Type VARCHAR(10),
    quantity INT NOT NULL ,
    placeDate DATE ,
    CONSTRAINT PRIMARY KEY (supId),
    CONSTRAINT FOREIGN KEY (sup_order_Type) REFERENCES Supply_Order (sup_order_Id) ON DELETE CASCADE ON UPDATE CASCADE ,
    CONSTRAINT FOREIGN KEY (supId) REFERENCES supplier (supId) ON DELETE CASCADE ON UPDATE CASCADE
);
SHOW TABLES;
DESC Supplier_Order_Detail;

# //========================== Create Reports Table ======================================================

DROP TABLE IF EXISTS Report;
CREATE TABLE IF NOT EXISTS Report(
    repId VARCHAR(10) NOT NULL ,
    description TEXT ,
    netProfit DECIMAL(15) NOT NULL ,
    date DATE,
    CONSTRAINT PRIMARY KEY (repId)
);
SHOW TABLES;
DESC Report;



DESC customer;
DESC customer_order_detail;
DESC delivery;
DESC employee;
DESC employee_payment;
DESC `order`;
DESC plant;
DESC report;
DESC supplier;
DESC supplier_order_detail;
DESC supply_order;
DESC user_detail;



