package com.example.musictest.models;

import lombok.Data;

@Data
public class MusicaProperties {

    private String id;
    private String name;
    private String url;
    private String text;
    private Integer lang;
    private Album alb;
}
