package application;

import java.util.ArrayList;

public class Series extends AMedia{
    private ArrayList<Integer> episode;
    private ArrayList<Integer> season;

    String title;
    ArrayList<String> category;
    float rating;

    public Series(String title,  ArrayList<String> category, float rating, ArrayList<Integer> episode, ArrayList<Integer> season) {
        this.title = title;
        this.category = category;
        this.rating = rating;
    }



}
