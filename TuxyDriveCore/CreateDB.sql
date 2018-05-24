CREATE DATABASE TUXYDRIVE;
USE TUXYDRIVE;

CREATE TABLE users (
	UserID int not null auto_increment PRIMARY KEY,
	LastName varchar(10),
	FirstName varchar(10),
	Age int,
	Email varchar(20) UNIQUE
);
insert into users values(1,"Popescu","Ion",20,"popescu.ion@gmail.com");
insert into users values(2,"Prost","Paul",20,"prost.paul@gmail.com");
insert into users values(3,"Machidan","Marius",20,"boss.baiatbun@gmail.com");

CREATE TABLE user_login (
	UserID int not null,
	Username varchar(10),
	Password varchar(10),
	PRIMARY KEY(Username),
	FOREIGN KEY (UserID) REFERENCES users(UserID)
);

INSERT INTO user_login VALUES(1,'user1','pswd1');
INSERT INTO user_login VALUES(2,'marcel','marcel');
INSERT INTO user_login VALUES(3,'marius','destept');


CREATE TABLE files (
	FileID int not null auto_increment,
	UserID int,
	Name varchar(10) UNIQUE,
	Type varchar(5),
	Size double,
	PRIMARY KEY(FileID),
	FOREIGN KEY (UserID) REFERENCES users(UserID)
);
INSERT INTO files VALUES (1,2,'documentatie','.doc',23);
INSERT INTO files VALUES (2,2,'PozaCuMine','.jpg',2);
INSERT INTO files VALUES (3,1,'Notite','.txt',12);
INSERT INTO files VALUES (4,1,'mySong','.mp3',32);