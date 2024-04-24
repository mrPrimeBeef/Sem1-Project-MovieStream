package application;

import java.util.ArrayList;

import utility.FileIO;

public class Catalog {
    FileIO io = new FileIO();

    public ArrayList<AMedia> movieCatalog = new ArrayList<>();
    public ArrayList<AMedia> seriesCatalog = new ArrayList<>();

    public ArrayList<AMedia> showMovieCatalog() {
        movieCatalog = createMovieFromString();
        return movieCatalog;
    }

    public ArrayList<AMedia> showSerieCatalog() {
        seriesCatalog = createSerieFromString();
        return seriesCatalog;
    }
    /*public ArrayList<AMedia> showMediaList()
    {
        mediaList = createMediaFromString();
        return mediaList;
    }*/

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

        movieCatalog.add(movie);
    }
    return movieCatalog;
    }

    public ArrayList<AMedia> createSerieFromString() {
        ArrayList<String> list = io.readSerieData();
        ArrayList<AMedia> seriesCatalog = new ArrayList<>();

        for (String s : list) {
            String[] split = s.split(";");

            // Extracting title, genre, and rating
            String title = split[0].trim();
            ArrayList<String> genres = new ArrayList<>();
            for (String g : split[2].split(",")) {
                genres.add(g.trim()); // Add individual genre to the list
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
