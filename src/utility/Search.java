package utility;

import java.sql.Array;
import java.util.*;

import application.AMedia;

import static java.lang.String.valueOf;


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
        for (AMedia media : mediaList) {
            for (String category : media.getCategory()) {
                if (!mediaByCategory.containsKey(category)) {
                    mediaByCategory.put(category, new ArrayList<>());
                }
                mediaByCategory.get(category).add(media);  // Ensure media is added here
            }
        }
    }



    public void makeMediaByRating(ArrayList<AMedia> mediaList){
        /*for (AMedia media : mediaList)
        */{
            for (int i = 0; i<mediaList.size();i++)
            {
                mediaByRating.put(mediaList.get(Float.toString(i).getRating(), mediaList.get(i));
            }/*
            for (float rating : media.getRating()) {
                if (!mediaByRating.containsKey(rating)) {
                  mediaByRating.put(rating, new ArrayList<>());
                }
                mediaByRating.get(rating).add(media);
            }*/
        }

    }

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


    public List<AMedia> searchByRating(float rating) {
        if (mediaByRating.containsKey(rating))
        {
            return mediaByRating.get(rating);
        }
        return Collections.emptyList();
    }


}