package utility;

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

    public void displayList(ArrayList<String> list, String msg){
        System.out.println(msg);
        for (String option : list) {
            System.out.println(option);
        }
    }

    public void displayMessage(String msg){
        System.out.println(msg);
    }
}

/*
    public boolean promptBinary(String msg, String accept, String reject ){
        boolean output;
        // todo: check at der tastes enten y eller n
        // lav rekursivt kald hvis det er noget tredje

        String input = promptText(msg);
        if(input.equalsIgnoreCase(accept)){
            return true;
        }else if(input.equalsIgnoreCase(reject)){
            return false;
        }else{
            return promptBinary(msg,accept, reject);
        }
    }
 */