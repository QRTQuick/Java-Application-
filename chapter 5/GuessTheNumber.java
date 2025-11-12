import java.util.Scanner;
import java.security.SecureRandom;

public class GuessTheNumber{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        SecureRandom random = new SecureRandom();
        String playAgain;

        do {
            int numberToGuess = 1 + random.nextInt(1000);
            int guess;

            System.out.println("Guess a number between 1 and 1000.");

            do {
                System.out.print("Enter your guess: ");
                guess = input.nextInt();

                if (guess < numberToGuess) {
                    System.out.println("Too low. Try again.");
                } else if (guess > numberToGuess) {
                    System.out.println("Too high. Try again.");
                } else {
                    System.out.println("Congratulations. You guessed the number!");
                }
            } while (guess != numberToGuess);

            System.out.print("Play again? (yes/no): ");
            playAgain = input.next();
        } while (playAgain.equalsIgnoreCase("yes"));
    }
}