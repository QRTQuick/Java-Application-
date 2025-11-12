import java.security.SecureRandom;
import java.util.Scanner;

public class CrapsWithWagering{
    private static final SecureRandom random = new SecureRandom();
    private static int bankBalance = 1000;

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        while (bankBalance > 0){
            System.out.printf("Bank balance: $%d%n", bankBalance);
            System.out.print("Enter wager: ");
            int wager = input.nextInt();

            while (wager > bankBalance || wager <= 0){
                System.out.print("Invalid wager. Enter wager: ");
                wager = input.nextInt();
            }

            chatter();
            playCraps(wager);

            if (bankBalance == 0) {
                System.out.println("Sorry. You busted!");
            }
        }
    }

    public static void playCraps(int wager) {
        int point = 0;
        int sumOfDice = rollDice();

        switch (sumOfDice) {
            case 7: case 11:
                System.out.println("You win!");
                bankBalance += wager;
                break;
            case 2: case 3: case 12:
                System.out.println("You lose!");
                bankBalance -= wager;
                break;
            default:
                point = sumOfDice;
                System.out.printf("Point is %d%n", point);
                break;
        }

        if (point != 0) {
            sumOfDice = rollDice();
            while (sumOfDice != 7 && sumOfDice != point) {
                sumOfDice = rollDice();
            }

            if (sumOfDice == point) {
                System.out.println("You win!");
                bankBalance += wager;
            } else {
                System.out.println("You lose!");
                bankBalance -= wager;
            }
        }
    }

    public static int rollDice() {
        int die1 = 1 + random.nextInt(6);
        int die2 = 1 + random.nextInt(6);
        int sum = die1 + die2;
        System.out.printf("Player rolled %d + %d = %d%n", die1, die2, sum);
        return sum;
    }

    public static void chatter() {
        String[] messages = {
            "Oh, you're going for broke, huh?",
            "Aw c'mon, take a chance!",
            "You're up big. Now's the time to cash in your chips!"
        };
        int index = random.nextInt(messages.length);
        System.out.println(messages[index]);
    }
}