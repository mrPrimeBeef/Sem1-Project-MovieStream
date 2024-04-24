package utility;

import java.util.*;

import application.AMedia;
import application.Movie;
import application.Series;
import utility.TextUI;


public class Search {

    HashMap<String, AMedia> mediaByTitle = new HashMap<>();
    HashMap<String, AMedia> mediaByCategory = new HashMap<>();
    HashMap<String, AMedia> mediaByRating = new HashMap<>();
    ArrayList<AMedia> movieCatalog;
    ArrayList<AMedia> seriesCatalog;

    public void makeMovieHashMaps(ArrayList<Movie> movieList){

    }

    public void makeSeriesByTitle(ArrayList<Series> seriesList){
        for(int i = 0; i < seriesList.size(); i++){
            seriesByTitle.put(seriesList.get(i).getTitle(), (List<Series>) seriesList.get(i));
        }

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
