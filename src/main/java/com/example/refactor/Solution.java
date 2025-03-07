package com.example.refactor;

import com.example.refactor.controller.StreamingController;
import com.example.refactor.service.*;
import com.example.refactor.service.factory.SERVICETYPE;
import com.example.refactor.service.factory.ServiceFactory;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Solution {
    private static final Logger LOGGER = LoggerFactory.getLogger(Solution.class);
    public static void main(String... args) {
        ServiceFactory serviceFactory = new ServiceFactory();
        StreamingController controller = new StreamingController(serviceFactory);

        final String playlistFileName = PropertyFactory.getProperties().getProperty("refactorpractice.playlist.filename");
        JSONObject playlist;
        try {
            playlist = ExampleFileUtils.getJsonFromFileName(playlistFileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        controller.process(playlist, SERVICETYPE.SPOTIFY)
                .stream()
                .forEach(song ->
                        LOGGER.info(" - {} - {} - {} - {}", song.getId(), song.getName(),
                                song.getSpotifyArtist().get(0).getName(), song.getAlbum().getName()));
    }
}
