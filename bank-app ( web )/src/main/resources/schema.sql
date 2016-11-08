


CREATE SCHEMA IF NOT EXISTS MTS;

create table MTS.ACCOUNTS(
num varchar(10) primary key,
name varchar(50),
balance double,
staus varchar(10),
type varchar(10)
);