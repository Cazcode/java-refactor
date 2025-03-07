package com.example.refactor;

import com.example.refactor.service.ExampleFileUtils;
import com.example.refactor.service.PropertyFactory;
import com.example.refactor.service.SongProcessor;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Solution {
    private static final Logger LOGGER = LoggerFactory.getLogger(Solution.class);
    public static void main(String... args) {
        SongProcessor songProcessor = new SongProcessor();
        final String playlistFileName = PropertyFactory.getProperties().getProperty("refactorpractice.playlist.filename");
        JSONObject playlist;
        try {
            playlist = ExampleFileUtils.getJsonFromFileName(playlistFileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        songProcessor.processSongs(playlist)
                .stream()
                .forEach(song ->
                        LOGGER.info(" - {} - {} - {} - {}", song.getId(), song.getName(),
                                song.getSpotifyArtist().getName(), song.getAlbumName()));
    }
}
