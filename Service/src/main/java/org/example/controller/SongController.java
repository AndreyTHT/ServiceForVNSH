package org.example.controller;

import java.util.List;

import org.example.error.SongNotFoundException;
import org.example.error.SongValidationException;
import org.example.model.CreateSong;
import org.example.model.ErrorResponse;
import org.example.model.Song;
import org.example.service.SongService;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

    @RestController
    @RequestMapping(
            path = "/songs",
            produces = MimeTypeUtils.APPLICATION_JSON_VALUE
    )
    public class SongController {
        @Autowired
        private SongService service;

        @GetMapping
        public List<Song> getSongs() {
            return service.getSongs();
        }

        @PostMapping
        public Song createSong(
                @RequestBody CreateSong createSong
        ) throws SongValidationException {
            var song = new Song(
                    createSong.getName(),
                    createSong.getArtistName(),
                    createSong.getAuditions(),
                    createSong.getIdArtist()
            );
            validateSong(song);
            return service.create(song);
        }

        @GetMapping("/{id}")
        public Song getSongById(
                @PathVariable Integer id
        ) throws SongNotFoundException {
            return service.getById(id);
        }

        @PutMapping("/{id}")
        public Song updateSongById(
                @PathVariable Integer id,
                @RequestBody CreateSong updateSong
        ) throws SongValidationException, SongNotFoundException {
            var song = new Song(
                    updateSong.getName(),
                    updateSong.getArtistName(),
                    updateSong.getAuditions(),
                    updateSong.getIdArtist()
            );
            validateSong(song);
            return service.updateById(id, song);
        }

        @DeleteMapping("/{id}")
        public Song deleteSongById(
                @PathVariable Integer id
        ) throws SongNotFoundException {
            return service.deleteById(id);
        }

        @ExceptionHandler(SongNotFoundException.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
        public ErrorResponse handleNotFoundException(SongNotFoundException ex) {
            return new ErrorResponse(ex.getMessage());
        }

        @ExceptionHandler(SongValidationException.class)
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        public ErrorResponse handleNotFoundException(SongValidationException ex) {
            return new ErrorResponse(ex.getMessage());
        }

        private void validateSong(Song song) throws SongValidationException {
            if (song == null) {
                throw new SongValidationException(
                        "Song can not be null"
                );
            }

            if (song.getName() == null || song.getName().trim().isEmpty()) {
                throw new SongValidationException(
                        "Song name can not be empty"
                );
            }

            if (song.getArtistName() == null || song.getArtistName().trim().isEmpty()) {
                throw new SongValidationException(
                        "Song artist name can not be empty"
                );
            }

            if (song.getAuditions() == null || song.getAuditions() < 0) {
                throw new SongValidationException(
                        "Song auditions can not be negative or null"
                );
            }
        }
    }

