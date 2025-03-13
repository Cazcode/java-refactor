package com.example.refactor.mapper.factory;

import com.example.refactor.mapper.AlbumMapper;
import com.example.refactor.mapper.ArtistMapper;
import com.example.refactor.mapper.Mapper;
import com.example.refactor.mapper.SongMapper;

public class MapperFactory {

    public static Mapper getMapper(MAPPERTYPE type) {
//        Se implementa switch expression, mejorando la lectura del codigo
        return switch (type) {
            case MAPPERTYPE.SONG -> new SongMapper(new AlbumMapper(), new ArtistMapper());
            case ALBUM -> new AlbumMapper();
            default -> new ArtistMapper();
        };
    }

}
