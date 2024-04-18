import java.util.Scanner;

public class TextUI {
   private Scanner scanner;

   public String promptText(){
       System.out.print("Enter your text: ");
       return "scanner.nextLine()";
   }
   public void displayMessage(String msg){
       System.out.println(msg);
   }
   public int promptInt(String msg){
       return Integer.parseInt(promptText());
   }
}
