CREATE database AUTOSWAP;

USE autoswap;




Create Table customers(CustomerId int AUTO_INCREMENT PRIMARY KEY,firstName varchar(30),lastName varchar(30),
userName varchar(30),password varchar(20) NOT NULL, isBuyer boolean, passwordVal varchar(255),
profileLink varchar(8000));

INSERT INTO customers (firstName,lastName,userName,password,isBuyer,passwordVal,profileLink) VALUES 
("Ubaid","Mansuri","ubaid.code01@gmail.com","helloWorld",false,MD5('Abc123'),
"https://firebasestorage.googleapis.com/v0/b/autoswap-since-2003.appspot.com/o/User%20ProfilePhotos%2FuserProfileUrl1.jpeg?alt=media&token=1b57b0e5-0d5d-4dbc-9537-c9e6dff606b2" );
INSERT INTO customers (firstName,lastName,userName,password,isBuyer,passwordVal,profileLink) VALUES 
("Rahul","Murari","rahul123@gmail.com","rahul123",true,MD5('Xyz987'),
"https://firebasestorage.googleapis.com/v0/b/autoswap-since-2003.appspot.com/o/User%20ProfilePhotos%2FuserProfileUrl1.jpeg?alt=media&token=1b57b0e5-0d5d-4dbc-9537-c9e6dff606b2");
INSERT INTO customers (firstName,lastName,userName,password,isBuyer,passwordVal,profileLink) VALUES 
("Moses","John","moses123@gmail.com","moses123",true,MD5('Mnp456'),
"https://firebasestorage.googleapis.com/v0/b/autoswap-since-2003.appspot.com/o/User%20ProfilePhotos%2FuserProfileUrl1.jpeg?alt=media&token=1b57b0e5-0d5d-4dbc-9537-c9e6dff606b2");
INSERT INTO customers (firstName,lastName,userName,password,isBuyer,passwordVal,profileLink) VALUES 
("Kavya","Sri Panuganti","kavya123@gmail.com","kavya123",false,MD5('Hij345'),
"https://firebasestorage.googleapis.com/v0/b/autoswap-since-2003.appspot.com/o/User%20ProfilePhotos%2FuserProfileUrl1.jpeg?alt=media&token=1b57b0e5-0d5d-4dbc-9537-c9e6dff606b2");


CREATE TABLE CARS(carId int AUTO_INCREMENT PRIMARY KEY, company varchar(30) NOT NULL, 
modelName varchar(30) NOT NULL, year int NOT NULL, price decimal(10,2) NOT NULL, 
color varchar(30), isAvailable boolean);

INSERT INTO CARS (company, modelName, year, price, color, isAvailable) 
values ("Honda", "Civic 1.8", 2020, 30000.22, "Black", true);
INSERT INTO CARS (company, modelName, year, price, color, isAvailable) 
values ("Toyota", "Corolla 1.8", 2015, 15000.22, "Black", true);
INSERT INTO CARS (company, modelName, year, price, color, isAvailable) 
values ("Mazda", "CX3 1.8", 2020, 40000.22, "Black", false);
INSERT INTO CARS (company, modelName, year, price, color, isAvailable) 
values ("Honda", "CX 5", 2020, 50000.22, "Red", false);


CREATE TABLE MEDIA(mediaId int AUTO_INCREMENT PRIMARY KEY, videoLink varchar(8000), imageLink varchar(8000),
carId int not null,
    CONSTRAINT fk_carId
    FOREIGN KEY (carId) 
        REFERENCES CARS(carId));
        
INSERT INTO MEDIA (videoLink, imageLink, carId) 
values ("https://firebasestorage.googleapis.com/v0/b/autoswap-since-2003.appspot.com/o/Car%20Videos%2FcarVideo3.mp4?alt=media&token=54264f7e-e936-4845-bf01-7f339c64482d",
"https://firebasestorage.googleapis.com/v0/b/autoswap-since-2003.appspot.com/o/Car%20Photos%2FcarPhoto5.jpeg?alt=media&token=fd080891-cabb-4abd-8702-3ce29a4decb7",1);
INSERT INTO MEDIA (videoLink, imageLink, carId) 
values ("","https://firebasestorage.googleapis.com/v0/b/autoswap-since-2003.appspot.com/o/Car%20Photos%2FcarPhoto6.jpeg?alt=media&token=7bc2829b-e581-40ca-b1c9-a71c5566fff4",1);
INSERT INTO MEDIA (videoLink, imageLink, carId) 
values ("https://firebasestorage.googleapis.com/v0/b/autoswap-since-2003.appspot.com/o/Car%20Videos%2FcarVideo2.mp4?alt=media&token=48c3562d-5b64-45cc-983f-364439044cb8",
"https://firebasestorage.googleapis.com/v0/b/autoswap-since-2003.appspot.com/o/Car%20Photos%2FcarPhoto6.jpeg?alt=media&token=7bc2829b-e581-40ca-b1c9-a71c5566fff4",2);
INSERT INTO MEDIA (videoLink, imageLink, carId) 
values ("","https://firebasestorage.googleapis.com/v0/b/autoswap-since-2003.appspot.com/o/Car%20Photos%2FcarPhoto7.jpeg?alt=media&token=ca92c246-cddd-4d95-91e0-d8264e8367ac",3);
INSERT INTO MEDIA (videoLink, imageLink, carId) 
values ("https://firebasestorage.googleapis.com/v0/b/autoswap-since-2003.appspot.com/o/Car%20Videos%2FcarVideo1.mp4?alt=media&token=6feb617b-de37-46a5-9765-e1d39cc5c183",
"https://firebasestorage.googleapis.com/v0/b/autoswap-since-2003.appspot.com/o/Car%20Photos%2FcarPhoto7.jpeg?alt=media&token=ca92c246-cddd-4d95-91e0-d8264e8367ac",3);




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



select * from customers;
select * from cars;
select * from CARHOLDERS;

