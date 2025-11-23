import java.util.Scanner;

public class AirlineReservationSystem {

    private static final boolean[] seats = new boolean[10]; // all initialized to false

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\nPlease type 1 for First Class.");
            System.out.println("Please type 2 for Economy.");
            System.out.print("Your choice: ");

            int choice = input.nextInt();

            if (choice == 1) {
                assignFirstClass(input);
            } else if (choice == 2) {
                assignEconomy(input);
            } else {
                System.out.println("Invalid choice, try again.");
            }
        }
    }

    // ------------------ FIRST CLASS SECTION (Seats 1–5) ------------------

    private static void assignFirstClass(Scanner input) {
        int seatNumber = findAvailableSeat(0, 4);

        if (seatNumber != -1) {
            seats[seatNumber] = true;
            printBoardingPass(seatNumber + 1, "First Class");
        } else {
            // First class is full → offer Economy
            System.out.println("First Class is full. Would you like to book an Economy seat? (yes/no)");
            String reply = input.next();

            if (reply.equalsIgnoreCase("yes")) {
                assignEconomy(input);
            } else {
                System.out.println("Next flight leaves in 3 hours.");
            }
        }
    }

    // ------------------ ECONOMY SECTION (Seats 6–10) ------------------

    private static void assignEconomy(Scanner input) {
        int seatNumber = findAvailableSeat(5, 9);

        if (seatNumber != -1) {
            seats[seatNumber] = true;
            printBoardingPass(seatNumber + 1, "Economy");
        } else {
            // Economy full → offer First Class
            System.out.println("Economy is full. Would you like to book a First Class seat? (yes/no)");
            String reply = input.next();

            if (reply.equalsIgnoreCase("yes")) {
                assignFirstClass(input);
            } else {
                System.out.println("Next flight leaves in 3 hours.");
            }
        }
    }

    // ---------------------------------------------------------------------

    // Finds the first empty seat in a range. Returns -1 if none available.
    private static int findAvailableSeat(int start, int end) {
        for (int i = start; i <= end; i++) {
            if (!seats[i]) {
                return i;
            }
        }
        return -1; // none available
    }

    private static void printBoardingPass(int seatNumber, String section) {
        System.out.println("\n******** BOARDING PASS ********");
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Section:     " + section);
        System.out.println("********************************\n");
    }
}
