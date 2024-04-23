package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;

import utility.FileIO;

public class Catalog {
    FileIO io = new FileIO();
    Scanner scan = new Scanner(System.in);

    public ArrayList<Movie> movieCatelog = new ArrayList<>();
    // public ArrayList<Serie> seriesCatelog = new ArrayList<Serie>();

    public ArrayList<Movie> showMovieCatalog() {
        createMovieFromString();
        return movieCatelog;
    }

    public ArrayList<Movie> createMovieFromString(){
    ArrayList<String> list = io.readMovieData();
    for (String s : list) {
        String[] split = s.split(";");
        String title = split[0].trim();
        String genre = split[2].trim();
        float rating = Float.parseFloat(split[3].trim());

        Movie movie = new Movie(title, genre, rating);

        movieCatelog.add(movie);
    }
    return movieCatelog;
    }
//
//    public ArrayList<Movie> seriesCatalog() {
//        ArrayList<String> list =  io.readMovieData();
//        while(scan.hasNextLine()) {
//            list.get(0).split(";");
//        }
//
//        return
//    }




//    public int getSeries() {
//        return seriesCatelog.size();
//    }
}
