package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import utility.FileIO;

public class Catalog {
    FileIO io = new FileIO();

    public ArrayList<AMedia> mediaCatalog = new ArrayList<>();

    public ArrayList<AMedia> showMediaCatalog() {
        mediaCatalog = createMediaFromString();
        return mediaCatalog;
    }


    public ArrayList<AMedia> createMediaFromString() {
        ArrayList<String> list = io.readMovieData();
        ArrayList<AMedia> mediaCatalog = new ArrayList<>();
        int movieCount = 0;


        for (String s : list) {
            String[] split = s.split(";");
            String title = split[0].trim();

            ArrayList<String> genres = new ArrayList<>();
            for (String genre : split[2].trim().split(", ")) {
                genres.add(genre.trim());
            }

            float rating = Float.parseFloat(split[3].trim());


            if (movieCount < 100) {
                Movie movie = new Movie(title, genres, rating);
                mediaCatalog.add(movie);
            } else {


                Map<Integer, Integer> seasons = new HashMap<>();
                for (String season : split[4].trim().split(", ")) {
                    String[] seasonEpisodeSplit = season.trim().split("-");
                    int seasonNumber = Integer.parseInt(seasonEpisodeSplit[0].trim());
                    int episodeNumber = Integer.parseInt(seasonEpisodeSplit[1].trim());
                    seasons.put(seasonNumber, episodeNumber);
                }


                // Create a Series object and add it to the catalog
                Series series = new Series(title, genres, rating, seasons);
                mediaCatalog.add(series);

            }

            movieCount++;


        }
        return mediaCatalog;
    }
}