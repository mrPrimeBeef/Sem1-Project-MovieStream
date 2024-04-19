package utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import application.Movie;
import application.Series;
import domain.User;

public class FileIO{

    private ArrayList<Movie> listOfMovies = new ArrayList<>();
    private ArrayList<Series> listOfSeries = new ArrayList<>();

    // Metode til at læse data fra fil. Da håndtering af data til moviePath of seriePath
    // håndteres på samme måde, er der lavet en scanFile metode for at undgå dobbelt kode
    public ArrayList<Movie> readMovieData(String moviePath){
        ArrayList<String> list;
        list = scanFile(moviePath);

        for (String element : list){
            Movie movie = new Movie();
            listOfMovies.add(movie);
        }

        return listOfMovies;
    }

    // Metode til at læse data fra fil. Da håndtering af data til moviePath of seriePath
    // håndteres på samme måde, er der lavet en scanFile metode for at undgå dobbelt kode
    public ArrayList<Series> readSerieData(String seriePath){
        ArrayList<String> list;
        list = scanFile(seriePath);

        for (String element : list){
            Series serie = new Series();
            listOfSeries.add(serie);
        }

        return listOfSeries;
    }

    // Køre igennem en fil, og gemmer hvert linje til en arraylist som returneres.
    private ArrayList<String> scanFile(String path){
        ArrayList<String> list = new ArrayList<>();

        try {
            File file = new File(path);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                list.add(scanner.next());
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return list;
    }

    public void saveFavorites(ArrayList<User> user, String path){


    }

    public void saveWatched(ArrayList<User> user, String path){


    }

    public void saveUserData(){


    }

    public void readUserData(){


    }

}
