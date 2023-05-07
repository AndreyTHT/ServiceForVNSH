package org.example.model;

// Надо будет сделать связь с базой данных и чтоб различал create и update
// (Скорее всего буду ориентироваться на принимаемые значения)
public class CreateSong {
    private String name;
    private String artistName;
    private Integer auditions;
    private Integer IdArtist;

    public Integer getIdArtist() {
        return IdArtist;
    }

    public void setIdArtist(Integer idArtist) {
        IdArtist = idArtist;
    }
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
