package com.example.refactor.service.factory;

import com.example.refactor.mapper.AlbumMapper;
import com.example.refactor.mapper.ArtistMapper;
import com.example.refactor.mapper.Mapper;
import com.example.refactor.mapper.SongMapper;
import com.example.refactor.model.Album;
import com.example.refactor.model.Song;
import com.example.refactor.model.SpotifyArtist;
import com.example.refactor.service.SongProcessor;
import org.json.simple.JSONObject;

import java.util.Arrays;
import java.util.List;

public class DezzerService implements MusicStreamingService {
    @Override
    public List<Song> process(JSONObject playlist) {
        return Arrays.asList();
    }
}
