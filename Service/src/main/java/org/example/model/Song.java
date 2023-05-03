package org.example.model;

public class Song {
    private Integer id;
    private String name;
    private String artistName;
    private Integer auditions;

    public Song(){}

    public Song(String name, String artistName, Integer auditions) {
        this.name = name;
        this.artistName = artistName;
        this.auditions = auditions;
    }

    public Song(Integer id, String name, String artistName, Integer auditions) {
        this.id = id;
        this.name = name;
        this.artistName = artistName;
        this.auditions = auditions;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getArtistName() {
        return artistName;
    }

    public Integer getAuditions() {
        return auditions;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public void setAuditions(Integer auditions) {
        this.auditions = auditions;
    }
}
