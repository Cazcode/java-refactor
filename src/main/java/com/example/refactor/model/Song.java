package com.example.refactor.model;

import java.util.List;

public class Song extends BaseDomain{
    private String explicit;
    private String playable;
    private String popularity;
//    Se realiza la abstraccion de los datos y se crea una nueva clase
    private Album album;
    //Se aplica el correcto encapsulamiento para este atributo y se usa un List, debido a que en el input de los datos se identifica que posee un listado o arreglo de este objeto
    private List<Artist> artist;

    public Song(SongBuilder builder) {
        super(builder.id, builder.name);
        this.explicit = builder.explicit;
        this.playable = builder.playable;
        this.popularity = builder.popularity;
        this.album = builder.album;
        this.artist = builder.artist;
    }

//    Debido a la cantidad de atributos se implementa el patron builder, con lo cual facilita la creacion de un objeto con muchos atributos
    public static class SongBuilder {
        private String id;
        private String name;
        private String explicit;
        private String playable;
        private String popularity;
        private Album album;
        private List<Artist> artist;

        public SongBuilder setId(String id) {
            this.id = id;
            return this;
        }

        public SongBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public SongBuilder setExplicit(String explicit) {
            this.explicit = explicit;
            return this;
        }

        public SongBuilder setPlayable(String playable) {
            this.playable = playable;
            return this;
        }

        public SongBuilder setPopularity(String popularity) {
            this.popularity = popularity;
            return this;
        }

        public SongBuilder setAlbum(Album album) {
            this.album = album;
            return this;
        }

        public SongBuilder setArtist(List<Artist> artist) {
            this.artist = artist;
            return this;
        }

        public Song build() {
            return new Song(this);
        }
    }

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

    public List<Artist> getArtist() {
        return artist;
    }

    public void setArtist(List<Artist> artist) {
        this.artist = artist;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
