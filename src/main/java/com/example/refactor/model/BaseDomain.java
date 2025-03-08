package com.example.refactor.model;

/**
 * Clase padre que abstrae atributos y comportamientos genericos entre las clases de dominio
 */
public abstract class BaseDomain {
    private String id;
    private String name;

    protected BaseDomain() {
    }

    protected BaseDomain(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
