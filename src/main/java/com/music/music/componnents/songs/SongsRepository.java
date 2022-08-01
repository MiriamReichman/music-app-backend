package com.music.music.componnents.songs;
import com.music.music.componnents.songs.SongModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SongsRepository extends MongoRepository<SongModel, String> {
   public  List<SongModel> findAllByArtist(String artist);
}
