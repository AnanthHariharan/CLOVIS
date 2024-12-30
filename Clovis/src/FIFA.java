import java.util.*;

public class FIFA {
    public static int myGoals = 0;
    public static int opGoals = 0;
    public static String myTeam;
    public static String opTeam;
    public static void main() {
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to the Soccer Penalty shootout");
        System.out.print("What team would you like to be? ");
        myTeam = s.nextLine();
        System.out.print("What team would you like to play against? ");
        opTeam = s.nextLine();
        System.out.println("Welcome to the match between " + myTeam + " and " + opTeam);
        System.out.println("And " + myTeam + " starts off with the ball");
        for (int i = 0; i<5; i++) {
            shootout();
            keeping();
        }
        if (myGoals > opGoals) {
            System.out.print(myTeam + " wins with a stunning performance, beating " + opTeam);
            System.out.println(" " + myGoals + "-" + opGoals + "!");
            System.out.print("Well played!");
        }
        else if (myGoals < opGoals) {
            System.out.print(opTeam + " wins with a stunning performance, beating " + myTeam);
            System.out.println(" " + opGoals + "-" + myGoals + "!");
        }
        else {
            while (myGoals == opGoals) {
                shootout();
                keeping();
            }
            if (myGoals > opGoals) {
                System.out.print(myTeam + " wins with a stunning performance, edging over " + opTeam);
                System.out.println(" " + myGoals + "-" + opGoals + "!");
                System.out.print("Well played!");
            }
            else if (myGoals < opGoals) {
                System.out.print(opTeam + " wins with a stunning performance, edging over " + myTeam);
                System.out.println(" " + opGoals + "-" + myGoals + "!");
            }
        }

    }
    public static void shootout() {
        System.out.println(myTeam + " is now shooting");
        Scanner s = new Scanner(System.in);
        int gk = (int)(Math.random() * 3) + 1;
        int pl = 0;
        System.out.print("Would you like to shoot left, right, or straight? ");
        String choice = s.nextLine();
        if (choice.contains("left")){
            System.out.println("Shooting left...");
            pl = 1;
        }
        else if (choice.contains("right")){
            System.out.println("Shooting right...");
            pl = 2;
        }
        else if (choice.contains("straight")){
            System.out.println("Shooting straight...");
            pl = 3;
        }
        else {
            System.out.println("I couldn't understand what you meant. Please try again.");
            shootout();
        }

        System.out.print("And the goalie ");

        if (gk == 1) {
            System.out.println("slides left...");
        }
        else if (gk == 2) {
            System.out.println("slides right...");
        }
        else if (gk == 3) {
            System.out.println("stays put...");
        }

        if (gk == pl) {
            System.out.println("And the goalie saves it! Tough luck!");

        }
        else {
            System.out.println("And " + myTeam + " gets one in the net!");
            myGoals++;
        }
        System.out.println();
    }
    public static void keeping() {
        System.out.println(opTeam + " is now shooting");
        Scanner s = new Scanner(System.in);
        int gk = (int)(Math.random() * 3) + 1;
        int pl = 0;
        System.out.print("Would you like to slide left, right, or stay? ");
        String choice = s.nextLine();
        if (choice.contains("left")){
            System.out.println("Sliding left...");
            pl = 1;
        }
        else if (choice.contains("right")){
            System.out.println("Sliding right...");
            pl = 2;
        }
        else if (choice.contains("stay")){
            System.out.println("Staying put...");
            pl = 3;
        }
        else {
            System.out.println("I couldn't understand what you meant. Please try again.");
            keeping();
        }

        System.out.print("And the striker ");

        if (gk == 1) {
            System.out.println("shoots left...");
        }
        else if (gk == 2) {
            System.out.println("shoots right...");
        }
        else if (gk == 3) {
            System.out.println("shoots straight...");
        }

        if (gk == pl) {
            System.out.println("You've saved the ball!");
        }
        else {
            System.out.println("And that's one more goal for " + opTeam);
            opGoals++;
        }
        System.out.println();
    }
}
