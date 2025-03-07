package com.example.refactor.service;

import com.example.refactor.model.Song;
import com.example.refactor.model.SpotifyArtist;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SongProcessor {

    public List<Song> processSongs(JSONObject playlist) {

        final JSONArray items = (JSONArray) playlist.get("items");

        List<JSONObject> collect = new ArrayList<>(items);

        return collect.stream()
                .filter(i ->  i.containsKey("track"))
                .map(item -> {
                    JSONObject trackJSON = (JSONObject) item.get("track");
                    JSONArray artistsJSON = (JSONArray) trackJSON.get("artists");
                    JSONObject albumJSON = (JSONObject) trackJSON.get("album");

                    Song song = new Song();
                    song.setExplicit(trackJSON.get("explicit").toString());
                    song.setId(trackJSON.get("id").toString());
                    song.setPlayable(trackJSON.get("is_playable").toString());
                    song.setName(trackJSON.get("name").toString());
                    song.setPopularity(trackJSON.get("popularity").toString());
                    song.setAlbumType(albumJSON.get("album_type").toString());
                    song.setAlbumId(albumJSON.get("id").toString());
                    song.setAlbumName(albumJSON.get("name").toString());
                    song.setAlbumReleaseDate(albumJSON.get("release_date").toString());
                    song.setAlbumTotalTracks(albumJSON.get("total_tracks").toString());

                    for (Object element : artistsJSON) {
                        JSONObject artistJSON = (JSONObject) element;

                        SpotifyArtist artist = new SpotifyArtist();
                        artist.setId(artistJSON.get("id").toString());
                        artist.setName(artistJSON.get("name").toString());
                        song.setSpotifyArtist(artist);
                    }
                    return song;
                })
                .collect(Collectors.toList());
    }

}
