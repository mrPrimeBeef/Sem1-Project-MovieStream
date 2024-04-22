package application;

import domain.User;

public class Movie extends AMedia {
    private User user;

    public Movie() {
    }

    @Override
    public void playMedia() {
    //user.addToWatchedList();
    }

    @Override
    public void backToMenu(String q) {

    }

}
