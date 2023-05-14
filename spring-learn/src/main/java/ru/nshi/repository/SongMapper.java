package ru.nshi.repository;

import ru.nshi.error.ApiException;
import ru.nshi.model.Song;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

class SongMapper implements RowMapper<Song> {
    @Override
    public Song mapRow(ResultSet resultSet, int i) throws SQLException {
        Song song = new Song();
        song.setId(resultSet.getInt("id"));
        song.setName(resultSet.getString("name"));
        song.setIdArtist(resultSet.getInt("idArtist"));
        song.setArtistName(resultSet.getString("artistName"));
        song.setAuditions(resultSet.getInt("auditions"));
        return song;
    }
}
