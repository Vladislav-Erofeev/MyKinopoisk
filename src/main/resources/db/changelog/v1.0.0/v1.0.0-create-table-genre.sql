-- liquibase formatted sql

-- changeSet Vladislav:5
create table genre(
    id int generated by default as identity primary key,
    name varchar not null
);
-- rollback drop table genre;