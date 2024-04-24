package application;

import java.util.ArrayList;

public class Series extends AMedia {
    private ArrayList<Integer> seasons;
    private ArrayList<Integer> episodes;
    private int seasonNumber;
    private int episodeNumber;


    public Series(String title, String year, ArrayList<String> genres, float rating, ArrayList<Integer> seasons, ArrayList<Integer> episodes) {
        super(title, year, genres, rating);
        this.seasons = seasons;
        this.episodes = episodes;
    }



    @Override
    public String toString() {
        return "" + title + " Release year: " + year + ": "+ "Seasons: " + seasons;
    }
}