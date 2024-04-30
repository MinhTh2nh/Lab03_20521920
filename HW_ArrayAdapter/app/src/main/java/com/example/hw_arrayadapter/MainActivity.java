package com.example.hw_arrayadapter;

import android.os.Bundle;
import android.util.JsonReader;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<User> arrayOfUsers = new ArrayList<>();
        // If data was JSON, convert it to ArrayList of User Objects
        try {
            String jsonStr = "["
                    +
                    "{\"name\":\"John\",\"city\":\"New York\"},{\"name\":\"Alice\",\"city\":\"Los Angeles\"},{\"name\":\"Bob\",\"city\":\"Chicago\"}"
                    +
                    "]";
            JSONArray jsonArray = new JSONArray(jsonStr);

            ArrayList<User> newUsers = User.fromJson(jsonArray);
            arrayOfUsers.addAll(newUsers);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Create the adapter
        UserAdapter adapter = new UserAdapter(this, arrayOfUsers);

        // Set the adapter to the ListView
        ListView listView = findViewById(R.id.lvItems);
        listView.setAdapter(adapter);
    }
}
