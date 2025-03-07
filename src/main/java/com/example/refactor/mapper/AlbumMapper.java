package com.example.refactor.mapper;

import com.example.refactor.model.Album;
import org.json.simple.JSONObject;

public class AlbumMapper implements Mapper<JSONObject, Album>{
    @Override
    public Album map(JSONObject albumJSON) {
        Album album = new Album();
        album.setId(albumJSON.get("album_type").toString());
        album.setId(albumJSON.get("id").toString());
        album.setName(albumJSON.get("name").toString());
        album.setReleaseDate(albumJSON.get("release_date").toString());
        album.setTotalTracks(albumJSON.get("total_tracks").toString());
        return album;
    }

}
