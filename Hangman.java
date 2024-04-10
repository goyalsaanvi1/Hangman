import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
public class Hangman {
    // execution begins here
    public static void main(String args[]) {
        Scanner scnr = new Scanner(System.in); 
        String [] words = {"orange", "talked", "laptop", "coffee", "tinted"}; 
        int random; 
        random = (int)(Math.random()* 5); 
        String realWord = words[random]; 
        int lives = 3; 
        int scores = 0; 
        String currentWord = "______"; 
        String currentGuess = ""; 
        String playAgain = "y"; 
        String y = "y"; 
        boolean guessedCorrectly; 

        // game starts here 
        while(playAgain.equals("y")) {
            System.out.println("Welcome to Hangman");
            while(lives > 0 && !(currentWord.equals(realWord))){
                System.out.println("The word for this round is: " + currentWord); 
                
                // asking the user to take a guess 
                currentGuess = ""; 
                while (!(currentGuess.length() == 1 && Character.isLetter(currentGuess.charAt(0)))) {
                    System.out.println("Take a guess");
                    currentGuess = scnr.nextLine();
                }
                currentGuess = currentGuess.toLowerCase(); 

                guessedCorrectly = false; 
                
                // updates currrentWord with the guesses the user entered
                for(int i = 0; i < 6; i++){
                    // updates the first letter of currentWord 
                    if(i == 0) {
                        if(currentGuess.equals(realWord.substring(0,1)) && !(currentGuess.equals(currentWord.substring(0,1)))) {
                            guessedCorrectly = true;
                            currentWord = realWord.substring(0,1) + currentWord.substring(1,6); 
                        }
                    }
                // updates the last letter of currentWord 
                    else if (i == 5) {
                        if(currentGuess.equals(realWord.substring(5,6)) && !(currentGuess.equals(currentWord.substring(5,6)))) {
                            guessedCorrectly = true;
                            currentWord = currentWord.substring(0,5) + realWord.substring(5,6); 
                        }
                    }
                    // updates the letters of the general cases of currentWord 
                    else {
                        if(currentGuess.equals(realWord.substring(i, i + 1)) && !(currentGuess.equals(currentWord.substring(i,i + 1)))) { 
                            guessedCorrectly = true;
                            currentWord = currentWord.substring(0,i) + realWord.substring(i,i + 1) + currentWord.substring(i + 1,6);   
                        }
                    }

                }
                // if guessedCorrectly was false it would print "incorrect guess" and updates lives and prints out the number of lives 
                if (guessedCorrectly == false) {
                    System.out.println("Incorrect guess!"); 
                    lives--; 
                    scores--;
                    System.out.println("Current score: " + scores); 
                    System.out.println("You have " + lives + " lives now!");
                }
                // if guessedCorrectly was true it would print "correct guess" and updates lives and prints out the number of lives 
                if (guessedCorrectly == true) {
                    lives++; 
                    scores++; 
                    System.out.println("Current score: " + scores); 
                    System.out.println("Correct guess! You have " + lives + " lives now!");
                }
            }
            // ends game and prints out the realWord if lives = 0 else prints out a winning statment
            if(lives == 0) {
                System.out.println("GAME OVER! YOU LOST"); 
                System.out.println("Final score: " + scores); 
                System.out.println("The correct answer is " + realWord); 
            }
            else {
                System.out.println("GAME OVER! YOU WON!"); 
                System.out.println("Final score: " + scores); 
                System.out.println("You correctly guessed " + realWord); 
            }
            
            // asks the player if they want to play again. 
            System.out.println("Do you want to play again y/n?"); 
            playAgain = scnr.next(); 
            playAgain = playAgain.toLowerCase(); 

            if(playAgain.equals(y)){
                random = (int)(Math.random()* 5); 
                realWord = words[random]; 
                lives = 3; 
                scores = 0; 
                currentWord = "______"; 
                currentGuess = ""; 
                playAgain = "y"; 
                guessedCorrectly = false; 
                continue; 
            }
            else {
                break; 
            }
         }
         scnr.close();
        }
        }
