-- liquibase formatted sql

-- changeSet Vladislav:8
create table feedback(
    id int generated by default as identity primary key,
    person_id int references person(id) not null,
    movie_id int references movie(id) not null,
    text varchar
);
-- rollback drop table feedback;