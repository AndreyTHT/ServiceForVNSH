package org.example.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Repository;

import org.example.error.SongNotFoundException;
import org.example.model.Song;

@Repository
public class SongRepositoryImpl implements SongRepository {
    private Map<Integer, Song> songMap = new ConcurrentHashMap<>();
    private AtomicInteger autoId = new AtomicInteger(1);

    @Override
    public List<Song> findAll() {
        return new ArrayList<>(songMap.values());
    }


    //сделать код который будет выводить песни только данного артиста
    @Override
    public List<Song> findAllOfArtist(Integer idArtist) {
        return new ArrayList<>(songMap.values());
    }

    @Override
    public Song create(Song song) {
        song.setId(autoId.getAndIncrement());
        songMap.put(song.getId(), song);
        return song;
    }

    @Override
    public Song getById(Integer id) throws SongNotFoundException {
        var result = songMap.get(id);
        if (result == null) {
            throw new SongNotFoundException(
                    String.format("Song with id %d was not found", id)
            );
        }
        return result;
    }

    @Override
    public Song updateById(Integer id, Song song) throws SongNotFoundException {
        var oldSong = songMap.get(id);
        if (oldSong == null) {
            throw new SongNotFoundException(
                    String.format("Song with id %d was not found", id)
            );
        }
        song.setId(id);
        songMap.put(id, song);
        return song;
    }

    @Override
    public Song deleteById(Integer id) throws SongNotFoundException {
        var song = songMap.remove(id);
        if (song == null) {
            throw new SongNotFoundException(
                    String.format("Song with id %d was not found", id)
            );
        }
        return song;
    }
}