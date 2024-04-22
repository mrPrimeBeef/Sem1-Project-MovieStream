package utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import application.Movie;
import application.Series;
import domain.User;

public class FileIO {

    private ArrayList<String> listOfMovies = new ArrayList<>();
    private ArrayList<String> listOfSeries = new ArrayList<>();
    private String moviePath = "data/moviePath.csv";
    private String seriePath = "data/seriePath.csv";
    public String userSavePath = "data/UserData.csv";

    // Metode til at læse data fra fil. Da håndtering af data til moviePath of seriePath
    // håndteres på samme måde, er der lavet en scanFile metode for at undgå dobbelt kode
    public ArrayList<String> readMovieData() {
        ArrayList<String> list;
        list = scanFile(moviePath);

        for (String element : list) {

            listOfMovies.add(element);
        }

        return listOfMovies;
    }

    // Metode til at læse data fra fil. Da håndtering af data til moviePath of seriePath
    // håndteres på samme måde, er der lavet en scanFile metode for at undgå dobbelt kode
    public ArrayList<String> readSerieData() {
        ArrayList<String> list;
        list = scanFile(seriePath);

        for (String element : list) {

            listOfSeries.add(element);
        }

        return listOfSeries;
    }

    // Køre igennem en fil, og gemmer hvert linje til en arraylist som returneres.
    private ArrayList<String> scanFile(String path) {
        ArrayList<String> list = new ArrayList<>();

        try {
            File file = new File(path);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine()); // den er ændre fra next() --> nextLine()
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return list;
    }

    public void saveFavorites(ArrayList<User> user, String path) {


    }

    public void saveWatched(ArrayList<User> user, String path) {


    }

    public void saveUserData(User currentUser) {
        try {
            FileWriter writer = new FileWriter(userSavePath, true);

            writer.append("\n" + currentUser.getUsername() + ", " + currentUser.getPassword());

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<User> readUserData() {
        ArrayList<User> userList = new ArrayList<>();
        ArrayList<String> data = scanFile(userSavePath);

        for (String line : data) {
            String[] parts = line.split(", ");
            if (parts.length >= 2) {
                String username = parts[0].trim();
                String password = parts[1].trim();

                User user = new User(username, password);

                userList.add(user);
            } else {
                System.out.println("Invalid data format: " + line);
            }
        }
        return userList;
    }
}
