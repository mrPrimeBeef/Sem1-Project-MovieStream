package application;

import java.util.ArrayList;
import java.util.Map;

public class Series extends AMedia {
    private Map<Integer, Integer> seasons;
    private int seasonNumber;
    private int episodeNumber;


    public Series(String title, ArrayList<String> category, float rating, Map<Integer, Integer> seasons) {
        super(title, category, rating);
        this.seasons = seasons;
    }



    @Override
    public String toString() {
        return "Title: " + title + ", Genre: " + genres + ", Rating: " + rating + ", Seasons and episodes: " + seasons;
    }
}