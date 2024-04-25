package utility;

import java.sql.Array;
import java.util.*;

import application.AMedia;

import static java.lang.String.valueOf;


public class Search {

    HashMap<String, AMedia> mediaByTitle = new HashMap<>();
    HashMap<String, ArrayList<AMedia>> mediaByCategory = new HashMap<>();
    HashMap<String, ArrayList<AMedia>> mediaByRating = new HashMap<>();
    //HashMap<String, List<AMedia>> mediaByCategory = new HashMap<>();
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



    public void makeMediaByRating(ArrayList<AMedia> mediaList) {
        for (AMedia media : mediaList) {
            String rating = String.valueOf(media.getRating()); // Convert float rating to string
            if (!mediaByRating.containsKey(rating)) {
                mediaByRating.put(rating, new ArrayList<>());
            }
        }
    }

    public AMedia searchByTitle(String title) {
        return mediaByTitle.get(title);
    }

    public ArrayList<AMedia> searchByTitleinput(String title) {
        ArrayList<AMedia> returnList = new ArrayList<>();
        String regex = title.toLowerCase();

        for (Map.Entry<String, AMedia> entry : mediaByTitle.entrySet()) {
            String mediaTitle = entry.getKey().toLowerCase();
            if (mediaTitle.contains(regex)) {
                returnList.add(searchByTitle(entry.getKey()));
            }
        }
        return returnList;
    }

    public ArrayList<AMedia> searchByCategoryInput(String category) {
        ArrayList<AMedia> returnList = new ArrayList<>();
        // Check if the category exists in the map
        for (Map.Entry<String, ArrayList<AMedia>> entry : mediaByCategory.entrySet()) {
            String mediaCategory = entry.getKey().toLowerCase();
            if (mediaCategory.contains(category.toLowerCase())) {
                returnList.addAll(entry.getValue());
            }
        }
        return returnList;
    }

    public List<AMedia> searchByCategory(String category) {
        // Check if the category exists in the map
        if (mediaByCategory.containsKey(category)) {
            return mediaByCategory.get(category);
        } else {
            return Collections.emptyList(); // Return an empty list if category not found
        }
    }


    public List<AMedia> searchByRating(String rating) {
        ArrayList<AMedia> returnList = new ArrayList<>();
        // Check if the category exists in the map
        for (Map.Entry<String, ArrayList<AMedia>> entry : mediaByRating.entrySet()) {
            String mediaRating = entry.getKey().toLowerCase();
            if (mediaRating.contains(rating.toLowerCase())) {
                returnList.addAll(entry.getValue());
            }
        }
        return returnList;
    }


}