import java.util.Random;

public class DiceRolling {

    public static void main(String[] args) {

        Random random = new Random();

        // Index 0 and 1 unused. Index 2–12 used for sums.
        int[] frequency = new int[13];

        // Roll dice 36 million times
        for (int i = 0; i < 36_000_000; i++) {
            int die1 = 1 + random.nextInt(6);  // 1–6
            int die2 = 1 + random.nextInt(6);  // 1–6

            int sum = die1 + die2;             // 2–12
            frequency[sum]++;                  // count how many times each sum occurs
        }

        // Display results
        System.out.println("Sum\tFrequency");
        for (int sum = 2; sum <= 12; sum++) {
            System.out.printf("%d\t%,d%n", sum, frequency[sum]);
        }
    }
}
