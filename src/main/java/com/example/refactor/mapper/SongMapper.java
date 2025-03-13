package com.example.refactor.mapper;

import com.example.refactor.model.Song;
import org.json.simple.JSONObject;

/**
 * Gracias a que en este caso el objeto Song contiene como atributos los objetos album y artist
 * Se usan los mappers respectivos y se agregan las instancias usando la inyección de dependencias
 */
public class SongMapper implements Mapper<JSONObject, Song>, JsonStringValueExtractor {

    AlbumMapper albumMapper;
    ArtistMapper artistMapper;

    public SongMapper(AlbumMapper albumMapper, ArtistMapper artistMapper) {
        this.albumMapper = albumMapper;
        this.artistMapper = artistMapper;
    }

    @Override
    public Song map(JSONObject trackJSON) {
        JSONObject albumJSON = (JSONObject) trackJSON.get("album");
        return new Song.SongBuilder()
                .setExplicit(extractStringValue(trackJSON, "explicit"))
                .setId(extractStringValue(trackJSON, "id"))
                .setPlayable(extractStringValue(trackJSON, "is_playable"))
                .setName(extractStringValue(trackJSON, "name"))
                .setPopularity(extractStringValue(trackJSON, "popularity"))
                .setAlbum(albumMapper.map(albumJSON))
                .setArtist(artistMapper.mapList(trackJSON))
                .build();
    }


    @Override
    public String extractStringValue(JSONObject json, String key) {
        return json.get(key).toString();
    }
}
