package application;

public class Episode extends Series {

    String title;
    String category;
    float rating;

    public Episode(String title, String category, float rating) {
        super(title, category, rating);
        this.title = title;
        this.category = category;
        this.rating = rating;
    }

}
