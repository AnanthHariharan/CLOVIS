import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);
        int index = 0;
        System.out.print("Hello! My name is Iris. Is there anything I can do for you? ");
        String str = s.nextLine();
        str = str.toLowerCase();

// What can you do?
        while (str.length() == 0) {
            System.out.print("Come on. I'm here to help you. Speak your thoughts, desires, and wishes. If you don't know what I can do for you, just ask...");
            str = s.nextLine();
            str = str.toLowerCase();
        }
        while ((str.contains("can") || str.contains("able")) && str.contains("do"))  {
            System.out.print("I can have a conversation, convert text, and play games");
            str = s.nextLine();
            str = str.toLowerCase();
        }

// Conversation
        while (str.contains("know")) {
            int indexNo = str.indexOf("know");
            String ending = str.substring(str.indexOf("know") + 4, str.length());
            System.out.print("Are you really sure that you know" + ending + "? ");
            str = s.nextLine();
            str = str.toLowerCase();
        }
        while (str.contains("i want"))
        {
            index = str.indexOf("want");
            String predicate = str.substring(index + 4, str.length());
            System.out.print("Sure, you want" + predicate + ", but do you really need it? ");
            str = s.nextLine();
            str = str.toLowerCase();
        }
        while (str.contains("i ")
                && str.contains("you")) {
            String verb = str.substring(1, str.indexOf("you"));
            String rest = str.substring(str.indexOf("you") + 3, str.length());
            System.out.print("What makes you" + verb + "me" + rest + "? ");
            str = s.nextLine();
            str = str.toLowerCase();
        }



// Case conversion
        while (str.contains("text") || str.contains("case")) {
            System.out.println("Enter in your text below:");
            str = s.nextLine();
            System.out.print("Do you want all your phrase to be converted to uppercase, lowercase, or trim it? ");
            String choice = s.nextLine();
            choice = choice.toLowerCase();
            if (choice.contains("lowercase")) {
                System.out.println(str.toLowerCase());
                System.out.print("Anything else? ");
                str = s.nextLine();
                str = str.toLowerCase();
            }
            else if (choice.contains("uppercase")) {
                System.out.println(str.toUpperCase());
                System.out.print("Anything else? ");
                str = s.nextLine();
                str = str.toLowerCase();
            }
            else if (choice.contains("trim")) {
                System.out.println(str.trim());
                System.out.print("Anything else? ");
                str = s.nextLine();
                str = str.toLowerCase();
            }
        } // End of text conversion method

        // Game Center
        while (str.contains("game")) {
            System.out.println("Welcome to the Iris Game Center!");
            System.out.print("What game would you like to play? You can play a guessing game, fortune teller, or The Ultimate Trivia Game! ");
            str = s.nextLine();
            str = str.toLowerCase();

            // Fortune Teller
            if (str.contains("fortune")){
                System.out.println("Welcome to the Magic Fortune Teller!");
                System.out.println("Enter your question and I will answer it! ");
                System.out.println("Remember, I can only answer 'yes' or 'no' questions...");

                String question = s.nextLine();
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
                System.out.print("Anything else? ");
                str = s.nextLine();
                str = str.toLowerCase();

            }

            // Guessing Game
            if (str.contains("guess")) {
                int x = 0;
                System.out.println("I'm thinking of a number. Let's see how long it takes you to guess what it is...");
                int number = (int)(Math.random() * 100);
                int guess = s.nextInt();
                while (guess != number) {
                    x++;
                    if (guess > number) {
                        System.out.println("You're too high, try lower");
                    }
                    else {
                        System.out.println("You're too low, try higher");
                    }
                    guess = s.nextInt();
                }
                if (guess == number) {
                    System.out.println("You got it! It took you " + x + " tries!");
                }
                if (x == 1) {
                    System.out.println("Wow! You're a great guesser!");
                    System.out.print("Anything else? ");
                    str = s.nextLine();
                    str = str.toLowerCase();
                }
                else if (x <= 7) {
                    System.out.println("You are pretty good with your logic!");
                    System.out.print("Anything else? ");
                    str = s.nextLine();
                    str = str.toLowerCase();
                }
                else {
                    System.out.println("Gosh... took you long enough!");
                    System.out.print("Anything else? ");
                    str = s.nextLine();
                    str = str.toLowerCase();
                }


            } // End of Guessing Game

            // Trivia Game
            if (str.contains("trivia")) {
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
                ans = scan.nextLine();

                // Science
                if (ans.equals("a")) {
                    System.out.println();
                    System.out.println("Science Trivia Coming Up!");

                    System.out.println("Q1. What is the longest cell type in the human body?");
                    System.out.println("    a. Skin");
                    System.out.println("    b. Neuron"); // √
                    System.out.println("    c. White Blood Cell");
                    System.out.println("    d. Thigh");
                    ans = scan.nextLine();
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
                    ans = scan.nextLine();
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
                    ans = scan.nextLine();
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
                    ans = scan.nextLine();
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
                    ans = scan.nextLine();
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
                    ans = scan.nextLine();
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
                    ans = scan.nextLine();
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
                    ans = scan.nextLine();
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
                    ans = scan.nextLine();
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
                    ans = scan.nextLine();
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
                    ans = scan.nextLine();
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
                    ans = scan.nextLine();
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

                    System.out.println("Q1. What country won the first football(soccer) world cup?");
                    System.out.println("    a. Spain");
                    System.out.println("    b. Brazil");
                    System.out.println("    c. England");
                    System.out.println("    d. Uruguay"); //√
                    ans = scan.nextLine();
                    if (ans.equals("d")){
                        System.out.println("Correct!");
                        score ++;
                    }
                    else {
                        System.out.println("Incorrect. The correct answer was 'd'");
                    }

                    System.out.println("Q2. What cricket team has the most world cup titles?");
                    System.out.println("    a. England");
                    System.out.println("    b. Australia"); //√
                    System.out.println("    c. India");
                    System.out.println("    d. Scotland");
                    ans = scan.nextLine();
                    if (ans.equals("b")){
                        System.out.println("Correct!");
                        score ++;
                    }
                    else {
                        System.out.println("Incorrect. The correct answer was 'b'");
                    }

                    System.out.println("Q3. Which tennis player has the most Wimbleton titles?");
                    System.out.println("    a. Roger Federer"); // √
                    System.out.println("    b. Bjorn Borg");
                    System.out.println("    c. Rafael Nadal");
                    System.out.println("    d. Serena Williams");
                    ans = scan.nextLine();
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
                System.out.print("Anything else? ");
                str = s.nextLine();
                str = str.toLowerCase();

            } // End of trivia
        } // End of game method
        if (str.contains("bye") || str.contains("nothing")) {
            System.out.println("Okay. Thank you for using Iris. Goodbye!");
            s.close();
            scan.close();
        }

    }
}