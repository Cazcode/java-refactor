package com.example.refactor.model;

/**
 * Clase creada a partir de la abstraccion de los datos de album en la clase Song
 */
public class Album extends BaseDomain{
    private String type;
    private String releaseDate;
    private String totalTracks;

    public Album(AlbumBuilder builder) {
        super(builder.id, builder.name);
        this.type = builder.type;
        this.releaseDate = builder.releaseDate;
        this.totalTracks = builder.totalTracks;
    }

    public static class AlbumBuilder {
        private String id;
        private String name;
        private String type;
        private String releaseDate;
        private String totalTracks;


        public AlbumBuilder setId(String id) {
            this.id = id;
            return this;
        }

        public AlbumBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public AlbumBuilder setType(String type) {
            this.type = type;
            return this;
        }

        public AlbumBuilder setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
            return this;
        }

        public AlbumBuilder setTotalTracks(String totalTracks) {
            this.totalTracks = totalTracks;
            return this;
        }

        public Album build() {
            return new Album(this);
        }
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTotalTracks() {
        return totalTracks;
    }

    public void setTotalTracks(String totalTracks) {
        this.totalTracks = totalTracks;
    }
}
