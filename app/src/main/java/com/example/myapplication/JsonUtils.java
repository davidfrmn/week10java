package com.example.myapplication;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class JsonUtils {
    private static final String TAG = "JsonUtils";

    public static List<Movie> loadMoviesFromJson(Context context, int resourceId) throws IOException, JSONException {
        List<Movie> movies = new ArrayList<>();
        // read json
        String jsonContent = readJsonFile(context,resourceId);

        //parse json
        JSONArray jsonArray = new JSONArray(jsonContent);

        // checking movie data and add them to the list
        for (int i = 0; i<jsonArray.length();i++){
            //data of current movie
            JSONObject movieJson = jsonArray.optJSONObject(i);

            //skip if there is no data
            if (movieJson == null || movieJson.length()==0){
                continue;
            }

            String title = movieJson.optString("title", "N/A");
            int year = movieJson.optInt("year",-1);
            String genre = movieJson.optString("genre","N/A");
            String poster = movieJson.optString("poster","N/A");

            Movie movie = new Movie(title,year,genre,poster);
            movies.add(movie);
        }

        return movies;
    }

    private static void handleJsonException(Exception e){
        Log.e(TAG, "Error reading JSON file", e);
    }

    private static String readJsonFile(Context context, int resourceId) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try (InputStream inputStream = context.getResources().openRawResource(resourceId);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            handleJsonException(e);
            throw e;
        }
        return stringBuilder.toString();
    }

}
