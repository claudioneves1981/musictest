package com.example.musictest.models;

import lombok.Data;

import java.util.List;

@Data
public class Musica {

    private List<MusicaProperties> musprop;
    private boolean badwords = false;

}
