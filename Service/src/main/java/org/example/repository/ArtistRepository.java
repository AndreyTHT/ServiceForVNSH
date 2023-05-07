package org.example.repository;

import org.example.model.Artist;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ArtistRepository {
    Artist artist = new Artist();
    private AtomicInteger autoId = new AtomicInteger(1);
    private Map<Integer, Artist> artistMap = new ConcurrentHashMap<>();

    public List<Artist> findAll() {
        return new ArrayList<>(artistMap.values());
    }
    public Artist getById(Integer id){
        var result = artistMap.get(id);
        if (result == null) {
            artist.setId(autoId.getAndIncrement());
            artistMap.put(artist.getId(), artist);
            return artist;
        }
        return result;
    }
}
