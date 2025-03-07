package com.example.refactor.service.factory;

public class ServiceFactory {

    public MusicStreamingService createService(SERVICETYPE servicetype) {
        if(SERVICETYPE.DEZZER.equals(servicetype)) {
            return new DezzerService();
        }
        return new SpotifyService();
    }
}
