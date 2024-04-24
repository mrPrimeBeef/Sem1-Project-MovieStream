package application;

import domain.User;
import utility.TextUI;

public abstract class AMedia implements IMedia {
    public String title;
    public String category;
    TextUI ui = new TextUI();
    public String title;
    public String year;
    public ArrayList<String> genres;
    public float rating;

    public AMedia(String title, String year,  ArrayList<String> genres, float rating) {
        this.title = title;
        this.year = year;
        this.genres = genres;
        this.rating = rating;
    }

    public String getTitle(){
        return title;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }

    public float getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Genre: " + genres + ", Rating: " + rating;
    }
}