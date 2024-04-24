package application;

import java.util.ArrayList;
import java.util.Map;

public class Series extends AMedia {
    private Map<Integer, Integer> seasons;
    private int seasonNumber;
    private int episodeNumber;


    public Series(String title, String year, ArrayList<String> category, float rating, Map<Integer, Integer> seasons) {
        super(title, year, category, rating);
        this.seasons = seasons;
    }



    @Override
    public String toString() {
        return "" + title + " Release year: " + year + ": "+ "Seasons and episodes: " + seasons;
    }
}