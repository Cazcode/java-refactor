package com.example.refactor.mapper;

import com.example.refactor.model.Artist;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;

public class ArtistMapper implements Mapper<JSONObject, Artist>, JsonStringValueExtractor {

    public List<Artist> mapList(JSONObject trackJSON) {
        JSONArray artistsJSON = (JSONArray) trackJSON.get("artists");
        return artistsJSON.stream()
                .map( artist -> map((JSONObject) artist))
                .toList();
    }

    @Override
    public Artist map(JSONObject artistJSON) {
        Artist artist = new Artist();
        artist.setId(extractStringValue(artistJSON, "id"));
        artist.setName(extractStringValue(artistJSON, "name"));
        return artist;
    }

    @Override
    public String extractStringValue(JSONObject json, String key) {
        return json.get(key).toString();
    }
}
