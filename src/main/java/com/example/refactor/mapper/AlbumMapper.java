package com.example.refactor.mapper;

import com.example.refactor.model.Album;
import org.json.simple.JSONObject;

public class AlbumMapper implements Mapper<JSONObject, Album>, JsonStringValueExtractor{
    @Override
    public Album map(JSONObject albumJSON) {
        return new  Album.AlbumBuilder()
                .setType(extractStringValue(albumJSON, "album_type"))
                .setId(extractStringValue(albumJSON, "id"))
                .setName(extractStringValue(albumJSON, "name"))
                .setReleaseDate(extractStringValue(albumJSON, "release_date"))
                .setTotalTracks(extractStringValue(albumJSON, "total_tracks")).build();
    }

    @Override
    public String extractStringValue(JSONObject json, String key) {
        return json.get(key).toString();
    }
}
