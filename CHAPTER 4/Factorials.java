public class Factorials {
    public static void main(String[] args) {
        // Print the table header: 'n' and 'n!'
        System.out.printf("%-5s%-20s%n", "n", "n!");
        System.out.println("-------------------");
        
        // Loop through numbers 1 to 20
        for (int n = 1; n <= 20; n++) {
            long factorial = 1;  // Variable to store factorial result
            
            // Inner loop to calculate n! (factorial of n)
            for (int i = 1; i <= n; i++) {
                factorial *= i;  // Multiply by each number from 1 to n
            }
            
            // Display the number and its factorial using formatted output
            System.out.printf("%-5d%-20d%n", n, factorial);
        }
        
        // Explain why calculating 100! directly in Java using long is impractical
        System.out.println("\nDifficulty for calculating 100!: ");
        System.out.println("The factorial of 100 is extremely large (approximately 9.33×10^157)");
        System.out.println("which exceeds the maximum value of long type in Java.");
    }
}