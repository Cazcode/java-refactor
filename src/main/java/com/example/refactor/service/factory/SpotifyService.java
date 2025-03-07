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

import java.util.List;

public class SpotifyService implements MusicStreamingService {
    @Override
    public List<Song> process(JSONObject playlist) {
        Mapper<JSONObject, Album> albumMapper = new AlbumMapper();
        Mapper<JSONObject, SpotifyArtist> artistMapper = new ArtistMapper();
        Mapper<JSONObject, Song> songMapper = new SongMapper(albumMapper, artistMapper);
        SongProcessor processor = new SongProcessor(songMapper);
        return processor.processSongs(playlist);
    }
}
