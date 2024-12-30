import java.util.*;

public class Games {
    public static Scanner s = new Scanner(System.in);
    public static String str;

    // FORTUNE
    public static void fortune(String name) {
        System.out.println("Welcome to the Magic Fortune Teller!");
        System.out.println("Enter your question and I will answer it! ");
        System.out.println("Remember, I can only answer 'yes' or 'no' questions...");

        String question = s.nextLine();
        int number = (int)(Math.random() * 9 + 1);
        if (number == 1){
            System.out.println("Certainly!");
        }
        if (number == 2){
            System.out.println("Most probably");
        }
        if (number == 3){
            System.out.println("Quite likely");
        }
        if (number == 4){
            System.out.println("Probably");
        }
        if (number == 5){
            System.out.println("Maybe");
        }
        if (number == 6){
            System.out.println("Probably not");
        }
        if (number == 9){
            System.out.println("I don't think so");
        }
        if (number == 7){
            System.out.println("It's not gonna happen");
        }
        else {
            System.out.println("Never, ever, ever...");
        }
    }
    //
}
