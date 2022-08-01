package com.music.music.componnents.songs;

import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.bson.types.ObjectId;

import java.util.Objects;

enum genreEnum {ROCK, POP, RAP, CLASSICAL}
//@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor

@Document(collection = "songs")

public class SongModel {

    // private int id;
    @Id
    private String id;
    private String title;
    private String artist;
    private genreEnum genre;
    private int length;
    private float price;

}

