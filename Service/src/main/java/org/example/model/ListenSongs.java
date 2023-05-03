package org.example.model;

import java.util.List;

public class ListenSongs {
    private Integer auditions;
    private List<Integer> songs;

    public Integer getAuditions() {
        return auditions;
    }

    public List<Integer> getSongs() {
        return songs;
    }

    public void setAuditions(Integer auditions) {
        this.auditions = auditions;
    }

    public void setSongs(List<Integer> songs) {
        this.songs = songs;
    }
}
