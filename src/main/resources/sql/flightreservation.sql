CREATE DATABASE RESERVATION;

use RESERVATION;

CREATE TABLE user
(
ID INT NOT NULL AUTO_INCREMENT,
FIRST_NAME VARCHAR(20),
LAST_NAME VARCHAR(20),
EMAIL VARCHAR(20),
PASSWORD VARCHAR(20),
PRIMARY KEY (ID),
UNIQUE KEY (EMAIL)
);

CREATE TABLE flight
(
ID INT NOT NULL AUTO_INCREMENT,
FLIGHT_NUMBER VARCHAR(20) NOT NULL,
OPERATING_AIRLINES VARCHAR(20) NOT NULL,
DEPARTURE_CITY VARCHAR(20) NOT NULL,
ARRIVAL_CITY VARCHAR(20) NOT NULL,
DATE_OF_DEPARTURE DATE NOT NULL,
EESTIMATED_DEPARTURE_TIME TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY (ID)
);

CREATE TABLE passenger
(
ID INT NOT NULL AUTO_INCREMENT,
FIRST_NAME VARCHAR(256),
LAST_NAME VARCHAR(256),
MIDDLE_NAME VARCHAR(256),
EMAIL VARCHAR(50),
PHONE VARCHAR(10),
PRIMARY KEY (ID)
);

CREATE TABLE reservation(
ID INT NOT NULL AUTO_INCREMENT,
CHECKED_IN TINYINT(1),
NUMBER_OF_BAGS INT,
PASSENGER_ID INT,
FLIGHT_ID INT,
CREATED TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY (ID),
FOREIGN KEY (PASSENGER_ID) REFERENCES passenger(ID) ON DELETE CASCADE,
FOREIGN KEY (FLIGHT_ID) REFERENCES flight(ID)
);

CREATE TABLE role(
ID INT NOT NULL AUTO_INCREMENT,
NAME VARCHAR(20),
PRIMARY KEY (ID)
);

CREATE TABLE user_role(
user_id int,
role_id int,
FOREIGN KEY (user_id) REFERENCES user(id),
FOREIGN KEY (role_id) REFERENCES role(id)
);

insert into role values(1,'ADMIN');
insert into role values(2,'USER');
insert into user_role values(2,2);

select * from user_role;
select * from role;



SELECT * FROM user;

SELECT * FROM passenger;

SELECT * FROM flight;

SELECT * FROM reservation;

insert into flight values(1,'AA1','American Airlines','AUS','NYC',STR_TO_DATE('02-05-2018','%m-%d-%Y'),'2018-02-05 03:14:07');
insert into flight values(2,'AA2','American Airlines','AUS','NYC',STR_TO_DATE('02-05-2018','%m-%d-%Y'),'2018-02-05 05:14:07');

insert into flight values(3,'AA3','American Airlines','AUS','NYC',STR_TO_DATE('02-05-2018','%m-%d-%Y'),'2018-02-05 06:14:07');
insert into flight values(4,'AA4','American Airlines','AUS','NYC',STR_TO_DATE('02-05-2018','%m-%d-%Y'),'2018-02-05 07:14:07');

insert into flight values(5,'VA5','Virgin Airlines','NYC','BOS',STR_TO_DATE('02-07-2018','%m-%d-%Y'),'2018-02-07 01:14:05');
insert into flight values(6,'VA6','Virgin Airlines','BOS','NYC',STR_TO_DATE('02-09-2018','%m-%d-%Y'),'2018-02-09 09:14:00');

insert into flight values(7,'VA7','Virgin Airlines','NYC','BOS',STR_TO_DATE('02-09-2018','%m-%d-%Y'),'2018-02-09 01:34:05');
insert into flight values(8,'VA8','Virgin Airlines','BOS','NYC',STR_TO_DATE('02-10-2018','%m-%d-%Y'),'2018-02-11 09:24:30');

delete from reservation where id=2;
delete from passenger where id=2;

-- DROP TABLE user;
-- DROP TABLE passenger;
-- DROP TABLE flight;
-- DROP TABLE reservation;
-- DROP DATABASE RESERVATION;

