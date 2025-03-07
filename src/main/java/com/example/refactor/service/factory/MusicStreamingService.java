package com.example.refactor.service.factory;

import com.example.refactor.model.Song;
import org.json.simple.JSONObject;

import java.util.List;

public interface MusicStreamingService {
    List<Song> process(JSONObject playlist);
}
