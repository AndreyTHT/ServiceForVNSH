package ru.nshi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class Song {
    public static final String TABLE = "song";
    public static final String ID_COLUMN = "id";
    public static final String NAME_COLUMN = "name";
    public static final String ID_ARTIST = "idArtist";
    public static final String ARTIST_NAME = "artistName";

    public static final String AUDITIONS = "auditions";
    private long id;
    private String name;
    private String artistName;
    private long idArtist;
    private int auditions;
}
