package com.example.retrofit_movie_apiex1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.retrofit_movie_apiex1.network.ApiClient;
import com.example.retrofit_movie_apiex1.network.ApiInterface;
import com.example.retrofit_movie_apiex1.adapter.MoviesAdapter;
import com.example.retrofit_movie_apiex1.network.MoviesResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {



    public static final String API_KEY="c6c5374b89a1bba116b802ef29e0783a";
    MoviesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiService= ApiClient.getClient().create(ApiInterface.class);

        Call<MoviesResponse> call = apiService.getTopReateMovies(API_KEY);
        call.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                Log.d("hh",response.toString());
                List<Movie> results = response.body().getResults();
                List<Movie> movies = response.body().getResults();
                recyclerView.setAdapter(new MoviesAdapter(movies, R.layout.item, getApplicationContext()));

            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {

            }
        });

    }
}
