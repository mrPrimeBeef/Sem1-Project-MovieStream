package application;

import domain.User;

public class Movie extends AMedia {
    private User user;

    String title;
    String category;
    float rating;

    public Movie(String title, String category, float rating) {
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
