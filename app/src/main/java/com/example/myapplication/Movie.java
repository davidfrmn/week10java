package com.example.myapplication;

public class Movie {
    private String title;
    private int year;
    private String genre;
    private String posterResource;

    public Movie(String title, int year, String genre, String posterResource){
        //check if the title is valid
        if (title == null || title.isBlank()){
            this.title = "N/A";
        } else {
            this.title = title;
        }

        this.year = year;

        //check if the genre is valid
        if (genre == null || genre.isBlank()){
            this.genre = "N/A";
        } else {
            this.genre = genre;
        }

        //check if the posterResource is valid
        if (posterResource == null || posterResource.isBlank()){
            this.posterResource = "N/A";
        } else {
            this.posterResource = posterResource;
        }

    }

    public String getTitle(){
        return this.title;
    }

    public int getYear(){
        return this.year;
    }

    public String getGenre(){
        return genre;
    }

    public String getPosterResource(){
        return this.posterResource;
    }

    public String getFormattedYear(){
        if (this.year<0){
            return "N/A";
        }

        return Integer.toString(this.year);
    }

}
