import java.util.ArrayList;

import application.IMedia;
import application.Movie;
import application.AMedia;
public class Catalog
{
    ArrayList<AMedia> list = new ArrayList<>();

    public void addMovieToCatalog(AMedia Movie)
    {
        list.add(Movie);
    }

    public int getCatalog()
    {
        return list.size();
    }



}
