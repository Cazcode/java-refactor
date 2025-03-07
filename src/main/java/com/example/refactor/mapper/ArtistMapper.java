package com.example.refactor.mapper;

import com.example.refactor.model.SpotifyArtist;
import org.json.simple.JSONObject;

public class ArtistMapper implements Mapper<JSONObject, SpotifyArtist>{
    @Override
    public SpotifyArtist map(JSONObject artistJSON) {
        SpotifyArtist artist = new SpotifyArtist();
        artist.setId(artistJSON.get("id").toString());
        artist.setName(artistJSON.get("name").toString());
        return artist;
    }

}
