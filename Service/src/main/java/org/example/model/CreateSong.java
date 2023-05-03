package org.example.model;
public class CreateSong {
    private String name;
    private String artistName;
    private Integer auditions;

    public String getName() {
        return name;
    }

    public Integer getAuditions() {
        return auditions;
    }

    public String getArtistName() {
        return artistName;
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
