package application;

public class Series extends AMedia{
    private int episode;
    private int season;

    String title;
    String category;
    float rating;

    public Series(String title, String category, float rating, int episode, int season) {
        this.title = title;
        this.category = category;
        this.rating = rating;
    }

    @Override
    public void playMedia(AMedia media) {

    }



}
