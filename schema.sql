drop database if exists acme_bank;

create database acme_bank;

use acme_bank;

create table accounts (
    account_id varchar(255) not null,
    name varchar(255) not null,
    balance decimal(10,2) not null,
    constraint pkey_accounts_accountId primary key(account_id)
);

insert into accounts (account_id, name, balance) values ('V9L3Jd1BBI', 'fred', 100);
insert into accounts (account_id, name, balance) values ('fhRq46Y6vB', 'barney', 300);
insert into accounts (account_id, name, balance) values ('uFSFRqUpJy', 'wilma', 1000);
insert into accounts (account_id, name, balance) values ('ckTV56axff', 'betty', 1000);
insert into accounts (account_id, name, balance) values ('Qgcnwbshbh', 'pebbles', 50);
insert into accounts (account_id, name, balance) values ('if9l185l18', 'bambam', 50);



