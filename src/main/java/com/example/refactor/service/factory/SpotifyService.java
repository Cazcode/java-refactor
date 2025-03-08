package com.example.refactor.service.factory;

import com.example.refactor.mapper.AlbumMapper;
import com.example.refactor.mapper.ArtistMapper;
import com.example.refactor.mapper.Mapper;
import com.example.refactor.mapper.SongMapper;
import com.example.refactor.mapper.factory.MAPPERTYPE;
import com.example.refactor.mapper.factory.MapperFactory;
import com.example.refactor.model.Album;
import com.example.refactor.model.Song;
import com.example.refactor.model.SpotifyArtist;
import com.example.refactor.service.SongProcessor;
import org.json.simple.JSONObject;

import java.util.List;

/**
 * Implementacion especifica para el servicio de Spotify
 */
public class SpotifyService implements MusicStreamingService {

    //    Sobre escritura del metodo process, definiendo un comportamiento unico para este tipo de servicio
    @Override
    public List<Song> process(JSONObject playlist) {
        /**
         * Creacion de instancias específicas de las clases mappers para hacer uso de las inyeccion de dependencias
         */
        Mapper<JSONObject, Song> songMapper = MapperFactory.getMapper(MAPPERTYPE.SONG);
        SongProcessor processor = new SongProcessor(songMapper);
        return processor.processSongs(playlist);
    }
}
