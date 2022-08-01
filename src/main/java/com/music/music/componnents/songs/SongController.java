package com.music.music.componnents.songs;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("Songs")
public class SongController {

    @Autowired
    private SongServiceInterface service;
    @GetMapping("")
    public List<SongModel> getAllSongs() {
        return service.getAllSongs();
    }
    @GetMapping("/{id}")
    public Optional<SongModel> getSongsById(@PathVariable("id") String  id) {
        return service.getSongsById(id);
    }
    @GetMapping("/specificArtistSongs/{artist}")
    public List<SongModel> specificArtistSongs(@PathVariable String  artist) {
        return service.specificArtistSongs(artist);
    }
    @PostMapping("")
    public SongModel saveSong(@RequestBody SongModel song){
        return service.saveSong(song);

    }
    @PutMapping("/{id}")
    public SongModel updateSong(@RequestBody SongModel song, @PathVariable("id") String id){
        return  service.updateSong(song,id);
    }
    @DeleteMapping("/{id}")
    public String delete( @PathVariable("id") String id){
        return  service.delete(id);
    }




}
