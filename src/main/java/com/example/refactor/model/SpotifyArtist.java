package com.example.refactor.model;

import java.util.LinkedList;

public class SpotifyArtist extends BaseDomain{

    private LinkedList<SpotifyArtist> genres = new LinkedList<>();

    public LinkedList<?> getGenres() {
        return genres;
    }

    public void setGenres(LinkedList<SpotifyArtist> genres) {
        this.genres = genres;
    }
}