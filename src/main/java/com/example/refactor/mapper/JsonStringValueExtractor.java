package com.example.refactor.mapper;

import org.json.simple.JSONObject;

public interface JsonStringValueExtractor {
    String extractStringValue(JSONObject json, String key);
}