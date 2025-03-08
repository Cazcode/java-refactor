package com.example.refactor.mapper;

/**
 * Clase padre para realizar los mappers de los objetos especificos, esto permite abstraer la responsabilidad del mapeo de objetos especificos
 * @param <I> Objeto input
 * @param <O> Objeto Output, define el tipo especifico que se desea obtener (Song, Album, Artist)
 */
public interface Mapper <I, O> {
    O map(I input);
}
