package utility;

import application.AMedia;
import application.Movie;

import java.util.ArrayList;
import java.util.Scanner;

public class TextUI {
    private Scanner scanner = new Scanner(System.in);

    public String promptText(String msg){
        displayMessage(msg);
        return scanner.nextLine();
    }

    public int promptNumeric(String msg) {
        String input = promptText(msg);
        if (!input.matches("^[0-9]+$")) { // Brug matches() til at sammenligne med regex
            displayMessage("Invalid input, try again");
            return promptNumeric(msg); // Returner resultatet af det rekursive kald
        } else {
            return Integer.parseInt(input);
        }
    }

    public int promptChoice(ArrayList<String> optionslist, String msg){
        displayMessage(msg);
        displayList(optionslist, "");
        int input = promptNumeric("");
        return input;

    }
    public int promptChoiceM(ArrayList<Movie> optionslist, String msg, int number){
        displayMessage(msg);
        displayListM(optionslist, "", number);
        int input = promptNumeric("");
        return input;

    }

    public void displayList(ArrayList<String> list, String msg){
        System.out.println(msg);
        int counter = 1;
        for (String option : list) {
            System.out.print(counter + ") ");
            counter++;
            System.out.println(option);
        }
    }
    public void displayListM(ArrayList<Movie> list, String msg, int number){
        System.out.println(msg);
        for (int i = 0; i < number; i++) {
            System.out.println(i + 1 + ") " + list.get(i));
        }
    }

    public void displayMessage(String msg){
        System.out.println(msg);
    }
}