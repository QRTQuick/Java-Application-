import java.util.Scanner;

public class PollingProgram {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // 5 topics of your choice
        String[] topics = {
                "Climate Change",
                "Education Funding",
                "Healthcare Access",
                "Animal Welfare",
                "Cyber Security"
        };

        // 5 rows (topics), 10 columns (ratings 1–10)
        int[][] responses = new int[5][10];

        System.out.println("Welcome to the Social Awareness Polling Program!");

        String another = "yes";

        // Allow multiple people to rate
        while (another.equalsIgnoreCase("yes")) {

            System.out.println("\nPlease rate each topic from 1 (least important) to 10 (most important):");

            for (int i = 0; i < topics.length; i++) {
                int rating;

                while (true) {
                    System.out.print("Rate \"" + topics[i] + "\": ");
                    rating = input.nextInt();

                    if (rating >= 1 && rating <= 10) {
                        break;
                    } else {
                        System.out.println("Invalid rating! Enter a number from 1 to 10.");
                    }
                }

                // Store rating
                responses[i][rating - 1]++;
            }

            System.out.print("\nWould another person like to answer? (yes/no): ");
            another = input.next();
        }

        // ============================
        // PART (a): Tabular Report
        // ============================
        System.out.println("\n\n================= POLLING SUMMARY =================");

        // Header row
        System.out.printf("%-20s", "Topic");
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%4d", i);
        }
        System.out.printf("%12s", "Average");
        System.out.println();

        // Track totals to find highest/lowest
        int highestTotal = -1;
        int lowestTotal = Integer.MAX_VALUE;
        String highestTopic = "";
        String lowestTopic = "";

        // ============================
        // PART (b): Average + Table
        // ============================
        for (int i = 0; i < topics.length; i++) {

            int totalPoints = 0;     // total score for the topic
            int totalResponses = 0;  // number of ratings received

            System.out.printf("%-20s", topics[i]);

            for (int j = 0; j < 10; j++) {
                System.out.printf("%4d", responses[i][j]);

                int ratingValue = j + 1;
                int count = responses[i][j];

                totalPoints += ratingValue * count;
                totalResponses += count;
            }

            double average = (totalResponses > 0)
                    ? (double) totalPoints / totalResponses
                    : 0.0;

            System.out.printf("%12.2f", average);
            System.out.println();

            // Track highest total
            if (totalPoints > highestTotal) {
                highestTotal = totalPoints;
                highestTopic = topics[i];
            }

            // Track lowest total
            if (totalPoints < lowestTotal) {
                lowestTotal = totalPoints;
                lowestTopic = topics[i];
            }
        }

        // ============================
        // PART (c): Highest Score
        // ============================
        System.out.println("\nHighest total points:");
        System.out.println(highestTopic + " — " + highestTotal + " points");

        // ============================
        // PART (d): Lowest Score
        // ============================
        System.out.println("\nLowest total points:");
        System.out.println(lowestTopic + " — " + lowestTotal + " points");

        System.out.println("\n=====================================================");
    }
}
