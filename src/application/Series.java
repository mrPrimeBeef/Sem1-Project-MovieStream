package application;

public class Series extends AMedia{
    private int episode;
    private int season;

    String title;
    String category;
    float rating;

    public Series(String title, String category, float rating) {
        this.title = title;
        this.category = category;
        this.rating = rating;
    }

    @Override
    public void playMedia() {

    }

    @Override
    public void backToMenu(String q) {

    }



}
