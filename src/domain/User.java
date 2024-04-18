package domain;

import application.AMedia;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    ArrayList<AMedia> watchedList;
    ArrayList<AMedia> SavedList;

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

    boolean confirmPassword(String password) {
        return this.password.equals(password);
    }
    boolean login(String password) {
        return this.password.equals(password);
    }
    boolean checkUsernameAvailability(String username) {
        return this.username.equals(username);
    }
    boolean validatePassword(String password) {
        return this.password.equals(password);
    }
}
