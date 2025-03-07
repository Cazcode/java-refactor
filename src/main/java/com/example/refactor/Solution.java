package com.example.refactor;

import com.example.refactor.service.*;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Solution {
    private static final Logger LOGGER = LoggerFactory.getLogger(Solution.class);
    public static void main(String... args) {
        MusicStreamingService service = new SpotifyService();
        final String playlistFileName = PropertyFactory.getProperties().getProperty("refactorpractice.playlist.filename");
        JSONObject playlist;
        try {
            playlist = ExampleFileUtils.getJsonFromFileName(playlistFileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        service.process(playlist)
                .stream()
                .forEach(song ->
                        LOGGER.info(" - {} - {} - {} - {}", song.getId(), song.getName(),
                                song.getSpotifyArtist().getName(), song.getAlbum().getName()));
    }
}
