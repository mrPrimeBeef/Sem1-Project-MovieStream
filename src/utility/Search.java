package utility;

import java.util.*;

import application.AMedia;
import application.Movie;
import application.Series;

public class Search {


    public Search() {
    }

    public void makeMovieHashMaps(ArrayList<Movie> movieList){

    }

    public void makeSeriesHashMaps(ArrayList<Movie> seriesList){

    }

    public List<Movie> searchByTitle(String title, Map<String, List<Movie>> moviesByTitle) {
        return moviesByTitle.getOrDefault(title, Collections.emptyList());
    }

    public List<Movie> searchByCategory(String category, Map<String, List<Movie>> moviesByCategory) {
        return moviesByCategory.getOrDefault(category, Collections.emptyList());
    }

    public List<Movie> searchByRating(double rating, NavigableMap<Double, List<Movie>> moviesByRating) {
        return moviesByRating.getOrDefault(rating, Collections.emptyList());
    }

}
