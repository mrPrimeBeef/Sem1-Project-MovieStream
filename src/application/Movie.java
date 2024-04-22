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
    public void playMedia() {
    //user.addToWatchedList();
    }

    @Override
    public void backToMenu(String q) {

    }

}
