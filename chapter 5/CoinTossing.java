import java.util.Scanner;
import java.security.SecureRandom;

public class CoinTossing{
    private enum Coin { HEADS, TAILS }
    private static int headsCount = 0;
    private static int tailsCount = 0;
    private static final SecureRandom random = new SecureRandom();

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.print("Enter 1 to toss coin, 0 to quit: ");
            choice = input.nextInt();
            if (choice == 1) {
                Coin result = flip();
                if (result == Coin.HEADS) headsCount++;
                else tailsCount++;
                System.out.printf("Result: %s. Heads: %d, Tails: %d%n", result, headsCount, tailsCount);
            }
        } while (choice != 0);
    }

    public static Coin flip() {
        return random.nextBoolean() ? Coin.HEADS : Coin.TAILS;
    }
}