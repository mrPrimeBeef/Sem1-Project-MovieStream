package application;

import domain.User;
import utility.TextUI;

public abstract class AMedia implements IMedia {
    public String title;
    public String category;

    TextUI ui = new TextUI();


    public String getTitle(){
        return title;
    }


}
