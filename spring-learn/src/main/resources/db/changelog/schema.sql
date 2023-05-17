CREATE TABLE IF NOT EXISTS artist (
    id int PRIMARY KEY AUTO_INCREMENT,
    name varchar(63) UNIQUE
);

CREATE TABLE IF NOT EXISTS song (
    id int  PRIMARY KEY AUTO_INCREMENT,
    name varchar(63) UNIQUE,
    idArtist int,
    artistName varchar(63),
    auditions int
);

