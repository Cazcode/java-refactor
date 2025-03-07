package com.example.refactor.service;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.URL;
import java.util.Collections;
import java.util.stream.Collectors;

public class ExampleFileUtils {

    public static JSONObject getJsonFromFile(File inputSource) {
        JSONParser parser = new JSONParser();
        try {
            return (JSONObject) parser.parse(new FileReader(inputSource));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return (JSONObject) Collections.emptyMap();
    }

    public static File getFileFromResources(String fileName) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        URL resource = classLoader.getResource(fileName);
        if (resource != null) {
            return new File(resource.getFile());
        } else {
            throw new IllegalArgumentException("Missing file");
        }
    }

    public static JSONObject getJsonFromFileName(String fileName) throws IOException {
        String stringObject;
        try (InputStream inputStream =
                     Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            stringObject = reader.lines().collect(Collectors.joining("\n"));
        }catch (IOException e){
            throw new IOException("No se pudo encontrar el archivo: " + fileName);
        }
        JSONParser parser = new JSONParser();
        try {
            return (JSONObject) parser.parse(stringObject);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return (JSONObject) Collections.emptyMap();
    }

}
