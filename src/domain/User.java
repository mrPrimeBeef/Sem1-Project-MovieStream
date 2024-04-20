package domain;

import application.AMedia;
import application.Movie;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import utility.TextUI;

public class User {
    private String username;
    private String password;

    private TextUI ui = new TextUI();
    private LinkedHashSet<AMedia> watchedList = new LinkedHashSet<>();
    private LinkedHashSet<Movie> savedList = new LinkedHashSet<>();

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

    public void viewWatchedList()
    {

    }
    public void viewSavedList()
    {
    }

    public void searchCatalog()
    {

    }

    public void exitApplication()
    {

    }

}
