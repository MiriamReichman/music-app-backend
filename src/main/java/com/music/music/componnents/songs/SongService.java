package com.music.music.componnents.songs;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;
@CrossOrigin
@Service
@AllArgsConstructor
public class SongService implements SongServiceInterface {

    @Autowired
    private final SongsRepository repo ;
    @Override
    public List<SongModel> getAllSongs(){
        return repo.findAll();
    }

    @Override
    public SongModel saveSong(SongModel song) {

    return repo.save(song);
    }
    @Override
    public SongModel updateSong(SongModel song, String id) {
        return repo.findById(id)
                .map(songModel -> {
                    songModel.setTitle(song.getTitle());
                    songModel.setArtist(song.getArtist());
                    songModel.setGenre(song.getGenre());
                    songModel.setLength(song.getLength());
                    songModel.setPrice(song.getPrice());
                    return repo.save(songModel);
                })
                .orElseGet(() -> {
                    song.setId(id);
                    return repo.save(song);
                });
    }
    @Override
    public List<SongModel> specificArtistSongs(String artist) {
        return  repo.findAllByArtist(artist);

    }
    @Override
    public Optional<SongModel> getSongsById(String id) {

        return repo.findById(id)
                //.orElseThrow(() -> new Exception("id not found"));
                ;

    }
    @Override
    public String delete(String id)  {

        try{
            repo.deleteById(id);
            return "deleted document";
        }
        catch (Exception e){
            return e.getMessage();
        }

    }
//    ●	Add song.orElseThrow(() -> new OrderNotFoundException(id));
//●	Update song
//●	Get all songs
//●	Get all songs of a specific artist
//●	Get specific song by id
//●	Delete song by id

}
