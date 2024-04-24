package utility;

import java.util.*;

import application.AMedia;


public class Search {

    HashMap<String, AMedia> mediaByTitle = new HashMap<>();
    HashMap<String, AMedia> mediaByCategory = new HashMap<>();
    HashMap<String, AMedia> mediaByRating = new HashMap<>();
    ArrayList<AMedia> movieCatalog;
    ArrayList<AMedia> seriesCatalog;

    public void makeMediaByTitle(ArrayList<AMedia> MediaList){
        for(int i = 0; i < MediaList.size(); i++){
            mediaByTitle.put(MediaList.get(i).getTitle(), MediaList.get(i));
        }
    }

    public void makeMediaByCategory(ArrayList<AMedia> MediaList){
        for(int i = 0; i < MediaList.size(); i++){
            mediaByTitle.put(MediaList.get(i).getCategory(), MediaList.get(i));
        }
    }


    /*
    public void makeMediaByRating(ArrayList<AMedia> movieList){
        for(int i = 0; i < movieList.size(); i++){
            mediaByTitle.put(movieList.get(i).getRating(), (List<AMedia>) movieList.get(i));
        }
    }*/


    public List<AMedia> searchByTitle(String title) {
        return Collections.singletonList(mediaByTitle.get(title));
    }

    public List<AMedia> searchByCategory(String category) {
        return Collections.singletonList(mediaByTitle.get(category));
    }

    /*
    public List<Movie> searchByRating(double rating) {
        return mediaByRating.getOrDefault(rating, Collections.emptyList());
    }
    */

}