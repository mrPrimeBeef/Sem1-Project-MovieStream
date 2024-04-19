import application.AMedia;
import utility.FileIO;
import utility.Search;
import utility.TextUI;

import domain.User;

import java.util.ArrayList;

public class Streaming {

    private String name;

    private User user;
    private TextUI ui;
    FileIO io;
    Search search;
    String moviePath;
    String seriePath;
    AMedia media;
    ArrayList<User> userList;

public Streaming(String name) {
    this.name = name;

    userList = new ArrayList();
}

public void createUser(String username, String password) {
    user = new User(username, password);
    this.userList.add(user);

}

    public void runStreaming() {


    }

    public void Menu(){

    }



}