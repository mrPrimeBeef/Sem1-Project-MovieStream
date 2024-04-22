import application.AMedia;
import application.Catalog;
import application.Movie;
import utility.FileIO;
import utility.Search;
import utility.TextUI;

import domain.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Streaming {

    private String name;

    private User user;
    private User currentUser;
    private TextUI ui;
    FileIO io;
    Search search;
    String moviePath;
    String seriePath;
    AMedia media;
    ArrayList<User> userList;
    ArrayList<String> startmenu;
    ArrayList<String> mainMenu;
    ArrayList<String> movieList;
    Catalog catelog = new Catalog();

public Streaming(String name) {
    this.name = name;

    userList = new ArrayList();


    this.ui = new TextUI();
    this.io = new FileIO();

    startmenu = new ArrayList<>();

    startmenu.add("1) Create user");
    startmenu.add("2) Login");
}

    public void startStreaming() {
        ui.displayMessage("Welcome to " + this.name);
        userList = io.readUserData();
        boolean action = true;
        int choice;

        choice = ui.promptChoice(startmenu, "Create a user or login:");

        switch (choice) {
            case 1:
                this.createUser();
                this.runStreaming();
                break;
            case 2:
                if (this.login()) {
                    runStreaming();
                }
                break;
        }
    }


public void runStreaming(){
    ui.displayMessage(this.currentUser.getUsername() + "'s homepage");
    int menuChoice;


    mainMenu = new ArrayList<>();
    mainMenu.add("1) View watched list");
    mainMenu.add("2) View saved list");
    mainMenu.add("3) Search catalog");
    mainMenu.add("4) List of catalog");
    mainMenu.add("5) Exit application");

    menuChoice = ui.promptChoice(mainMenu, "Choose 1-5 from below");


    switch(menuChoice)

    {
        case 1: // Watched
            ui.displayMessage("list of your watched list: ");
           this.currentUser.viewWatchedList();
            break;
        case 2: // Saved
            ui.displayMessage("list of your saved list: ");
           this.currentUser.viewSavedList();
            break;
        case 3: // Search
            ui.displayMessage("Search for a title or category");
           // searchCatalog();
            break;
        case 4: // Catelog
            int numberM = ui.promptNumeric("How many movies do you want to see?");
            ui.displayList(catelog.showMovieCatalog(numberM),"list of our movies: ");
            int numberS = ui.promptNumeric("How many series do you want to see?");
            ui.displayList(catelog.showSerieCatalog(numberS),"list of our series: ");
            ui.promptText("Choose one of the following series to see, or show more ");
            break;
        case 5: // Exit
            ui.displayMessage("exiting");
            exitApplication();
            break;
        default:
            break;
    }
}


    public User createUser() {
        String username = ui.promptText("Please enter your username");
        String password = ui.promptText("Please enter your password");

        if (checkCredentialAvailability(username)) {
            user = new User(username, password);
            io.saveUserData(user);
            this.userList.add(user);
            this.currentUser = user;

        }

        return user;

    }

    public boolean login( ) {
        String username = ui.promptText("Please enter your username");
        String password = ui.promptText("Please enter your password");

        for (User u : userList) {
            if (username.equals(u.getUsername())) {
                if (password.equals(u.getPassword())) {
                    setCurrentUser(u);
                    ui.displayMessage("Login successful");
                    return true;
                }
            }else {
                ui.displayMessage("invalid username or password, create a new user");
                startStreaming();
                return false;
            }
        }
        return false;
    }

    
    boolean checkCredentialAvailability(String credential) {


            if (!io.userSavePath.contains(credential)){
                ui.displayMessage(credential + " is available");
                return true;
            }
            ui.displayMessage(credential + " user exists... ");
            startStreaming();
            return false;
    }

    public User getCurrentUser() {
    return currentUser;

    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public void exitApplication(){

    // TODO skal de ikke bare tage en user? og deres path, gemme sted skal der være for hver bruger?
//    io.saveFavorites();
//    io.saveWatched();
    }

}