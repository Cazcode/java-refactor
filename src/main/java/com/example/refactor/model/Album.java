package com.example.refactor.model;

/**
 * Clase creada a partir de la abstraccion de los datos de album en la clase Song
 */
public class Album extends BaseDomain{
    private String type;
    private String releaseDate;
    private String totalTracks;

    public Album() {
    }

    public Album(String id, String name, String type, String releaseDate, String totalTracks) {
        super(id, name);
        this.type = type;
        this.releaseDate = releaseDate;
        this.totalTracks = totalTracks;
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
