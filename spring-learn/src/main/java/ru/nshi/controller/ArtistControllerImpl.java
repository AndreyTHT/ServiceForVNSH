package ru.nshi.controller;

import lombok.RequiredArgsConstructor;
import ru.nshi.model.Song;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.nshi.model.Artist;
import ru.nshi.repository.ArtistRepository;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class ArtistControllerImpl implements ArtistController {
    private final ArtistRepository repository;

    @Override
    public ResponseEntity<Optional<List<Artist>>> getAll() {
        try{
            return ResponseEntity.ok(repository.getAll());
        }catch(Exception ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @Override
    public ResponseEntity<Artist> getById(int id) {
        try{
            Optional<Artist> optionalSong = repository.getById(id);
            return optionalSong
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
        }catch(Exception ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @Override
    public ResponseEntity<List<Song>> getSongs(int id) {
        try {
            return ResponseEntity.ok(repository.getSongs(id));
        }catch(Exception ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    URI getArtistLocation(long id) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
    }
}
