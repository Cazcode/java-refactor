package com.example.refactor.mapper.factory;

import com.example.refactor.mapper.AlbumMapper;
import com.example.refactor.mapper.ArtistMapper;
import com.example.refactor.mapper.Mapper;
import com.example.refactor.mapper.SongMapper;

public class MapperFactory {

    public static Mapper getMapper(MAPPERTYPE type) {
        if(MAPPERTYPE.SONG.equals(type)) {
            return new SongMapper(new AlbumMapper(), new ArtistMapper());
        }
        if(MAPPERTYPE.ALBUM.equals(type)) {
            return new AlbumMapper();
        }
        return new ArtistMapper();
    }

}
