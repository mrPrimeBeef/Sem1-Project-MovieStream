package utility;

import java.util.*;

import application.AMedia;


public class Search {

    HashMap<String, AMedia> mediaByTitle = new HashMap<>();
    HashMap<String, List<AMedia>> mediaByCategory = new HashMap<>();
    HashMap<String, AMedia> mediaByRating = new HashMap<>();
    ArrayList<AMedia> movieCatalog;
    ArrayList<AMedia> seriesCatalog;

    public void makeMediaByTitle(ArrayList<AMedia> MediaList){
        for(int i = 0; i < MediaList.size(); i++){
            mediaByTitle.put(MediaList.get(i).getTitle(), MediaList.get(i));
        }
    }

    public void makeMediaByCategory(ArrayList<AMedia> mediaList){
        for(AMedia media : mediaList){
            for(String category : media.getCategory()){
                if(!mediaByCategory.containsKey(category)){
                    mediaByCategory.put(category, new ArrayList<>());
                }
                mediaByCategory.get(category).add(media);  // Add the media object to the list
            }
        }
    }


    /*
    public void makeMediaByRating(ArrayList<AMedia> movieList){
        for(int i = 0; i < movieList.size(); i++){
            mediaByTitle.put(movieList.get(i).getRating(), (List<AMedia>) movieList.get(i));
        }
    }*/


    public AMedia searchByTitle(String title) {
        return mediaByTitle.get(title);
    }

    public List<AMedia> searchByCategory(String category) {
        // Check if the category exists in the map
        if (mediaByCategory.containsKey(category)) {
            return mediaByCategory.get(category);
        } else {
            return Collections.emptyList(); // Return an empty list if category not found
        }
    }

    /*
    public List<Movie> searchByRating(double rating) {
        return mediaByRating.getOrDefault(rating, Collections.emptyList());
    }
    */

}