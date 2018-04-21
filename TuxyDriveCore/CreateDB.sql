CREATE DATABASE TUXYDRIVE_DB;
USE TUXYDRIVE_DB;

CREATE TABLE user_login (
	id int not null auto_increment,
	username varchar(10),
	password varchar(10)
);

INSERT INTO user_login VALUES(1,'user1','pswd1');
INSERT INTO user_login VALUES(1,'user2','pswd2');


