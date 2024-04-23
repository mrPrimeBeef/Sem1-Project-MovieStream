package utility;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import application.AMedia;
import application.Movie;
import application.Series;
import domain.User;
import org.w3c.dom.ls.LSOutput;
import utility.TextUI;

public class FileIO {

    private ArrayList<String> listOfMovies = new ArrayList<>();
    private ArrayList<String> listOfSeries = new ArrayList<>();
    private String moviePath = "data/moviePath.csv";
    private String seriePath = "data/seriePath.csv";
    private String favoritesPath = "data/favoritesPath.csv";
    private String watchedPath = "data/watchedPath.csv";
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

    // Giver det nuværende user og nuværende movie objekter videre til 'saveMedia' (Undgår dobbeltkode)
    public void saveFavorites(User currentUser, AMedia media) {
        saveMedia(currentUser, media, favoritesPath);

    }

    // Giver det nuværende user og nuværende movie objekter videre til 'saveMedia' (Undgår dobbeltkode)
    public void saveWatched(User currentUser, AMedia media) {
        saveMedia(currentUser, media, watchedPath);

    }


    // Indlæser enten hele favorites eller watched filen, og indsætter film eller serie titlen på
    // den korrekte linje efter brugernavnet, så pågældende film/serie kan kobles til en bruger.
    public void saveMedia(User currentUser, AMedia media, String path){

        int counter = 0;

        try {
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            FileWriter writer = new FileWriter(path, true);

            while (scanner.hasNextLine()) { //finder hvor i filen en bruger er
                String[] nameSearch = scanner.nextLine().split(";");
                if(currentUser.getUsername().equals(nameSearch[0].trim())){
                    break;
                }
                counter++;
            }
            scanner.close();

            List<String> lines = Files.readAllLines(Path.of(path));
            String lineToEdit = lines.get(counter);
            for(int i = 0; i < counter; i++){
                writer.append(lines.get(i) + "\n");
            }

            String[] arrayToEdit = lineToEdit.split(";");
            arrayToEdit[0] += "; " + media.getTitle() + ", ";

            PrintWriter deleteData = new PrintWriter(path);
            deleteData.print("");
            deleteData.close();

            for(String element : arrayToEdit){
                writer.append(element);
            }

            for(int i = counter + 1; i < lines.size(); i++){
                writer.append("\n" + lines.get(i));
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    // Henter User favorites via 'getMedia' (Undgår dobbeltkode)
    public String getFavorites(User currentUser) {
        return getMedia(currentUser, favoritesPath);
    }

    // Henter User watched via 'getMedia' (Undgår dobbeltkode)
    public String getWatched(User currentUser) {
        return getMedia(currentUser, watchedPath);

    }

    // Leder efter userName i favorites/watched filen, og returnere deres favorites/watched film/movies
    public String getMedia(User currentUser, String path){
        File file = new File(path);

        try{
        Scanner scanner = new Scanner(file);
        String str;

        while (scanner.hasNextLine()) { //finder hvor i favorites filen en bruger er
            String line = scanner.nextLine();
            String[] nameSearch = line.split(";");

            if(currentUser.getUsername().equals(nameSearch[0].trim())){
                str = nameSearch[1];
                System.out.println(str);
                return str;
            }
        }
        scanner.close();
        return "ingen bruger fundet med dette navn!\n";
        }catch(FileNotFoundException e){
            return "Det gik Skidt";
        }
    }

    // gemmer brugerens username og password i en fil
    public void saveUserData(User currentUser) {
        try {
            FileWriter userWriter = new FileWriter(userSavePath, true);
            FileWriter favoritesWriter = new FileWriter(favoritesPath, true);
            FileWriter watchedWriter = new FileWriter(watchedPath, true);

            userWriter.append("\n" + currentUser.getUsername() + ", " + currentUser.getPassword());
            favoritesWriter.append("\n" + currentUser.getUsername() + "; ");
            watchedWriter.append("\n" + currentUser.getUsername() + "; ");

            userWriter.close();
            favoritesWriter.close();
            watchedWriter.close();

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
