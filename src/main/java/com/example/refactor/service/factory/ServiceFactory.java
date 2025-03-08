package com.example.refactor.service.factory;

/**
 * Se usa como la implementacion de la fabrica, esto permite realizar una instancia especifica a partir de un tipo de servicio
 */
public class ServiceFactory {

    public MusicStreamingService createService(SERVICETYPE servicetype) {
        if(SERVICETYPE.DEZZER.equals(servicetype)) {
            return new DezzerService();
        }
        return new SpotifyService();
    }
}
