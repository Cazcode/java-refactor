package com.example.refactor.service;

import com.example.refactor.mapper.Mapper;
import com.example.refactor.model.Song;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SongProcessor {

    private Mapper<JSONObject, Song> songMapper;

    public SongProcessor(Mapper<JSONObject, Song> songMapper) {
        this.songMapper = songMapper;
    }

    public List<Song> processSongs(JSONObject playlist) {
        final JSONArray items = (JSONArray) playlist.get("items");
        List<JSONObject> collect = new ArrayList<>(items);
        return collect.stream()
                .filter(i ->  i.containsKey("track"))
                .map(item -> {
                    JSONObject trackJSON = (JSONObject) item.get("track");
                    return songMapper.map(trackJSON);
                })
                .collect(Collectors.toList());
    }

}
