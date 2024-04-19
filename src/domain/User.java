package domain;

import application.AMedia;

import java.util.ArrayList;
import java.util.LinkedList;

public class User {
    private String username;
    private String password;
    LinkedList<AMedia> watchedList;
    LinkedList<AMedia> savedList;

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

    public LinkedList<AMedia> getSavedList() {
        return savedList;
    }

    public LinkedList<AMedia> getWatchedList() {
        return watchedList;
    }


    public void addSavedMedia(AMedia media){
        if(!savedList.contains(media)) {
            savedList.add(media);
        }
    }
    public void removeSavedMedia(AMedia media){
        if(savedList.contains(media)){
            savedList.remove(media);
        }
    }
    public void addWatchedMedia(AMedia media) {
        if (!watchedList.contains(media)){
            watchedList.add(media);
        }
    }



}
