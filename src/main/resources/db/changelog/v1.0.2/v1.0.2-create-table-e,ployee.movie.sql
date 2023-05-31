-- liquibase formatted sql

-- changeSet Vladislav:1
create table employee_movie(
      employee_id int references employee(id) on delete cascade not null ,
      movie_id int references movie(id) on delete cascade not null,
      primary key(employee_id, movie_id)
);
-- rollback drop table employee_movie;