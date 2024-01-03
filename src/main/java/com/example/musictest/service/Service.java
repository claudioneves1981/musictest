package com.example.musictest.service;

import com.example.musictest.models.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.example.musictest.util.JsonReader.readJsonFromUrl;

public class Service {

    private static final String APIKEY = "660a4395f992ff67786584e238f501aa";

    public Consulta retornaConsulta(String art, String mus) throws JSONException, IOException {

        String URL = "https://api.vagalume.com.br/search.php?apikey="+APIKEY+"&art="+art+"&mus="+mus+"&extra=alb";

        //Aqui vc seta a url que contem o json
        JSONObject origem = readJsonFromUrl(URL);

        //Aqui vc digita a propriedade(chave) do qual vc deseja extrair o resultado
        JSONObject artista = origem.getJSONObject("art");
        JSONArray musica = origem.getJSONArray("mus");
        String name = artista.getString("name");
        JSONObject nomeMusica = musica.getJSONObject(0);
        String letraMusic = nomeMusica.getString("text");
        JSONObject album = nomeMusica.getJSONObject("alb");
        String nomeAlbum = album.getString("name");
        String yearAlbum = album.getString("year");

        Consulta consulta = new Consulta();
        Artista artist = new Artista();
        Musica music = new Musica();
        Album albumMusic = new Album();
        albumMusic.setName(nomeAlbum);
        albumMusic.setYear(yearAlbum);
        MusicaProperties musicaProperties = new MusicaProperties();
        List<MusicaProperties> listMusic = new ArrayList<>();
        musicaProperties.setAlb(albumMusic);
        musicaProperties.setText(letraMusic);
        listMusic.add(musicaProperties);
        music.setMusprop(listMusic);
        artist.setName(name);
        consulta.setArt(artist);
        consulta.setMus(music);
        return consulta;
    }


}
