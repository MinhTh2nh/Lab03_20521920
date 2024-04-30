package com.example.hw_paging;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class MainActivity extends AppCompatActivity {
    private NewsAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://newsapi.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        NewsApiService apiService = retrofit.create(NewsApiService.class);
        apiService.getEverything("tesla", "2024-03-30", "publishedAt", "71605cd15f044763b45b0e2076b9de50").enqueue(new Callback<NewResponse>() {

            @Override
            public void onResponse(Call<NewResponse> call, Response<NewResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    adapter = new NewsAdapter(response.body().getArticles());
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<NewResponse> call, Throwable t) {
                // Handle failure here
            }
        });
    }
}
