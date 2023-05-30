-- liquibase formatted sql

-- changeSet Vladislav:1
create table movie(
    id int generated by default as identity primary key,
    name varchar(100) not null ,
    country varchar(100) not null ,
    budget int not null ,
    fees int not null ,
    views int,
    short_description varchar not null ,
    full_description varchar not null
);
-- rollback drop table movie;