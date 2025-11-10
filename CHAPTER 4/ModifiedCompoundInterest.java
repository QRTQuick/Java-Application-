// A program to calculate compound interest for different interest rates 
public class ModifiedCompoundInterest {
    public static void main(String[] args) {
        // Initial amount added 
        double principal = 1000.0;
        
        // Number of years the money is invested
        int years = 10;
        
        // Print the column headers
        System.out.printf("%s%20s%n", "Interest Rate", "Amount on Deposit");
        
        // Loop through interest rates from 5% to 10%
        for (int rate = 5; rate <= 10; rate++) {
            // Convert integer rate (like 5) to decimal form (0.05)
            double currentRate = rate / 100.0;
            
            // Calculate compound interest using the formula: A = P * (1 + r)^t
            double amount = principal * Math.pow(1.0 + currentRate, years);
            
            // Display the interest rate and the corresponding amount after 10 years
            System.out.printf("%d%%%20.2f%n", rate, amount);
        }
    }
}