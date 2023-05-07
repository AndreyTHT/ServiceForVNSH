package org.example.repository;

import org.example.error.ArtistNotFoundException;
import org.example.error.SongNotFoundException;
import org.example.model.Artist;
import org.example.model.Song;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class ArtistRepository {
    Artist artist = new Artist();
    private AtomicInteger autoId = new AtomicInteger(1);
    private Map<Integer, Artist> artistMap = new ConcurrentHashMap<>();

    public List<Artist> findAll() {
        return new ArrayList<>(artistMap.values());
    }

    public Artist getById(Integer id) throws ArtistNotFoundException {
        var result = artistMap.get(id);
        if (result == null) {
            throw new ArtistNotFoundException(
                    String.format("Artist with id %d was not found", id)
            );
        }
        return result;
    }
}
