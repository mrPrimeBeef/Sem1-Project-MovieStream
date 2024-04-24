package application;

import java.util.ArrayList;
import java.util.Map;

public class Series extends AMedia {
    private ArrayList<Integer> seasons;
    private int seasonNumber;
    private int episodeNumber;


    public Series(String title, String year, ArrayList<String> category, float rating, ArrayList<Integer> seasons, ArrayList<Integer> episodes) {
        super(title, year, category, rating);
        this.seasons = seasons;
    }



    @Override
    public String toString() {
        return "" + title + " Release year: " + year + ": "+ "Seasons and episodes: " + seasons;
    }
}