package org.example.service;

import java.util.List;

import org.example.error.ArtistNotFoundException;
import org.example.model.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.example.repository.ArtistRepository;

@Service
public class ArtistService {
    @Autowired
    private ArtistRepository repo;

    public List<Artist> getArtists() {
        return repo.findAll();
    }

    public Artist getById(Integer id) throws ArtistNotFoundException {
        return repo.getById(id);
    }
}