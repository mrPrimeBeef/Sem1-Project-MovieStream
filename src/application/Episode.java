package application;

public class Episode extends Series {

    String title;
    String category;
    float rating;

    public Episode(String title, String category, float rating, int episode, int season, String title1, String category1, float rating1) {
        super(title, category, rating, episode, season);
        this.title = title1;
        this.category = category1;
        this.rating = rating1;
    }
}
