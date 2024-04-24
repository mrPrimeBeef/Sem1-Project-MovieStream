package application;

import java.util.ArrayList;
import java.util.HashMap;

import utility.FileIO;

public class Catalog {
    FileIO io = new FileIO();

    public ArrayList<AMedia> movieCatelog = new ArrayList<>();
    public ArrayList<AMedia> seriesCatelog = new ArrayList<>();
    public ArrayList<AMedia> mediaCatalog = new ArrayList<>();

    //public ArrayList<AMedia> showMovieCatalog() {
    //    createMovieFromString();
    //    return movieCatelog;
    //}
    public ArrayList<AMedia> showMediaCatalog() {
        mediaCatalog = createMediaFromString();
        return mediaCatalog;
    }

    //public ArrayList<AMedia> showSeriesCatalog() {
    //    createSerieFromString();
    //    return seriesCatelog;
    //}

    public ArrayList<AMedia> createMediaFromString() {
        ArrayList<String> list = io.readMovieData();
        ArrayList<AMedia> mediaCatalog = new ArrayList<>();
        int movieCount = 0;

    ArrayList<String> genre = new ArrayList<>();

        for (String s : list) {
            String[] split = s.split(";");
            String title = split[0].trim();
            String year = split[1].trim();

            ArrayList<String> genres = new ArrayList<>();
            for (String genre : split[2].trim().split(", ")) {
                genres.add(genre.trim());
            }

            float rating = Float.parseFloat(split[3].trim());


            if (movieCount < 100) {
                Movie movie = new Movie(title, year, genres, rating);
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
                Series series = new Series(title, year, genres, rating, seasons);
                mediaCatalog.add(series);

            }

            movieCount++;


        }
        return mediaCatalog;
    }
    public ArrayList<AMedia> createMovieFromString(){
        ArrayList<String> list = io.readMovieData();

        ArrayList<String> genre = new ArrayList<>();

        for (String s : list) {
            String[] split = s.split(";");
            String title = split[0].trim();
            for (String g : split[2].split(",")) {
                genre.add(split[2].trim());
            }

            float rating = Float.parseFloat(split[3].trim());

            Movie movie = new Movie(title, genre, rating);

            movieCatelog.add(movie);
        }
        return movieCatelog;
    }

    public ArrayList<AMedia> createSerieFromString() {
        ArrayList<String> list = io.readSerieData();
        ArrayList<AMedia> seriesCatalog = new ArrayList<>();
        ArrayList<String> genres = new ArrayList<>();

        for (String s : list) {
            String[] split = s.split(";");

            // Extracting title, genre, and rating
            String title = split[0].trim();
            for (String g : split[2].split(",")) {
                genres.add(split[2].trim());
            }
            float rating = Float.parseFloat(split[3].trim());

            // Extracting season and episodes information
            String[] seasonEpisodes = split[4].trim().split(",");
            ArrayList<Integer> seasons = new ArrayList<>();
            ArrayList<Integer> episodes = new ArrayList<>();
            for (String seasonEpisode : seasonEpisodes) {
                String[] seasonEpisodeSplit = seasonEpisode.split("-");
                seasons.add(Integer.parseInt(seasonEpisodeSplit[0].trim()));
                episodes.add(Integer.parseInt(seasonEpisodeSplit[1].trim()));
            }

            // Create a Series object and add it to the catalog
            Series series = new Series(title, genres, rating, seasons, episodes);
            seriesCatalog.add(series);
        }

        return seriesCatalog;
    }
}
