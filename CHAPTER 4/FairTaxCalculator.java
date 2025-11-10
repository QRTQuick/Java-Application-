import java.util.Scanner;  // Import the Scanner class for reading user input

public class FairTaxCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);  // Create a Scanner object for input
        
        // List of spending categories to collect user expenses
        String[] categories = {
            "housing", "food", "clothing", "transportation",
            "education", "health care", "vacations"
        };
        
        double totalExpenses = 0;  // Variable to store total annual expenses
        
        System.out.println("FairTax Calculator");
        System.out.println("Enter your annual expenses in each category:\n");
        
        // Loop through each category and ask the user for their annual expenses
        for (String category : categories) {
            System.out.printf("Enter %s expenses: $", category);
            double expense = input.nextDouble();  // Read expense for this category
            totalExpenses += expense;             // Add to total expenses
        }
        
        // Calculate FairTax as 23% of total annual expenses
        double fairTax = totalExpenses * 0.23;
        
        // Compute the equivalent income tax rate for reference
        double equivalentRate = 0.23 / (1 - 0.23) * 100;
        
        // Display results with two decimal precision
        System.out.printf("%nTotal expenses: $%.2f%n", totalExpenses);
        System.out.printf("Estimated FairTax (23%%): $%.2f%n", fairTax);
        System.out.printf("Note: This is equivalent to a %.1f%% income tax rate%n", equivalentRate);
    }
}