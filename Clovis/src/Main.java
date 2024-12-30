import java.util.*;
public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome! I am Iris, the Interactive Robotic Information System");
        System.out.print("Let me get to know you. What is your name? ");
        String str = sc.nextLine();
        User.setName(str);
        System.out.print("Now, please enter your age ");
        int i = sc.nextInt();
        System.out.println("Thank you, " + User.getName());
        manager();
    } // 
    public static void manager() {
        String str = " ";
        System.out.println();
        System.out.print("What would you like to do? ");
        str = sc.nextLine();

        // Blank
        if (str.equals("")) {
            blank();
            manager();
        }

        // How-To
        else if ((str.contains("can") || str.contains("able")) && str.contains("do"))  {
            System.out.println();
            System.out.println("Here's what I can do: ");
            System.out.println("I can have a conversation with you");
            System.out.println("I can let you play all kinds of games");
            manager();
        }

        // Program Exit
        else if (str.equals("quit") || str.contains("exit")) {
            System.out.println("You have chosen to quit the application. Goodbye!");
        }

        // Conversation
        else if (str.contains("convers") || str.contains("talk")) {
            System.out.print("So, would you like to talk about something? Type in 'yes' or 'no' ");
            str = receive();
            if (str.contains("ye")) {
                conversation();
                System.out.println("Remember, just type in the word 'done' if you're done talking");
                System.out.println("So, what would you like to talk about, " + User.getName() + "?");
            }
            else if (str.contains("n")) {
                System.out.println("Okay, then. I'd love to talk with you later!");
                System.out.println();
                manager();
            }
            else {
                System.out.println("Sorry, I couldn't understand");
                System.out.println();
                manager();
            }
        }

        // Game
        else if (str.contains("game") || str.contains("play")) {
            System.out.println("You are now being redirected to the gaming center");
            gameOpen();
        }

        // Error
        else {
            System.out.println("I'm sorry, I wasn't able to understand what you were saying");
            System.out.println("If you would like to end the application, just type in 'quit'");
            System.out.println();
            manager();
        }
    }


    // Conversational Methods
    public static String receive() {
        String str = sc.nextLine();
        str = str.toLowerCase();
        str = str.trim();
        return str;
    } // Standardization of user response reception
    public static void blank() {
        System.out.print("Ask me what I can do if you're unsure. ");
        System.out.println();
    } // Empty command handler
    public static void conversation() {


        String str = receive() + " ";
        while (str.contains("me")) {
            if (str.indexOf("me") == 0) {
                int i = str.indexOf("me");
                String s = str.substring(i + 2);
                str = "you " + s;
            }
            else {
                int i = str.indexOf("me");
                String s1 = str.substring(0, i - 1);
                String s2 = str.substring(i + 2);
                str = s1 + " you " + s2;
            }
        }
        while (str.contains("you")) {
            if (str.indexOf("me") == 0) {
                int i = str.indexOf("me");
                String s = str.substring(i + 2);
                str = "you " + s;
            }
            else {
                int i = str.indexOf("me");
                String s1 = str.substring(0, i - 1);
                String s2 = str.substring(i + 2);
                str = s1 + " you " + s2;
            }
        }
        while (str.contains("my")) {
            if (str.indexOf("my") == 0) {
                int i = str.indexOf("my");
                String s = str.substring(i + 2);
                str = "your" + s;
            }
            else {
                int i = str.indexOf("my");
                String s1 = str.substring(0, i - 1);
                String s2 = str.substring(i + 2);
                str = s1 + " your" + s2;
            }
        }
        while (str.contains("your")) {
            if (str.indexOf("me") == 0) {
                int i = str.indexOf("me");
                String s = str.substring(i + 4);
                str = "you " + s;
            }
            else {
                int i = str.indexOf("your");
                String s1 = str.substring(0, i - 1);
                String s2 = str.substring(i + 4);
                str = s1 + " my" + s2;
            }
        }
        System.out.println("Tell me about " + str);
        str = receive();
        while (!str.equals("done")) {
            if (str.contains("know")) {
                int indexNo = str.indexOf("know");
                String ending = str.substring(str.indexOf("know") + 4, str.length());
                System.out.println("Are you really sure that you know" + ending + "? ");
                receive();
            }
            else if (str.contains("i want")) {
                int index = str.indexOf("want");
                String predicate = str.substring(index + 4);
                System.out.println("Sure, you want" + predicate + ", but do you really need it? ");
                receive();
            }
            else {
                System.out.println("Interesting. Tell me more");
                receive();
                System.out.println();
            }
        }
        System.out.println("I enjoyed our talk!");
        manager();
    } // Command handler

    // Gaming Methods
    public static void gameOpen() {
        String back;
        System.out.println();
        System.out.println("Welcome to the Iris Game Center! ");
        System.out.print("Based on what your age, I think you will like ");
        if (User.getAge() < 20) {
            System.out.println("Soccer Shootout");
        }
        else if (User.getAge() < 60) {
            System.out.println("Trivia Time");
        }
        else {
            System.out.println("Fortune Teller");
        }
        gameCenter();
    } // Introductory gaming method
    public static void gameCenter() {
        String returning = "";
        System.out.println(returning);
        System.out.println("What would you like to play? ");
        String str = receive();
        while ((!str.equals("quit")) || (!str.equals("exit"))) {
            if (str.contains("guess")) {
                System.out.println();
                guess();
                gameCenter();
            } // Guessing Game
            else if (str.contains("soccer")) {
                soccer();
                returning = "Welcome back! I hope you enjoyed your game of soccer!";
                gameCenter();
            } // Soccer Shootout
            else if (str.contains("fortune")) {
                fortune();
                returning = "Welcome back! I hope you received good fortune!";
                gameCenter();
            } // Fortune Teller
            else if (str.contains("trivia")) {
                triviaTime();
                returning = "Welcome back! I hope you did well in trivia!";
                gameCenter();

            } // Trivia Time
            else {
                System.out.println("Sorry, I couldn't understand what you said");
                System.out.println("Restarting the Game Center...");
                gameCenter();
            } // Error
        }
    } // Central gaming method
    public static void guess() {
        int x = 0;
        System.out.println("I'm thinking of a number. Let's see how long it takes you to guess what it is...");
        int number = (int)(Math.random() * 100);
        int guess = sc.nextInt();
        while (guess != number) {
            x++;
            if (guess > number) {
                System.out.println("You're too high, try lower");
            }
            else {
                System.out.println("You're too low, try higher");
            }
            guess = sc.nextInt();
        }
        if (guess == number) {
            System.out.println("You got it! It took you " + x + " tries!");
        }
        if (x == 1) {
            System.out.println("Wow! You're a great guesser!");
            System.out.println("Thanks for playing!");
            gameCenter();
        }
        else if (x <= 7) {
            System.out.println("You are pretty good with your logic!");
            System.out.println("Thanks for playing!");
            gameCenter();
        }
        else {
            System.out.println("Gosh... took you long enough!");
            System.out.println("Thanks for playing!");
            gameCenter();
        }
    } // Number guessing game
    public static void soccer() {
        System.out.println();
        FIFA.main();
    } // Soccer game
    public static void fortune() {
        System.out.println("Welcome to the Magic Fortune Teller!");
        System.out.println("Enter your question and I will answer it! ");
        System.out.println("Remember, I can only answer 'yes' or 'no' questions...");

        String question = sc.nextLine();
        int number = (int)(Math.random() * 8 + 1);
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
        if (number == 7){
            System.out.println("It's not gonna happen");
        }
        if (number == 8){
            System.out.println("Never, ever, ever...");
        }
    } // Randomized fortune teller
    public static void triviaTime() {
        String ans;
        int score = 0;

        // Subject Selection
        System.out.println("Welcome to Trivia Time!");
        System.out.println("Choose a subject:");
        System.out.println("a. Science");
        System.out.println("b. Mathematics");
        System.out.println("c. History");
        System.out.println("d. Geography");
        System.out.println("e. Sports");
        ans = sc.nextLine();

        // Science
        if (ans.equals("a")) {
            System.out.println();
            System.out.println("Science Trivia Coming Up!");

            System.out.println("Q1. What is the longest cell type in the human body?");
            System.out.println("    a. Skin");
            System.out.println("    b. Neuron"); // √
            System.out.println("    c. White Blood Cell");
            System.out.println("    d. Thigh");
            ans = sc.nextLine();
            if (ans.equals("b")){
                System.out.println("Correct!");
                score ++;
            }
            else {
                System.out.println("Incorrect. The correct answer was 'b'");
            }

            System.out.println("Q2. Sound travels fastest in which of the following?");
            System.out.println("    a. Air");
            System.out.println("    b. Soil");
            System.out.println("    c. Water"); // √
            System.out.println("    d. Space");
            ans = sc.nextLine();
            if (ans.equals("c")){
                System.out.println("Correct!");
                score ++;
            }
            else {
                System.out.println("Incorrect. The correct answer was 'c'");
            }

            System.out.println("Q3. Glass is a...");
            System.out.println("    a. Solid");
            System.out.println("    b. Liquid"); // √
            System.out.println("    c. Gas");
            System.out.println("    d. Plasma");
            ans = sc.nextLine();
            if (ans.equals("b")){
                System.out.println("Correct!");
                score ++;
            }
            else {
                System.out.println("Incorrect. The correct answer was 'b'");
            }
        }
        // End of Science
        // Math
        else if (ans.equals("b")) {
            System.out.println();
            System.out.println("Math Trivia Coming Up!");

            System.out.println("Q1. How many sides does a dodecahedron have?");
            System.out.println("    a. 10");
            System.out.println("    b. 11");
            System.out.println("    c. 12"); // √
            System.out.println("    d. 20");
            ans = sc.nextLine();
            if (ans.equals("c")){
                System.out.println("Correct!");
                score ++;
            }
            else {
                System.out.println("Incorrect. The correct answer was 'c'");
            }

            System.out.println("Q2. Which of the following is the 'golden ratio'?");
            System.out.println("    a. 0.5");
            System.out.println("    b. 0.667");
            System.out.println("    c. 2.718");
            System.out.println("    d. 1.617"); // √
            ans = sc.nextLine();
            if (ans.equals("d")){
                System.out.println("Correct!");
                score ++;
            }
            else {
                System.out.println("Incorrect. The correct answer was 'd'");
            }

            System.out.println("Q3. What do the opposite sides of a die add up to?");
            System.out.println("    a. 6");
            System.out.println("    b. 7"); // √
            System.out.println("    c. 8");
            System.out.println("    d. 9");
            ans = sc.nextLine();
            if (ans.equals("b")){
                System.out.println("Correct!");
                score ++;
            }
            else {
                System.out.println("Incorrect. The correct answer was 'b'");
            }
        }
        // End of Math


        // History
        else if (ans.equals("c")) {
            System.out.println();
            System.out.println("History Trivia Coming Up!");

            System.out.println("Q1. The American civil war ended in what year?");
            System.out.println("    a. 1860");
            System.out.println("    b. 1865"); // √
            System.out.println("    c. 1870");
            System.out.println("    d. 1875");
            ans = sc.nextLine();
            if (ans.equals("b")){
                System.out.println("Correct!");
                score ++;
            }
            else {
                System.out.println("Incorrect. The correct answer was 'b'");
            }

            System.out.println("Q2. Which British captain discovered Australia?");
            System.out.println("    a. James Cook"); // √
            System.out.println("    b. Winston Churchill");
            System.out.println("    c. Robert Clive");
            System.out.println("    d. George Washington");
            ans = sc.nextLine();
            if (ans.equals("a")){
                System.out.println("Correct!");
                score ++;
            }
            else {
                System.out.println("Incorrect. The correct answer was 'a'");
            }

            System.out.println("Q3. Which Asian country Allied with the US in WWII?");
            System.out.println("    a. North Korea");
            System.out.println("    b. South Korea");
            System.out.println("    c. China"); // √
            System.out.println("    d. Japan");
            ans = sc.nextLine();
            if (ans.equals("c")){
                System.out.println("Correct!");
                score ++;
            }
            else {
                System.out.println("Incorrect. The correct answer was 'c'");
            }
        }
        // End of History


        // Geography
        else if (ans.equals("d")) {
            System.out.println();
            System.out.println("Geography Trivia Coming Up!");

            System.out.println("Q1. What continent is Brunei located in?");
            System.out.println("    a. Africa");
            System.out.println("    b. Asia"); // √
            System.out.println("    c. South America");
            System.out.println("    d. Oceania");
            ans = sc.nextLine();
            if (ans.equals("b")){
                System.out.println("Correct!");
                score ++;
            }
            else {
                System.out.println("Incorrect. The correct answer was 'b'");
            }

            System.out.println("Q2. In what country is Dutch spoken?");
            System.out.println("    a. Deutschland");
            System.out.println("    b. Denmark");
            System.out.println("    c. Netherlands"); // √
            System.out.println("    d. Algeria");
            ans = sc.nextLine();
            if (ans.equals("c")){
                System.out.println("Correct!");
                score ++;
            }
            else {
                System.out.println("Incorrect. The correct answer was 'c'");
            }

            System.out.println("Q3. Which two countries share the world's longest border?");
            System.out.println("    a. Russia & China");
            System.out.println("    b. America & Canada"); // √
            System.out.println("    c. China & India");
            System.out.println("    d. Argentina & Chile");
            ans = sc.nextLine();
            if (ans.equals("b")){
                System.out.println("Correct!");
                score ++;
            }
            else {
                System.out.println("Incorrect. The correct answer was 'b'");
            }
        }
        // End of Geography

        // Sports
        else if (ans.equals("e")) {
            System.out.println();
            System.out.println("Sports Trivia Coming Up!");

            System.out.println("Q1. What country won the first soccer world cup?");
            System.out.println("    a. Spain");
            System.out.println("    b. Brazil");
            System.out.println("    c. England");
            System.out.println("    d. Uruguay"); // √
            ans = sc.nextLine();
            if (ans.equals("d")){
                System.out.println("Correct!");
                score ++;
            }
            else {
                System.out.println("Incorrect. The correct answer was 'd'");
            }

            System.out.println("Q2. What baseball team has the most World Series titles?");
            System.out.println("    a. San Francisco Giants");
            System.out.println("    b. New York Yankees"); // √
            System.out.println("    c. Chicago Cubs");
            System.out.println("    d. Washington Nationals");
            ans = sc.nextLine();
            if (ans.equals("b")){
                System.out.println("Correct!");
                score ++;
            }
            else {
                System.out.println("Incorrect. The correct answer was 'b'");
            }

            System.out.println("Q3. Which tennis player has the most Wimbledon titles?");
            System.out.println("    a. Roger Federer"); // √
            System.out.println("    b. Bjorn Borg");
            System.out.println("    c. Rafael Nadal");
            System.out.println("    d. Serena Williams");
            ans = sc.nextLine();
            if (ans.equals("a")){
                System.out.println("Correct!");
                score ++;
            }
            else {
                System.out.println("Incorrect. The correct answer was 'a'");
            }
        }
        // End of Sports


        // Score Evaluation
        System.out.println();
        System.out.println("Your score was " + score + " out of 3");
        if (score == 3) {
            System.out.println("Well done! Looks like you know your facts!");
        }
        else if (score == 2) {
            System.out.println("Not bad! You're almost there");
        }
        else {
            System.out.println("You bombed it... better luck next time!");
        }
    } // Trivia game
}