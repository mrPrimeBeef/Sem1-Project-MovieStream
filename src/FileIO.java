import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO extends Main{


    public FileIO() {
        String name = "Lasse";
    }


    public ArrayList<String> readMovieData(String moviePath){
        ArrayList<String> movies = new ArrayList<>();
        movies = scanFile(moviePath);

        return movies;
    }


    public ArrayList<String> readSerieData(String seriePath){
        ArrayList<String> series = new ArrayList<>();
        series = scanFile(seriePath);

        return series;
    }


    public void saveFavorites(ArrayList<User> user, String path){


    }


    public void saveWatched(ArrayList<User> user, String path){


    }


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
}
