package ru.nshi.repository;

import lombok.RequiredArgsConstructor;
import ru.nshi.controller.SongController;
import ru.nshi.model.Artist;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import ru.nshi.model.Song;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
public class SongRepository{
    private final JdbcTemplate template;


    public  Optional<List<Song >> getAll() {

        String query = "SELECT * " +
                "FROM " + Song .TABLE;
        return Optional.ofNullable( template.query(query, new SongMapper()));
    }


    public Optional<Song > getById(int id) {
        String query = "SELECT * " +
                "FROM " + Song .TABLE + " " +
                "WHERE " + Song .ID_COLUMN + " = ?";
        Song  Song  = template.queryForObject(query, new SongMapper(), id);
        return Optional.ofNullable(Song );
    }


    public Optional<Song > Create(SongController.CreateSong create) {
        System.out.println(create.getArtistName()+" "+ create.getName() + " "+ create.getAuditions());

            String sql = "SELECT id FROM `artist` WHERE `name` = '"+create.getArtistName()+"' ";

            Long idArt;
            Long idSong;
            try {
                idArt= template.queryForObject(sql, Long.class);
            } catch (Exception e) {
                sql = "INSERT INTO `artist`(`name`) VALUES('"+create.getArtistName()+"') ";
                template.update(sql);
                idArt = template.queryForObject("SELECT id FROM `artist` WHERE name = '"+create.getArtistName()+"'",Long.class);
            }
            String insertSong = "INSERT INTO `song` (`name`, `idArtist`,`artistName`, `auditions`) VALUES ('"+create.getName()+"',"+idArt+", '"+create.getArtistName()+"',  "+create.getAuditions()+");";
        System.out.println("start RETURN SONG1");
           template.update(insertSong);
        System.out.println("start RETURN SONG2");
            idSong = template.queryForObject("SELECT id FROM `song` WHERE `name` = '"+create.getName()+"'",Long.class);
        System.out.println("RETURN SONG");
           return Optional.ofNullable(new Song(idSong,create.getName(),create.getArtistName(),idArt,create.getAuditions()) ) ;

    }





    public boolean deleteById(int id) {
        String query = "DELETE FROM " + Song .TABLE + " " +
                "WHERE " + Song .ID_COLUMN + " = ?";
        int update = template.update(query, id);
        return update > 0;
    }




    public Optional<Song > Update(int id, SongController.CreateSong update) {
        System.out.println("UPDADTESTART");

        try {
           String sql = "UPDATE song SET name = '"+update.getName()+"', artistName = '"+update.getArtistName()+"', auditions = "+ update.getAuditions()+" WHERE id = "+id+" ";
            System.out.println(sql);
            template.update(sql);
            System.out.println("SELECT * FROM song WHERE id="+id+"");
            //var res = template.queryForObject("SELECT * FROM `song` WHERE `id`="+id+"", Song.class);
            //System.out.println(res.getName()+":::::::"+res.getArtistName());
            var idAtrist = template.queryForObject("SELECT IDARTIST FROM `song` WHERE `id` = '"+id+"'",Long.class);
            System.out.println("RETURN SONG");
            return Optional.ofNullable(new Song(id,update.getName(),update.getArtistName(),idAtrist,update.getAuditions()) ) ;


        }
        catch (Exception ex){

            System.out.println(ex.getMessage());
            return Optional.ofNullable(null);
        }

    }
    public  Optional<List<Song >> listenSongByIds(SongController.ListenSong listenSong) {
        var songs = listenSong.getSongs();
        var audCount = listenSong.getAuditions();
        String ids = "";
        try {
            for (int id : songs) {
                var count = template.queryForObject("SELECT auditions FROM song WHERE id = " + id + "", int.class);
                var k = count + audCount;
                template.update("UPDATE song SET auditions = " + k + " WHERE id = " + id + " ");
                ids += id+",";
            }
            ids = ids.substring(0, ids.length()-1);
            String query = "SELECT * FROM `song` WHERE id IN ("+ids+");";
            return Optional.ofNullable( template.query(query, new SongMapper()));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;

        }
    }

    public  Optional<Song> listenSongById(int id, SongController.ListenSongById listenSongById) {
        try{
        var count = template.queryForObject("SELECT auditions FROM song WHERE id = " + id + "", int.class);
        var k = count + listenSongById.getAuditions();
        template.update("UPDATE song SET auditions = " + k + " WHERE id = " + id + " ");
        String query = "SELECT * FROM `song` WHERE id = " + id;
        Song Song = template.queryForObject(query, new SongMapper());
        return Optional.ofNullable(Song);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public Optional<List<Song >>  getSortedSongsByAuditions(int count) {
        try {
            String query = "SELECT * FROM song ORDER BY auditions LIMIT "+count+";";
            return Optional.ofNullable(template.query(query, new SongMapper()));
        } catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
