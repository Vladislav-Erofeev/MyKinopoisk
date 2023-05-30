-- liquibase formatted sql

-- changeSet Vladislav:1
create table liked_movie(
    person_id int references person(id) on delete cascade not null ,
    movie_id int references movie(id) on delete cascade not null,
    primary key(person_id, movie_id)
);
-- rollback drop table liked_movie;