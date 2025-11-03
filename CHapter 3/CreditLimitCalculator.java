import java.util.Scanner;

public class CreditLimitCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Ask how many customers to process
        System.out.print("Enter the number of customers: ");
        int numberOfCustomers = input.nextInt();

        // Process each customer
        for (int i = 1; i <= numberOfCustomers; i++) {
            System.out.println("\nCustomer " + i + " details:");

            System.out.print("Enter account number: ");
            int accountNumber = input.nextInt();

            System.out.print("Enter beginning balance: ");
            int beginningBalance = input.nextInt();

            System.out.print("Enter total charges this month: ");
            int totalCharges = input.nextInt();

            System.out.print("Enter total credits this month: ");
            int totalCredits = input.nextInt();

            System.out.print("Enter allowed credit limit: ");
            int creditLimit = input.nextInt();

            // Calculate new balance
            int newBalance = beginningBalance + totalCharges - totalCredits;

            // Display results
            System.out.println("\nAccount Number: " + accountNumber);
            System.out.println("New balance: " + newBalance);

            // Check if credit limit exceeded
            if (newBalance > creditLimit) {
                System.out.println("Credit limit exceeded!");
            } else {
                System.out.println("Within credit limit.");
            }
        }

        input.close();
    }
}
