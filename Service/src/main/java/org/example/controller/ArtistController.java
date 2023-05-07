package org.example.controller;

import org.example.error.ArtistValidationException;
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
    ){
        return service.getById(id);
    }

    //Сделать так чтобы писались все песни заданного автора(пока что выводяться просто все песни)
    @GetMapping("/{id}/songs")
    public List<Song> getSongs(@PathVariable Integer id) {
        return serviceSong.getSongsByArtistId(id);
    }

    @ExceptionHandler(ArtistValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleNotFoundException(ArtistValidationException ex) {
        return new ErrorResponse(ex.getMessage());
    }

    private void validateArtist(Artist artist) throws ArtistValidationException {
        if (artist == null) {
            throw new ArtistValidationException(
                    "Artist can not be null"
            );
        }

        if (artist.getName() == null || artist.getName().trim().isEmpty()) {
            throw new ArtistValidationException(
                    "Artist name can not be empty"
            );
        }
    }
}
