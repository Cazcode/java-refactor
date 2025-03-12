package com.example.refactor.service.factory;

import com.example.refactor.model.Song;
import org.json.simple.JSONObject;

import java.util.Arrays;
import java.util.List;

public class DezzerService implements MusicStreamingService {
    @Override
    public List<Song> process(JSONObject playlist) {
        return Arrays.asList();
    }
}
