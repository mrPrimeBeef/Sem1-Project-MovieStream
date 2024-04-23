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
    //ArrayList<Movie> movieList = catelog.showMovieCatalog();
    //ArrayList<AMedia> serieList = catelog.showSerieCatalog();
    //search.makeMovieHashMaps(movieList);
    //search.makeSeriesHashMaps(serieList);


    this.ui = new TextUI();
    this.io = new FileIO();

    startmenu = new ArrayList<>();

    startmenu.add("Create user");
    startmenu.add("Login");
}

    public void startStreaming() {
        ui.displayMessage("Welcome to " + this.name + "\n");
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

    streamning();
}

public void streamning(){
    int menuChoice;

    mainMenu = new ArrayList<>();
    mainMenu.add("View watched list");
    mainMenu.add("View saved list");
    mainMenu.add("Search catalog");
    mainMenu.add("List of catalog");
    mainMenu.add("Exit application");


    menuChoice = ui.promptChoice(mainMenu, "Choose 1-5 from below");

    switch(menuChoice) {
        case 1: // Watched
            ui.displayMessage("list of your watched list: ");
            io.getFavorites(currentUser);
            break;
        case 2: // Saved
            ui.displayMessage("list of your saved list: ");
            io.getWatched(currentUser);
            break;
        case 3: // Search
            ui.displayMessage("Search for a title or category");
            // searchCatalog();
            break;
        case 4: // Catelog
            int number = ui.promptNumeric("How many choice do you want?");
            number = ui.promptChoiceM(catelog.showMovieCatalog(),"Choose from the list", number);
            String input = ui.promptText("Want to add to favorite? Y/N");
            if (input.toUpperCase().equals("Y")) {
                 io.saveFavorites(currentUser, catelog.showMovieCatalog().get(number-1));
            }
            playMedia(catelog.showMovieCatalog().get(number-1));
            streamning();
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
        while (true) {
            String username = ui.promptText("Please enter your username");

            if (checkCredentialAvailability(username)) {
                String password = ui.promptText("Please enter your password");
                User newUser = new User(username, password);
                io.saveUserData(newUser);
                userList.add(newUser);
                setCurrentUser(newUser);
                ui.displayMessage("User created successfully");
                return newUser;
            } else {
                ui.displayMessage("Username already exists. Please choose a different username.");

            }
        }
    }

    public boolean login() {
        while (true) {
            String username = ui.promptText("Please enter your username");
            String password = ui.promptText("Please enter your password");

            for (User u : userList) {
                if (username.equals(u.getUsername()) && password.equals(u.getPassword())) {
                    setCurrentUser(u);
                    ui.displayMessage("Login successful");
                    return true;
                }
            }
            ui.displayMessage("Invalid username or password, try again");

        }
    }


    boolean checkCredentialAvailability(String credential) {
        for (User user : userList) {
            if (user.getUsername().equals(credential)) {
                return false; // Credential exists
            }
        }
        ui.displayMessage(credential + " is available");
        return true; // Credential is available
    }

    public User getCurrentUser() {
    return currentUser;

    }

    private void playMedia(Movie media)
    {
        io.saveWatched(currentUser, media);
        ui.displayMessage("Playing " + media);
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