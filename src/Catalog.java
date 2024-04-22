import java.util.ArrayList;

import application.IMedia;
import application.Movie;
import application.AMedia;
import utility.FileIO;
import application.Series;

public class Catalog
{
    FileIO io;
    ArrayList<Movie> movies = new ArrayList<>();

    ArrayList<Series> series = new ArrayList<>();

    public void addMovieToCatalog(Movie movie)
    {
        movies.add(movie);
    }

    public ArrayList<String> showMovieCatalog() {
        ArrayList<String> movies = io.readMovieData();
        return movies;
    }

    public ArrayList<String> showSerieCatalog()
    {
        ArrayList<String> series = io.readSerieData();
        return series;
    }

    public int getSeries()
    {
        return series.size();
    }

    public int getMovies() {
        return movies.size();
    }
}
