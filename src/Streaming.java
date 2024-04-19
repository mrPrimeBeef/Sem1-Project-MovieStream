//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import application.AMedia;
import domain.User;
import java.util.ArrayList;
import utility.FileIO;
import utility.Search;
import utility.TextUI;

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
    ArrayList<String> startmenu;

    public Streaming(String name) {
        this.name = name;
        this.userList = new ArrayList();
        this.name = name;
        this.ui = new TextUI();
        this.io = new FileIO();
        this.startmenu = new ArrayList();
        this.startmenu.add("1) Create user");
        this.startmenu.add("2) Login");
    }

    public void startStreaming() {
        this.ui.displayMessage("Welcome to " + this.name);
        int action = 0;

        while(action != this.startmenu.size()) {
            action = this.ui.promptChoice(this.startmenu, "Create a user or login:");
            switch (action) {
                case 1:
                    this.createUser();
                    this.runStreaming();
                    break;
                case 2:
                    this.login();
                    this.runStreaming();
            }
        }

    }

    public void runStreaming() {
    }

    public User createUser() {
        String username = this.ui.promptText("Please enter your username");
        String password = this.ui.promptText("Please enter your password");
        if (this.checkUsernameAvailability(username)) {
            this.user = new User(username, password);
            this.userList.add(this.user);
        }

        return this.user;
    }

    boolean login() {
        String username = this.ui.promptText("Please enter your username");
        if (this.userList.contains(username)) {
            return true;
        } else {
            this.ui.displayMessage("Wrong username or password");
            return false;
        }
    }

    boolean checkUsernameAvailability(String username) {
        if (!this.userList.contains(username)) {
            this.ui.displayMessage(username + " is available");
            return true;
        } else {
            this.ui.displayMessage(username + "user exists... ");
            return false;
        }
    }
}
