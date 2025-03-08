package com.example.refactor.service;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.stream.Collectors;

public class ExampleFileUtils {

    public static JSONObject getJsonFromFileName(String fileName) throws IOException {
        JSONParser parser = new JSONParser();
        try {
            String stringObject = getStringJsonFromFile(fileName);
            return (JSONObject) parser.parse(stringObject);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return (JSONObject) Collections.emptyMap();
    }

    public static String getStringJsonFromFile(String fileName) throws IOException{
        try (InputStream inputStream =
                     Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            return reader.lines().collect(Collectors.joining("\n"));
        }catch (IOException e){
            throw new IOException("No se pudo encontrar el archivo: " + fileName);
        }
    }

}
