package com.example.refactor.model;

public class Song extends BaseDomain{
    private String explicit;
    private String playable;
    private String popularity;
    private Album album;

    public SpotifyArtist spotifyArtist;

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

    public SpotifyArtist getSpotifyArtist() {
        return spotifyArtist;
    }

    public void setSpotifyArtist(SpotifyArtist spotifyArtist) {
        this.spotifyArtist = spotifyArtist;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
