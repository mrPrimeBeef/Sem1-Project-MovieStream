import application.AMedia;
import application.Movie;
import utility.FileIO;
import utility.Search;
import utility.TextUI;

import domain.User;

import java.util.ArrayList;

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

public Streaming(String name) {
    this.name = name;

    userList = new ArrayList();

    this.ui = new TextUI();
    this.io = new FileIO();

    startmenu = new ArrayList<>();

    startmenu.add("1) Create user");
    startmenu.add("2) Login");
}

public void runStreaming(){
    ui.displayMessage(this.user.getUsername() + "'s homepage");
    int menuChoice;


    mainMenu = new ArrayList<>();
    mainMenu.add("1) View watched list");
    mainMenu.add("2) View saved list");
    mainMenu.add("3) Search catalog");
    mainMenu.add("4) Exit application");

    menuChoice = ui.promptChoice(mainMenu, "Choose 1-4 from below");


    switch(menuChoice)

    {
        case 1: // Watched
            ui.promptText("list of your watched list ...");
           // this.currentUser.viewWatchedList();
            break;
        case 2: // Saved
            ui.promptText("list of your saved list ...");
           // this.currentUser.viewSavedList();
            break;
        case 3: // Catalog
            ui.promptText("list of our catalog ...");
           // this.currentUser.searchCatalog();
            break;
        case 4: // Exit
            ui.promptText("exiiing ...");
            // this.currentUser.exitApplication();
            break;
        default:
            break;
    }
}



    public void startStreaming() {
        ui.displayMessage("Welcome to " + this.name);
        boolean action = true;
        int choice;


        while(action){
            choice = ui.promptChoice(startmenu, "Create a user or login:");

           switch(choice){
                case 1:
                    this.createUser();
                    this.runStreaming();
                    break;
                case 2:
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

        if (checkCredentialAvailability(username)) {
            user = new User(username, password);
            io.saveUserData(user); //
            this.userList.add(user);
            this.currentUser = user;

        }

        return user;

    }

    boolean confirmPassword(String password) {
        return user.getPassword().equals(password);
    }

    boolean login() {
        String username = ui.promptText("Please enter your username");
        String password = ui.promptText("Please enter your password");

        // indlæs userdata.csv filen og cross reference 'username' + 'password'
        // username og password skal valideres med userdata

        if(userList.contains(username) && userList.contains(password)){
            runStreaming();
            return true;
        } else {
            ui.displayMessage("Wrong username or password");
            startStreaming();
            return false;
        }
    }
    boolean checkCredentialAvailability(String credential) {


            if (!userList.contains(credential))
            {
                ui.displayMessage(credential + " is available");
                return true;
            }
            ui.displayMessage(credential + " user exists... ");
            return false;
    }

    public User getCurrentUser() {
    return currentUser;

    }



}