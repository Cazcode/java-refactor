package com.example.refactor;

import com.example.refactor.controller.StreamingController;
import com.example.refactor.service.*;
import com.example.refactor.service.factory.SERVICETYPE;
import com.example.refactor.service.factory.ServiceFactory;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Se trata esta clase como la clase cliente
 */
public class Solution {
    private static final Logger LOGGER = LoggerFactory.getLogger(Solution.class);
    public static void main(String... args) {
        final String playlistFileName = PropertyFactory.getProperties().getProperty("refactorpractice.playlist.filename");
        try {
//            Se crean las instancias y se obtienen los objetos para ser enviados en los constructores que los soliciten
            JSONObject playlist = ExampleFileUtils.getJSONObjectFromFileName(playlistFileName);
            ServiceFactory serviceFactory = new ServiceFactory();
            StreamingController controller = new StreamingController(serviceFactory);
//           Se llama el meotdo principal del controller y se usa Stream Api de java 8 para realizar el print de los datos obtenidos
            controller.process(playlist, SERVICETYPE.SPOTIFY)
                    .stream()
                    .forEach(song ->
                            LOGGER.info(" - {} - {} - {} - {}", song.getId(), song.getName(),
                                    song.getArtist().get(0).getName(), song.getAlbum().getName()));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
