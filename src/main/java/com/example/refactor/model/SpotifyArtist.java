package com.example.refactor.model;

import java.util.LinkedList;

/**
 * En esta primera parte no es necesario realizar cambios grandes en esta clase, como el cambio de tipo de listas o aplicar YAGNI para el atributo genres
 */
public class SpotifyArtist extends BaseDomain{

    private LinkedList<SpotifyArtist> genres = new LinkedList<>();

    public LinkedList<?> getGenres() {
        return genres;
    }

    public void setGenres(LinkedList<SpotifyArtist> genres) {
        this.genres = genres;
    }
}