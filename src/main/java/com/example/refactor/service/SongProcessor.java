package com.example.refactor.service;

import com.example.refactor.mapper.Mapper;
import com.example.refactor.model.Song;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SongProcessor {

    private final Mapper<JSONObject, Song> songMapper;

    public SongProcessor(Mapper<JSONObject, Song> songMapper) {
        this.songMapper = songMapper;
    }

    public List<Song> processSongs(JSONObject playlist) {
        final var items = (JSONArray) playlist.get("items");
//        Se usa var evitando redundancia en la especificacion de los tipos de los objetos
//        Se usa instancesof expresion y aplicar un filtro para los objetos
        return (List<Song>) items.stream()
                .filter(itemJson -> itemJson instanceof JSONObject item && item.containsKey("track"))
                .map( item -> {
                    var json = (JSONObject) item;
                    var track = (JSONObject) json.get("track");
                    return Objects.nonNull(track) ? songMapper.map(track) : null;
                })
                .collect(Collectors.toList());
    }

}
