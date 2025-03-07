package com.example.refactor.model;

import java.util.List;

public class Song extends BaseDomain{
    private String explicit;
    private String playable;
    private String popularity;
    private Album album;
    private List<SpotifyArtist> spotifyArtist;

    public String getExplicit() {
        return explicit;
    }

    public void setExplicit(String explicit) {
        this.explicit = explicit;
    }

    public String getPlayable() {
        return playable;
    }

    public void setPlayable(String playable) {
        this.playable = playable;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public List<SpotifyArtist> getSpotifyArtist() {
        return spotifyArtist;
    }

    public void setSpotifyArtist(List<SpotifyArtist> spotifyArtist) {
        this.spotifyArtist = spotifyArtist;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
