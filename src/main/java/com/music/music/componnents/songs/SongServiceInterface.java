package com.music.music.componnents.songs;

import java.util.List;
import java.util.Optional;

public interface SongServiceInterface {
    List<SongModel> getAllSongs();
     SongModel saveSong(SongModel song);
     SongModel updateSong(SongModel song, String id);
    List<SongModel> specificArtistSongs(String artist);
    Optional<SongModel> getSongsById(String id);
  String delete(String id);
}
