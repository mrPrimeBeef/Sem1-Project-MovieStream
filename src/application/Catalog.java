package application;

import java.util.ArrayList;

import utility.FileIO;

public class Catalog {
    FileIO io = new FileIO();
    ArrayList<Movie> movies = new ArrayList<>();

    ArrayList<Series> series = new ArrayList<>();

    public void addMovieToCatalog(Movie movie) {
        movies.add(movie);
    }

    public ArrayList<String> showMovieCatalog(int number) {
        ArrayList<String> movies = io.readMovieData();
        ArrayList<String> movieList = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            movieList.add(movies.get(i));
        }
        return movieList;
    }

    public ArrayList<String> showSerieCatalog(int number) {
        ArrayList<String> series = io.readSerieData();
        ArrayList<String> serieList = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            serieList.add(series.get(i));
        }
        return serieList;
    }

    public int getSeries() {
        return series.size();
    }

    public int getMovies() {
        return movies.size();
    }
}
