package ru.nshi.controller;

import ru.nshi.model.Song;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nshi.model.Artist;

import java.util.List;
import java.util.Optional;

@RequestMapping("/artists")
public interface ArtistController {
    String MAPPING = "/artists";

    @GetMapping
    ResponseEntity<Optional<List<Artist>>> getAll();

    /**
     * curl 'localhost:8080/author/1'
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    ResponseEntity<Artist> getById(@PathVariable int id);

    @GetMapping("/{id}/songs")
    ResponseEntity<List<Song>> getSongs(@PathVariable int id);

    // ещё добавить метод для /artists/{id}/songs

}
