package com.example.refactor.controller;

import com.example.refactor.model.Song;
import com.example.refactor.service.factory.MusicStreamingService;
import com.example.refactor.service.factory.SERVICETYPE;
import com.example.refactor.service.factory.ServiceFactory;
import org.json.simple.JSONObject;

import java.util.List;

public class StreamingController {

    private ServiceFactory factory;

    public StreamingController(ServiceFactory factory) {
        this.factory = factory;
    }

    public List<Song> process(JSONObject playlist, SERVICETYPE servicetype) {
        MusicStreamingService service =  factory.createService(servicetype);
        return service.process(playlist);
    }

}
