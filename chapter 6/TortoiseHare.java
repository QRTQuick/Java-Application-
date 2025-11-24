import java.util.Random;

/**
 * Simulates the classic race between the Tortoise and the Hare using 
 * probability-based movement rules.
 */
public class TortoiseHareRace {

    private static final int RACE_LENGTH = 70;
    private static final int START_POSITION = 1;
    private static final Random random = new Random();

    /**
     * Main simulation method.
     */
    public static void main(String[] args) {
        // Initialize positions
        int tortoisePosition = START_POSITION;
        int harePosition = START_POSITION;
        int tick = 0;

        // Start the Race
        System.out.println("BANG !!!!!");
        System.out.println("AND THEY'RE OFF !!!!!\n");

        // The race loop continues until one or both reach the finish line
        while (tortoisePosition < RACE_LENGTH && harePosition < RACE_LENGTH) {
            tick++;
            System.out.println("--- Tick " + tick + " ---");

            // 1. Move the animals
            tortoisePosition = moveTortoise(tortoisePosition);
            harePosition = moveHare(harePosition);

            // 2. Print the track
            printTrack(tortoisePosition, harePosition);
            
            // Wait a moment for better viewing (optional, but helpful for simulation)
            try {
                Thread.sleep(100); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // 3. Determine the winner
        System.out.println("\n--- RACE COMPLETE ---");
        determineWinner(tortoisePosition, harePosition);
    }

    /**
     * Calculates the tortoise's new position based on the rules.
     * @param currentPos The tortoise's current position (1-70).
     * @return The tortoise's new position (minimum 1).
     */
    private static int moveTortoise(int currentPos) {
        int i = random.nextInt(10) + 1; // Random integer 1 to 10
        int move = 0; // squares to move

        // Rules from Fig. 6.25:
        if (i >= 1 && i <= 5) { // 50% Fast plod
            move = 3;
        } else if (i >= 6 && i <= 7) { // 20% Slip
            move = -6;
        } else { // i >= 8 && i <= 10, 30% Slow plod
            move = 1;
        }

        int newPos = currentPos + move;
        
        // If an animal slips left before square 1, move it back to square 1.
        return Math.max(newPos, START_POSITION);
    }

    /**
     * Calculates the hare's new position based on the rules.
     * @param currentPos The hare's current position (1-70).
     * @return The hare's new position (minimum 1).
     */
    private static int moveHare(int currentPos) {
        int i = random.nextInt(10) + 1; // Random integer 1 to 10
        int move = 0; // squares to move

        // Rules from Fig. 6.25:
        if (i >= 1 && i <= 2) { // 20% Sleep
            move = 0;
        } else if (i >= 3 && i <= 4) { // 20% Big hop
            move = 9;
        } else if (i == 5) { // 10% Big slip
            move = -12;
        } else if (i >= 6 && i <= 8) { // 30% Small hop
            move = 1;
        } else { // i >= 9 && i <= 10, 20% Small slip
            move = -2;
        }

        int newPos = currentPos + move;
        
        // If an animal slips left before square 1, move it back to square 1.
        return Math.max(newPos, START_POSITION);
    }

    /**
     * Displays the 70-position line representing the race track.
     * @param tPos Tortoise position (1-70+).
     * @param hPos Hare position (1-70+).
     */
    private static void printTrack(int tPos, int hPos) {
        // Create a track array (size 70, index 0 is position 1)
        char[] track = new char[RACE_LENGTH];
        java.util.Arrays.fill(track, ' '); 
        
        // Adjust positions to be 0-indexed for the array
        int tIndex = tPos - 1;
        int hIndex = hPos - 1;

        // Check for tie (The tortoise bites the hare)
        if (tIndex == hIndex && tIndex >= 0 && tIndex < RACE_LENGTH) {
            // Display OUCH!!! starting at the tied position.
            String ouch = "OUCH!!!";
            for (int k = 0; k < ouch.length() && (tIndex + k) < RACE_LENGTH; k++) {
                track[tIndex + k] = ouch.charAt(k);
            }
        } else {
            // Place Hare (H) if within bounds and not already placed by OUCH!!!
            if (hIndex >= 0 && hIndex < RACE_LENGTH) {
                track[hIndex] = 'H';
            }
            // Place Tortoise (T) if within bounds and not already placed by OUCH!!!
            if (tIndex >= 0 && tIndex < RACE_LENGTH) {
                // If they land on the same spot, we favor the "OUCH!!!" message, 
                // but if we are not in a tie, we ensure 'T' is printed.
                track[tIndex] = 'T'; 
            }
        }
        
        // Print the track and the finish line
        System.out.print("|" + new String(track) + "| FINISH\n");
    }

    /**
     * Determines and prints the winner of the race.
     * @param tPos Tortoise position (1-70+).
     * @param hPos Hare position (1-70+).
     */
    private static void determineWinner(int tPos, int hPos) {
        boolean tortoiseWon = tPos >= RACE_LENGTH;
        boolean hareWon = hPos >= RACE_LENGTH;

        if (tortoiseWon && hareWon) {
            // If both win on the same tick, favor the tortoise ("underdog")
            // as is common in simulation lore, or declare a tie.
            // Following the spirit of the prompt's suggestion to favor the underdog:
            System.out.println("It's a tie, but the underdog prevails!");
            System.out.println("TORTOISE WINS!!! YAY!!!");
        } else if (tortoiseWon) {
            System.out.println("TORTOISE WINS!!! YAY!!!");
        } else if (hareWon) {
            System.out.println("Hare wins. Yuch.");
        }
        // If the loop terminated without anyone passing 70 (e.g., error), we handle it here.
    }
}