package com.example.myapplication;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MovieViewHolder extends RecyclerView.ViewHolder{
    private ImageView posterImageView;
    private TextView titleTextView;
    private TextView yearTextView;
    private TextView genreTextView;

    public MovieViewHolder(View view){
        super(view);
        posterImageView = view.findViewById(R.id.imageViewMoviePoster);
        titleTextView = view.findViewById(R.id.textViewTitle);
        yearTextView = view.findViewById(R.id.textViewYear);
        genreTextView = view.findViewById(R.id.textViewGenre);
    }

    public void bind(Movie movie){
        titleTextView.setText(movie.getTitle());
        yearTextView.setText(movie.getFormattedYear());
        genreTextView.setText(movie.getGenre());
        posterImageView.setImageResource(R.drawable.ic_launcher_foreground);
    }

    public ImageView getPosterImageView() {
        return posterImageView;
    }

    public TextView getGenreTextView() {
        return genreTextView;
    }

    public TextView getTitleTextView() {
        return titleTextView;
    }

    public TextView getYearTextView() {
        return yearTextView;
    }

}
