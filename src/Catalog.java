import java.util.ArrayList;

import application.IMedia;
import application.Movie;
import application.AMedia;
import utility.FileIO;
import application.Series;

public class Catalog
{
    FileIO io;
    ArrayList<AMedia> movies = new ArrayList<>();

    ArrayList<Series> series = new ArrayList<>();

    public void addMovieToCatalog(AMedia Movie)
    {
        movies.add(Movie);
    }

    public ArrayList<Movie> showMovieCatalog()
    {

        ArrayList<Movie> movies = io.readMovieData();
        return movies;
    }

    public ArrayList<Series> showSerieCatalog()
    {
        ArrayList<Series> series = io.readSerieData();
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
