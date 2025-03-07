package com.example.refactor.service;

import com.example.refactor.model.Song;
import org.json.simple.JSONObject;

import java.util.List;

public class SpotifyService implements MusicStreamingService {
    @Override
    public List<Song> process(JSONObject playlist) {
        SongProcessor processor = new SongProcessor();
        return processor.processSongs(playlist);
    }
}
