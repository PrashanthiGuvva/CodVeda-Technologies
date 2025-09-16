package in.codveda;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1;
        int attempts = 0;
        int maxAttempts = 7; // Limit number of attempts
        boolean hasGuessed = false;
        System.out.println("🎮 Welcome to the Number Guessing Game!");
        System.out.println("Guess a number between 1 and 100. You have " + maxAttempts + " attempts.");
        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            // Handle invalid input
            if (!scanner.hasNextInt()) {
                System.out.println("❌ Invalid input! Please enter a valid number.");
                scanner.next(); // clear invalid input
                continue;
            }

            int guess = scanner.nextInt();
            attempts++;

            if (guess == numberToGuess) {
                System.out.println("✅ Congratulations! You guessed the number in " + attempts + " attempts.");
                hasGuessed = true;
                break;
            } else if (guess < numberToGuess) {
                System.out.println("📉 Too low! Try again.");
            } else {
                System.out.println("📈 Too high! Try again.");
            }

            System.out.println("Attempts left: " + (maxAttempts - attempts));
        }

        if (!hasGuessed) {
            System.out.println("😢 Sorry, you've used all attempts. The correct number was: " + numberToGuess);
        }

        scanner.close();
    }
}
