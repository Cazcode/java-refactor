package com.example.refactor.controller;

import com.example.refactor.model.Song;
import com.example.refactor.service.factory.MusicStreamingService;
import com.example.refactor.service.factory.SERVICETYPE;
import com.example.refactor.service.factory.ServiceFactory;
import org.json.simple.JSONObject;

import java.util.List;

/**
 * Se implementa una clase controller para recibir las peticiones del cliente
 */
public class StreamingController {
//    Se implementa un factory de servicios
    private final ServiceFactory factory;

    public StreamingController(ServiceFactory factory) {
        this.factory = factory;
    }

    public List<Song> process(JSONObject playlist, SERVICETYPE servicetype) {
//        Al aplicar una fabrica es posible realizar un solo llamado y gracias al polimorfismo cada implementacion especifica tiene su comportamiento
//        y la clase controller no necesita saber como funciona solo realiza el respectivo llamado de process
        MusicStreamingService service =  factory.getMusicStreamingService(servicetype);
        return service.process(playlist);
    }

}
