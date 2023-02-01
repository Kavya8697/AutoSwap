CREATE database AUTOSWAP;

USE autoswap;

Create Table customers(CustomerId int AUTO_INCREMENT PRIMARY KEY,firstName varchar(30),lastName varchar(30),
userName varchar(30),password varchar(20) NOT NULL, isBuyer boolean);
INSERT INTO customers (firstName,lastName,userName,password,isBuyer) VALUES ("Ubaid","Mansuri","ubaid.code01@gmail.com","helloWorld",false);
INSERT INTO customers (firstName,lastName,userName,password,isBuyer) VALUES 
("Rahul","Murari","rahul123@gmail.com","rahul123",true);
INSERT INTO customers (firstName,lastName,userName,password,isBuyer) VALUES 
("Moses","John","moses123@gmail.com","moses123",0);
INSERT INTO customers (firstName,lastName,userName,password,isBuyer) VALUES 
("Kavya","Sri Panuganti","kavya123@gmail.com","kavya123",1);


CREATE TABLE CARS(carId int AUTO_INCREMENT PRIMARY KEY, company varchar(30) NOT NULL, 
modelName varchar(30) NOT NULL, year int NOT NULL, price decimal(10,2) NOT NULL, 
color varchar(30), isAvailable boolean);

INSERT INTO CARS (company, modelName, year, price, color, isAvailable) 
values ("Honda", "Civic 1.8", 2020, 30000.22, "Black", true);
INSERT INTO CARS (company, modelName, year, price, color, isAvailable) 
values ("Toyota", "Corolla 1.8", 2015, 15000.22, "Blue", true);
INSERT INTO CARS (company, modelName, year, price, color, isAvailable) 
values ("Mazda", "CX3 1.8", 2020, 40000.22, "Black", false);
INSERT INTO CARS (company, modelName, year, price, color, isAvailable) 
values ("Honda", "CX 5", 2020, 50000.22, "Res", false);

create table CARHOLDERS(
	    customerId INT NOT NULL,
    carId INT NOT NULL,
    PRIMARY KEY (customerId, carId),
    CONSTRAINT `Constr_CarHolders_Customer_fk`
        FOREIGN KEY `Customer_fk` (`customerId`) REFERENCES `Customers` (`customerId`)
        ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `Constr_CarHolders_Car_fk`
        FOREIGN KEY `Car_fk` (`carId`) REFERENCES `Cars` (`carId`)
        ON DELETE CASCADE ON UPDATE CASCADE
);


INSERT INTO CARHOLDERS(customerId, carId) values (1,1);
INSERT INTO CARHOLDERS(customerId, carId) values (1,2);
INSERT INTO CARHOLDERS(customerId, carId) values (2,3);
INSERT INTO CARHOLDERS(customerId, carId) values (1,3);
INSERT INTO CARHOLDERS(customerId, carId) values (3,1);
INSERT INTO CARHOLDERS(customerId, carId) values (4,4);