package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private RecyclerView recyclerView;
    private MovieAdapter movieAdapter;
    private List<Movie> movies;

    public List<Movie> loadMoviesData() {
        List<Movie> movies = new ArrayList<>();
        try {
            movies = JsonUtils.loadMoviesFromJson(this, R.raw.movies);
        } catch (Exception e) {
            Log.e(TAG, "Error loading movies", e);
            showError("Error loading movies");
        }
        return movies;
    }

    public RecyclerView setupRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycleViewMovies);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        return recyclerView;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        movies = loadMoviesData();

        recyclerView = setupRecyclerView();
        movieAdapter = new MovieAdapter(this, movies);
        //movieAdapter.updateMovies(movies);
        recyclerView.setAdapter(movieAdapter);

    }

    public void showError(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}