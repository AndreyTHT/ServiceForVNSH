package ru.nshi.repository;

import liquibase.pro.packaged.A;
import lombok.RequiredArgsConstructor;
import ru.nshi.model.Artist;
import ru.nshi.model.Song;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class ArtistRepository{
    private final JdbcTemplate template;

    public  Optional<List<Artist >> getAll() {

        String query = "SELECT * " +
            "FROM " + Artist.TABLE;
        return Optional.ofNullable( template.query(query, new ArtistMapper()));
    }

    public Optional<Artist > getById(int id) {
        String query = "SELECT * " +
            "FROM " + Artist .TABLE + " " +
            "WHERE " + Artist .ID_COLUMN + " = ?";
        Artist  artist  = template.queryForObject(query, new ArtistMapper(), id);
        return Optional.ofNullable(artist );
    }

    public List<Song> getSongs(int id) {

        String query = "SELECT * " +
                "FROM " + Song .TABLE + " WHERE idArtist = "+id;
        try {
            var songs = template.query(query, new SongMapper());
            return songs;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }
}
