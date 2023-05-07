CREATE TABLE IF NOT EXISTS artist (
    id int PRIMARY KEY AUTO_INCREMENT,
    name varchar(63) UNIQUE,
);



CREATE TABLE IF NOT EXISTS song (
    id int PRIMARY KEY AUTO_INCREMENT,
    name varchar(63) UNIQUE,
    idArtist int PRIMARY KEY AUTO_INCREMENT,
    artistName varchar(63),
    id int auditions,
);

--Нужно будет поставить ALTER TABLE чтобы связать эти две таблицы(ну или поробовать связать их в самом коде)
--что-то типа такого наверное

--ALTER TABLE song ADD CONSTRAINT fk_song_artist_id
--FOREIGN KEY (idArtist)
--REFERENCES artist (id);
