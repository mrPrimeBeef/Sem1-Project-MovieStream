package application;

import domain.User;
import utility.TextUI;

public abstract class AMedia implements IMedia {
    public String title;
    public String category;
    TextUI ui = new TextUI();

    @Override
    public void playMedia(AMedia media) {

    }

    public void saveToWatchedList() {

}
}
