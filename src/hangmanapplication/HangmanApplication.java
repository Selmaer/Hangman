package hangmanapplication;

import java.io.IOException;
import java.util.Scanner;

public class HangmanApplication {

    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Guess my word");
        System.out.println();
        boolean doYouWantToPlay = true;
        while(doYouWantToPlay) {
            System.out.println("Let's play!");
            Hangman game = new Hangman();
            
            do { 
                System.out.println();
                System.out.println(game.drawPicture());
                System.out.println();
                System.out.println(game.getFormalCurrentGuess());
                //System.out.println(game.mysteryWord);
                
                // Get the guess
                
                System.out.println("Enter the Caracter");
                char guess = (sc.next().toLowerCase()).charAt(0);
                System.out.println();
                
                // Check if Cararcter is guessed already
                
                while (game.isGuessedAlready(guess)) {
                    System.out.println("Try again.You've already guessed that character.");
                    guess = (sc.next().toLowerCase()).charAt(0);
                }
                
                if (game.playGuess(guess)) {
                    System.out.println("Great guess! It is there.");
                } else {
                    System.out.println("Nope");
                }
                
            }
            while(!game.gameOver());
            
            System.out.println();
            System.out.println("Enter Y if you want to play again");
            char response = (sc.next().toUpperCase()).charAt(0);
            doYouWantToPlay = (response == 'Y');
            }
        }
    }

