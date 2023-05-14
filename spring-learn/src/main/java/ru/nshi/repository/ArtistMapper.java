package ru.nshi.repository;

import liquibase.pro.packaged.A;
import ru.nshi.error.ApiException;
import ru.nshi.model.Artist;
import org.springframework.jdbc.core.RowMapper;
import ru.nshi.model.Song;

import java.sql.ResultSet;
import java.sql.SQLException;

class ArtistMapper implements RowMapper<Artist> {
    @Override
    public Artist mapRow(ResultSet resultSet, int i) throws SQLException {
        Artist artist = new Artist();
        artist.setId(resultSet.getInt("id"));
        artist.setName(resultSet.getString("name"));
        return artist;
    }
}
