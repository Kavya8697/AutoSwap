CREATE database AUTOSWAP;

USE autoswap;



Create Table customer(customer_id int AUTO_INCREMENT PRIMARY KEY,first_name varchar(30),last_name varchar(30),
user_name varchar(30), is_buyer boolean, password_val varchar(255) NOT NULL,
profile_link varchar(8000));

INSERT INTO customer(first_name,last_name,user_name,is_buyer,password_val,profile_link) VALUES 
("Ubaid","Mansuri","ubaid.code01@gmail.com",false,MD5('Abc123'),
"https://firebasestorage.googleapis.com/v0/b/autoswap-since-2003.appspot.com/o/User%20ProfilePhotos%2FuserProfileUrl1.jpeg?alt=media&token=1b57b0e5-0d5d-4dbc-9537-c9e6dff606b2" );
INSERT INTO customer(first_name,last_name,user_name,is_buyer,password_val,profile_link) VALUES 
("Rahul","Murari","rahul123@gmail.com",true,MD5('Xyz987'),
"https://firebasestorage.googleapis.com/v0/b/autoswap-since-2003.appspot.com/o/User%20ProfilePhotos%2FuserProfileUrl1.jpeg?alt=media&token=1b57b0e5-0d5d-4dbc-9537-c9e6dff606b2");
INSERT INTO customer (first_name,last_name,user_name,is_buyer,password_val,profile_link) VALUES 
("Moses","John","moses123@gmail.com",true,MD5('Mnp456'),
"https://firebasestorage.googleapis.com/v0/b/autoswap-since-2003.appspot.com/o/User%20ProfilePhotos%2FuserProfileUrl1.jpeg?alt=media&token=1b57b0e5-0d5d-4dbc-9537-c9e6dff606b2");
INSERT INTO customer (first_name,last_name,user_name,is_buyer,password_val,profile_link) VALUES 
("Kavya","Sri Panuganti","kavya123@gmail.com",false,MD5('Hij345'),
"https://firebasestorage.googleapis.com/v0/b/autoswap-since-2003.appspot.com/o/User%20ProfilePhotos%2FuserProfileUrl1.jpeg?alt=media&token=1b57b0e5-0d5d-4dbc-9537-c9e6dff606b2");


CREATE TABLE CAR(car_id int AUTO_INCREMENT PRIMARY KEY, company varchar(30) NOT NULL, 
model_name varchar(30) NOT NULL, year int NOT NULL, price decimal(10,2) NOT NULL, 
color varchar(30), is_available boolean, customer_id int,   CONSTRAINT fk_customerId
    FOREIGN KEY (customer_id) 
        REFERENCES customer(customer_id));



INSERT INTO CAR (company, model_name, year, price, color, is_available,customer_id) 
values ("Honda", "Civic 1.8", 2020, 30000.22, "Black", true, 1);
INSERT INTO CAR (company, model_name, year, price, color, is_available,customer_id) 
values ("Toyota", "Corolla 1.8", 2015, 15000.22, "Black", true,1);
INSERT INTO CAR (company, model_name, year, price, color, is_available,customer_id)
values ("Mazda", "CX3 1.8", 2020, 40000.22, "Black", false,4);
INSERT INTO CAR (company, model_name, year, price, color, is_available,customer_id) 
values ("Honda", "CX 5", 2020, 50000.22, "Red", false,4);


CREATE TABLE MEDIA(media_id int AUTO_INCREMENT PRIMARY KEY, video_link varchar(8000), image_link varchar(8000),
car_id int not null,
    CONSTRAINT fk_carId
    FOREIGN KEY (car_id) 
        REFERENCES CAR(car_id));
        
INSERT INTO MEDIA (video_link, image_link, car_id) 
values ("https://firebasestorage.googleapis.com/v0/b/autoswap-since-2003.appspot.com/o/Car%20Videos%2FcarVideo3.mp4?alt=media&token=54264f7e-e936-4845-bf01-7f339c64482d",
"https://firebasestorage.googleapis.com/v0/b/autoswap-since-2003.appspot.com/o/Car%20Photos%2FcarPhoto5.jpeg?alt=media&token=fd080891-cabb-4abd-8702-3ce29a4decb7",1);
INSERT INTO MEDIA (video_link, image_link, car_id)  
values ("","https://firebasestorage.googleapis.com/v0/b/autoswap-since-2003.appspot.com/o/Car%20Photos%2FcarPhoto6.jpeg?alt=media&token=7bc2829b-e581-40ca-b1c9-a71c5566fff4",1);
INSERT INTO MEDIA (video_link, image_link, car_id)  
values ("https://firebasestorage.googleapis.com/v0/b/autoswap-since-2003.appspot.com/o/Car%20Videos%2FcarVideo2.mp4?alt=media&token=48c3562d-5b64-45cc-983f-364439044cb8",
"https://firebasestorage.googleapis.com/v0/b/autoswap-since-2003.appspot.com/o/Car%20Photos%2FcarPhoto6.jpeg?alt=media&token=7bc2829b-e581-40ca-b1c9-a71c5566fff4",2);
INSERT INTO MEDIA (video_link, image_link, car_id)  
values ("","https://firebasestorage.googleapis.com/v0/b/autoswap-since-2003.appspot.com/o/Car%20Photos%2FcarPhoto7.jpeg?alt=media&token=ca92c246-cddd-4d95-91e0-d8264e8367ac",3);
INSERT INTO MEDIA (video_link, image_link, car_id) 
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



drop table media;
drop table car;
drop table customer;


select * from customer;
select * from car;
select * from media;
