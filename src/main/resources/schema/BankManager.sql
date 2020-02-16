create database bankmanager;

use bankmanager;

create table CUSTOMER (
	CUSTOMER_ID int(11) auto_increment,
	EMAIL varchar(255) DEFAULT "",
	BALANCE_AMOUNT double DEFAULT 0.0,
    FIRST_NAME varchar(255) DEFAULT "",
    LAST_NAME varchar(255) DEFAULT "",
    ACCOUNT_NUMBER varchar(255),
	PRIMARY KEY(CUSTOMER_ID)
);

create table TRANSACTION (
	ID int(11) auto_increment,
	OPERATION varchar(255) DEFAULT "",
	AMOUNT double DEFAULT 0.0,
	CLOSING_BALANCE double DEFAULT 0.0,
    TRANSACTION_DATE date,
    ACCOUNT_NUMBER varchar(255),
	PRIMARY KEY(ID)
);

show tables;