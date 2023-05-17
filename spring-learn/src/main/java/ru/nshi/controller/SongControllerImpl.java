package ru.nshi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import ru.nshi.model.Song;
import ru.nshi.repository.SongRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@RestController
public class SongControllerImpl implements  SongController{

    private final SongRepository repository;
    @Override
    public ResponseEntity<Optional<List<Song>>> getAll() {
        try{
            return ResponseEntity.ok(repository.getAll());
        }catch(Exception ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @Override
    public ResponseEntity<Song> getById(int id) {
        try{
        Optional<Song> optionalSong = repository.getById(id);
        return optionalSong
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
        }catch(Exception ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @Override
    public ResponseEntity<Optional<Song>> create(CreateSong create) {

        try {
            Optional<Song> optionalSong = repository.Create(create);
            return ResponseEntity.ok(optionalSong);

        }catch(Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @Override
    public ResponseEntity<Optional<Song>> update(int id, CreateSong update) {
        try {
            Optional<Song> optionalSong = repository.Update(id,update);
            return ResponseEntity.ok(optionalSong);

        }catch(Exception ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }


    @Override
    public ResponseEntity<?> deleteById(int id) {
        try {
            return ResponseEntity.ok(repository.deleteById(id));
        }catch(Exception ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @Override
    public ResponseEntity<Optional<List<Song>>> listenSongByIds(ListenSong listenSong) {
        try{
            return ResponseEntity.ok(repository.listenSongByIds(listenSong));
        }catch(Exception ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
    @Override
    public ResponseEntity<Optional<Song>> listenSongById(int id, ListenSongById listenSongById) {
        try{
            return ResponseEntity.ok(repository.listenSongById(id, listenSongById));
        }catch(Exception ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
    @Override
    public ResponseEntity<Optional<List<Song>>> getSortedSongsByAuditions(int count) {
        try{
            return ResponseEntity.ok(repository.getSortedSongsByAuditions(count));
        }catch(Exception ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
