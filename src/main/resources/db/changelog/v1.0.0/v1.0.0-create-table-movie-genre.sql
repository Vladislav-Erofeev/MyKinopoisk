-- liquibase formatted sql

-- changeSet Vladislav:6
create table movie_genre(
    movie_id int references movie(id) on delete cascade not null ,
    genre_id int references genre(id) on delete cascade not null ,
    primary key(movie_id, genre_id)
);
-- rollback drop table movie_genre;