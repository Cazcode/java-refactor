package com.example.refactor.mapper;

import org.json.simple.JSONObject;

/**
 * Se utiliza esta interfaz para separar y abstraer la responsabilidad de obtener los valores string de cada parametro
 */
public interface JsonStringValueExtractor {
    String extractStringValue(JSONObject json, String key);
}