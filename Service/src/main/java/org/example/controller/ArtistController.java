package org.example.controller;

import org.example.error.ArtistNotFoundException;
import org.example.model.Artist;
import org.example.model.ErrorResponse;
import org.example.model.Song;
import org.example.service.ArtistService;
import org.example.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping(
            path = "/artists",
            produces = MimeTypeUtils.APPLICATION_JSON_VALUE
    )
    public class ArtistController {
        @Autowired
        private ArtistService service;
        @Autowired
        private SongService serviceSong;

        //Нужен лист авторов
        @GetMapping
        public List<Artist> getArtists() {
            return service.getArtists();
        }

        @GetMapping("/{id}")
        public Artist getArtistById(
                @PathVariable Integer id
        ) throws ArtistNotFoundException {
            return service.getById(id);
        }

        @ExceptionHandler(ArtistNotFoundException.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
        public ErrorResponse handleNotFoundException(ArtistNotFoundException ex) {
            return new ErrorResponse(ex.getMessage());
        }
        //Сделать так чтобы писались все песни заданного автора(пока что выводяться просто все песни)
        @GetMapping("/{id}/songs")
        public List<Song> getSongs(@PathVariable Integer id) {
            return serviceSong.getSongsByArtistId(id);
        }

    }
