package exercises.game;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void playGame(Scanner scanner) {
        Random random = new Random();
        int target = random.nextInt(100) + 1;
        int attempts = 0;
        int guess;
        
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 100.");
        
        do {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            attempts++;
            
            if (guess < target) {
                System.out.println("Too low! Try again.");
            } else if (guess > target) {
                System.out.println("Too high! Try again.");
            }
        } while (guess != target);
        
        System.out.println("Congratulations! You found the number in " + attempts + " attempts!");
    }
}
