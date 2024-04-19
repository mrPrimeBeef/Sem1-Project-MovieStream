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
    ArrayList<String> startmenu;

public Streaming(String name) {
    this.name = name;

    userList = new ArrayList();

    this.name = name;

    this.ui = new TextUI();
    this.io = new FileIO();

    startmenu = new ArrayList<>();

    startmenu.add("1) Create user");
    startmenu.add("2) Login");
}

public void runStreaming(){

}



    public void startStreaming() {
        ui.displayMessage("Welcome to "+this.name);
        int action=0;


        while(action != startmenu.size()){// the quit action is the last action
            action = ui.promptChoice(startmenu, "Create a user or login:");

           switch(action){
                case 1:

                    this.createUser();
                    this.runStreaming();
                    break;
                case 2:
                    //Continue (last saved) game
                    this.login();
                    this.runStreaming();
                    break;
            }
        }
    }

    public void Menu(){

    }

    public User createUser() {
        String username = ui.promptText("Please enter your username");
        String password = ui.promptText("Please enter your password");

        if (checkUsernameAvailability(username)) {
            user = new User(username, password);
            this.userList.add(user);
        }

        return user;

    }

//    boolean confirmPassword(String password) {
//        return this.password.equals(password);
//    }
    boolean login() {
        String username = ui.promptText("Please enter your username");

        if(userList.contains(username)){
            return true;
        } else {
            ui.displayMessage("Wrong username or password");
            return false;
        }

            //String password = ui.promptText("Please enter your password");

    }
    boolean checkUsernameAvailability(String username) {


            if (!userList.contains(username))
            {
                ui.displayMessage(username + " is available");
                return true;
            }
            ui.displayMessage(username + "user exists... ");
            return false;
    }



}