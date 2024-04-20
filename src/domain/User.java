package domain;

import application.AMedia;
import application.Movie;
import utility.FileIO;
import utility.Search;
import utility.TextUI;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class User {
    private String username;
    private String password;
    private Search search = new Search();
    private ArrayList<AMedia> catelog = new ArrayList<>();
    private LinkedHashSet<AMedia> watchedList = new LinkedHashSet<>();
    private LinkedHashSet<AMedia> savedList = new LinkedHashSet<>();

    public User(String username, String password) {
        this.username = username;
        this.password = password;

    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

    public void viewWatchedList() {
        Movie movie1 = new Movie();
        Movie movie2 = new Movie();
        watchedList.add(movie1);
        watchedList.add(movie2);
        // TODO add search
        for (AMedia option : watchedList) {
            System.out.println(option);
        }

    }

    public void saveToWatchedList(AMedia option) {
        watchedList.add(option);
    }
    public void viewSavedList() {
        Movie movie1 = new Movie();
        Movie movie2 = new Movie();
        savedList.add(movie1);
        savedList.add(movie2);
        // TODO add search
        for (AMedia option : savedList) {
            System.out.println(option);
        }

    }

    public void saveToSavedList(AMedia option) {
        savedList.add(option);
    }


}
