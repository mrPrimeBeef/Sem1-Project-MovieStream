import application.AMedia;
import application.Catalog;
import utility.FileIO;
import utility.Search;
import utility.TextUI;

import domain.User;

import java.util.ArrayList;
import java.util.List;

public class Streaming {

    private String name;

    private User currentUser;
    private TextUI ui;
    FileIO io;
    Search search = new Search();
    ArrayList<User> userList;
    ArrayList<String> startmenu;
    ArrayList<String> mainMenu;
    Catalog catelog = new Catalog();
    ArrayList<AMedia> mediaList = catelog.showMediaCatalog();
    ArrayList<AMedia> movieList = catelog.showMovieCatalog();
    ArrayList<AMedia> serieList = catelog.showSeriesCatalog();


    public Streaming(String name) {
        this.name = name;

        userList = new ArrayList();

        this.ui = new TextUI();
        this.io = new FileIO();

        startmenu = new ArrayList<>();

        startmenu.add("Create user");
        startmenu.add("Login");
    }

    public void startStreaming() {
        search.makeMediaByTitle(mediaList);
        search.makeMediaByCategory(mediaList);

        ui.displayMessage("     Welcome to \n" + this.name + "\n");
        userList = io.readUserData();
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
        mainMenu.add("View favorite list");
        mainMenu.add("View watched list");
        mainMenu.add("Search catalog");
        mainMenu.add("Show selection");
        mainMenu.add("Log out");


        menuChoice = ui.promptChoice(mainMenu, "Choose 1-5 from below");

        switch(menuChoice) {
            case 1: // Favs
                ui.displayMessage("list of your favorites list: ");
                int number = ui.promptChoice(io.getFavorites(currentUser),"Choose a title");

                int choice = ui.promptNumeric("1) Play \n2) Delete\n3) Back to menu");
                if (choice == 1) {
                    AMedia media = search.searchByTitle(io.getFavorites(currentUser).get(number-1));
                    playMedia(media);
                } else if (choice == 2) {
                    io.deleteFavorites(io.getFavorites(currentUser).get(number-1), currentUser);
                } else {
                    streamning();
                }
                streamning();
                break;
            case 2: // Seen
                ui.displayMessage("list of your watched list: ");
                 number = ui.promptChoice(io.getWatched(currentUser),"Choose a title");

                choice = ui.promptNumeric("1) Play \n2) Back to menu");
                if (choice == 1) {
                    AMedia media = search.searchByTitle(io.getWatched(currentUser).get(number-1));
                    playMedia(media);
                } else {
                    streamning();
                }
                break;
            case 3: // Search
                ui.displayMessage("Search for a title or category");
                searchChoice();
                streamning();
                break;
            case 4: // Catalog
                selection();
                break;
            case 5: // Log out
                String logOut = ui.promptText("Do you want to log out? y/n");
                if (logOut.toLowerCase().equals("y")) {
                    logOut();
                }else if(logOut.toLowerCase().equals("n"))  {
                    streamning();

                }
            default:
                break;
        }


    }
    public void searchChoice()
    {
        int choice = ui.promptNumeric("1: Title\n2: Category\n3: Rating\n");
        switch(choice){
            case 1:
                String title = ui.promptText("Enter the title:\n");
                AMedia media = search.searchByTitle(title);
                if (media != null) {
                    media.toString();
                } else {
                    ui.displayMessage("No results found for the title: " + title);
                }
                break;
            case 2:
                String category = ui.promptText("Search by category:\n ");
                List<AMedia> mediaInCategory = search.searchByCategory(category);
                if (!mediaInCategory.isEmpty()) {
                    mediaInCategory.toString();
                } else {
                    ui.displayMessage("No results found in the category: " + category);
                }
                break;
            /*case 3:
                double rating = ui.promptDouble("Search by rating: ");
                search.searchByRating(rating);
                break;*/
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

    private void playMedia(AMedia media)
    {
        io.saveWatched(currentUser, media.getTitle());
        ui.displayMessage( "----------------\n" +
                "Playing " + media + "\n"
                + "----------------");
    }

    private void selection() {
        ArrayList<AMedia> showList = ui.randomList(mediaList);
        int choice = 0;
        int number = 0;
        while(number < 4){
            number = ui.promptChoiceM(showList, "\n1) Choose from list \n" + "2) 5 new \n" + "3) back to menu", 5);
            switch (number) {
                case 1:
                    choice = ui.promptChoiceM(showList, "\nChoose from list", 5);

                    choicesForMedia(showList, choice);
                case 2:
                    showList = ui.randomList(mediaList);
                    while(number == 2){
                        number = ui.promptChoiceM(showList, "\n1) Choose from list \n" + "2) 5 new \n" + "3) back to menu", 5);
                        if(number == 1){
                            choice = ui.promptChoiceM(showList, "\nChoose from list", 5);
                            choicesForMedia(showList, choice);
                        } else if (number == 2) {
                            showList = ui.randomList(mediaList);
                        }

                    } if (number == 3) {
                    streamning();
                }
                    break;
                case 3:
                    streamning();
                    break;
                default:
                    ui.displayMessage("Invalid choice, try again");
                    selection();
                    break;

            }
        }
    }

    public void choicesForMedia(ArrayList<AMedia> showList, int choice){
        int input = ui.promptNumeric("1) Want to add to favorite? \n" + "2) Play \n" + "3) Back to menu");

        if (input == 2) {
            playMedia(showList.get(choice - 1));
            streamning();

        } else if (input == 1) {
            io.saveFavorites(currentUser, showList.get(choice - 1).getTitle());
            String stringInput = ui.promptText("Favorites added successfully, Play movie? y/n");
            if (stringInput.toLowerCase().equals("y")) {
                playMedia(showList.get(choice - 1));
                streamning();
            }else if (stringInput.toLowerCase().equals("n")){
                streamning();
            }


        } else if (input == 3) {
            streamning();

        }
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public void logOut(){
        currentUser = null;
        ui.displayMessage("You are now logged out \n \n \n ");
        startStreaming();


        // TODO skal de ikke bare tage en user? og deres path, gemme sted skal der være for hver bruger?
//    io.saveFavorites();
//    io.saveWatched();
    }

}