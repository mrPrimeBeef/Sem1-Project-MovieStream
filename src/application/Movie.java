package application;

import domain.User;

import java.util.ArrayList;

public class Movie extends AMedia {
    private User user;

    String title;
    ArrayList<String> category;
    float rating;

    public Movie(String title, ArrayList<String> category, float rating) {
        this.user = user;
        this.title = title;
        this.category = category;
        this.rating = rating;
    }

    @Override
    public void playMedia(AMedia media) {
    ui.displayMessage("playing " + title);
    //user.addToWatchedList();
    }

    public String getTitle() {
        return this.title;
    }

    @Override
    public String toString() {
        return title;
    }
}
