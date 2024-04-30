package com.example.hw_arrayadapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class User {
    private String name;
    private String hometown;

    public User(JSONObject object) {
        try {
            this.name = object.getString("name");
            this.hometown = object.getString("city"); // Corrected key to match JSON data
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<User> fromJson(JSONArray jsonObjects) {
        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < jsonObjects.length(); i++) {
            try {
                users.add(new User(jsonObjects.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return users; // Added return statement
    }

    // Getter methods for name and hometown
    public String getName() {
        return name;
    }

    public String getHometown() {
        return hometown;
    }
}
