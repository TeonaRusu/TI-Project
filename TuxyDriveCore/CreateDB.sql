CREATE DATABASE TUXYDRIVE;
USE TUXYDRIVE;

CREATE TABLE users (
	UserID int not null auto_increment PRIMARY KEY,
	LastName varchar(10),
	FirstName varchar(10),
	Age int,
	Email varchar(20)
);
insert into users values(1,"nume1","prenume1",20,"nume1.prenume1@gmail.com");

CREATE TABLE user_login (
	UserID int not null,
	Username varchar(10),
	Password varchar(10),
	PRIMARY KEY(Username),
	FOREIGN KEY (UserID) REFERENCES users(UserID)
);

INSERT INTO user_login VALUES(1,'user1','pswd1');


CREATE TABLE files (
	FileID int not null auto_increment,
	UserID int,
	Name varchar(10),
	Type varchar(5),
	Size int,
	PRIMARY KEY(FileID),
	FOREIGN KEY (UserID) REFERENCES users(UserID)
);