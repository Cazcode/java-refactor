package com.example.refactor.mapper;

import com.example.refactor.model.Album;
import com.example.refactor.model.Song;
import com.example.refactor.model.SpotifyArtist;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SongMapper implements Mapper<JSONObject, Song>{

    Mapper<JSONObject, Album> albumMapper;
    Mapper<JSONObject, SpotifyArtist> artistMapper;

    public SongMapper(Mapper<JSONObject, Album> albumMapper, Mapper<JSONObject, SpotifyArtist> artistMapper) {
        this.albumMapper = albumMapper;
        this.artistMapper = artistMapper;
    }

    @Override
    public Song map(JSONObject trackJSON) {
        Song song = new Song();
        song.setExplicit(trackJSON.get("explicit").toString());
        song.setId(trackJSON.get("id").toString());
        song.setPlayable(trackJSON.get("is_playable").toString());
        song.setName(trackJSON.get("name").toString());
        song.setPopularity(trackJSON.get("popularity").toString());
        JSONObject albumJSON = (JSONObject) trackJSON.get("album");
        song.setAlbum(albumMapper.map(albumJSON));
        List<SpotifyArtist> spotifyArtists = new ArrayList<>();
        JSONArray artistsJSON = (JSONArray) trackJSON.get("artists");
        for (Object element : artistsJSON) {
            JSONObject artistJSON = (JSONObject) element;
            spotifyArtists.add(artistMapper.map(artistJSON));
        }
        song.setSpotifyArtist(spotifyArtists);
        return song;
    }


}
