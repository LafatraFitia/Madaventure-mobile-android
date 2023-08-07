package com.itumaster.madaventure.model;

import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class BaseModel {
    // Méthode de désérialisation à partir d'une chaîne JSON
    public static <T extends BaseModel> T fromJson(String json, Class<T> clazz) {
        Gson gson = new Gson();
        return gson.fromJson(json, clazz);
    }

    public String toJson() {
        return new Gson().toJson(this);
    }

    public String toJsonNonNull() {
        Gson gson = new Gson();
        Map<String, Object> nonNullFields = new HashMap<>();

        // Parcours des attributs de la classe pour ajouter ceux non null ou déjà initialisés
        for (java.lang.reflect.Field field : getClass().getDeclaredFields()) {
            try {
                field.setAccessible(true);
                Object value = field.get(this);
                if (value != null) {
                    nonNullFields.put(field.getName(), value);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return gson.toJson(nonNullFields);
    }
}


