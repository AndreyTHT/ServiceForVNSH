package ru.nshi.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.nshi.model.Song;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RequestMapping("/songs")
public interface SongController {
    String MAPPING = "/songs ";

    /**
     * curl 'localhost:8080/Song ?size=0&page=3'
     *
     * @return
     */
    @GetMapping
    ResponseEntity<Optional<List<Song>>> getAll();

    /**
     * curl 'localhost:8080/Song /1'
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    ResponseEntity<Song> getById(@PathVariable int id);

    /**
     * curl localhost:8080/Song  -X POST -H "Content-Type: application/json" -d '{"name": "Sergey 1"}' -v
     * @param create
     * @return
     */
    @PostMapping
    ResponseEntity<?> create(@RequestBody CreateSong  create);

    /**
     * curl localhost:8080/Song /2 -X PATCH -v -H 'Content-Type: application/json' -d '{"avatar": "http://imgur.com/er12"}'
     * @param id
     * @param update
     * @return
     */
    @PutMapping("/{id}")
    ResponseEntity<?> update(@PathVariable int id, @RequestBody CreateSong  update);



    /**
     * curl 'localhost:8080/Song /1' -X DELETE
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteById(@PathVariable int id);

    @PostMapping("/listen")
    ResponseEntity<?> listenSongByIds(@RequestBody ListenSong  listenSong);

    @PostMapping("/{id}/listen")
    ResponseEntity<?> listenSongById(@PathVariable int id, @RequestBody ListenSongById listenSongbyId);

    @GetMapping("/listen")
    ResponseEntity<?> getSortedSongsByAuditions(@RequestParam(defaultValue = "5") int count);

    @AllArgsConstructor
    @RequiredArgsConstructor
    @Data
    class CreateSong  {
        private String name;
        private  String artistName;
        private int auditions;

    }
    @AllArgsConstructor
    @RequiredArgsConstructor
    @Data
    class ListenSong  {
        private int auditions;

        private List<Integer> songs;
    }
    @AllArgsConstructor
    @RequiredArgsConstructor
    @Data
    class ListenSongById  {
        private int auditions;

    }
}
