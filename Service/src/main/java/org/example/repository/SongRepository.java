package org.example.repository;

import java.util.List;

import org.example.error.SongNotFoundException;
import org.example.model.Song;

public interface SongRepository {
    List<Song> findAll();

    Song create(Song song);

    Song getById(Integer id) throws SongNotFoundException;

    Song updateById(Integer id, Song song) throws SongNotFoundException;

    Song deleteById(Integer id) throws SongNotFoundException;
}

