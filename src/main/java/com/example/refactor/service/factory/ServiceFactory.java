package com.example.refactor.service.factory;

/**
 * Se usa como la implementacion de la fabrica, esto permite realizar una instancia especifica a partir de un tipo de servicio
 */
public class ServiceFactory {

    public MusicStreamingService getMusicStreamingService(SERVICETYPE servicetype) {
//        Se implementa switch expression, mejorando la lectura del codigo
        return switch (servicetype) {
            case DEZZER -> new DezzerService();
            default -> new SpotifyService();
        };
    }
}
