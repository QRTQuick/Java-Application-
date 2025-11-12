import java.util.Scanner;
import java.security.SecureRandom;

public class GuessTheNumberModified{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        SecureRandom random = new SecureRandom();
        String playAgain;

        do {
            int numberToGuess = 1 + random.nextInt(1000);
            int guess;
            int numberOfGuesses = 0;

            System.out.println("Guess a number between 1 and 1000.");

            do {
                System.out.print("Enter your guess: ");
                guess = input.nextInt();
                numberOfGuesses++;

                if (guess < numberToGuess) {
                    System.out.println("Too low. Try again.");
                } else if (guess > numberToGuess) {
                    System.out.println("Too high. Try again.");
                } else {
                    System.out.println("Congratulations. You guessed the number!");
                    
                    if (numberOfGuesses < 10) {
                        System.out.println("Either you know the secret or you got lucky!");
                    } else if (numberOfGuesses == 10) {
                        System.out.println("Aha! You know the secret!");
                    } else {
                        System.out.println("You should be able to do better!");
                    }
                }
            } while (guess != numberToGuess);

            System.out.print("Play again? (yes/no): ");
            playAgain = input.next();
        } while (playAgain.equalsIgnoreCase("yes"));
    }
}