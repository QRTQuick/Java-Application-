import java.util.Scanner;

public class TotalSales {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 5 products (rows) × 4 salespeople (columns)
        double[][] sales = new double[5][4];

        System.out.println("Enter sales slips. Type -1 to stop.");

        while (true) {
            System.out.print("\nEnter salesperson number (1–4) or -1 to stop: ");
            int salesperson = input.nextInt();

            if (salesperson == -1) {
                break;
            }

            System.out.print("Enter product number (1–5): ");
            int product = input.nextInt();

            System.out.print("Enter total dollar value sold: ");
            double amount = input.nextDouble();

            // Store in array (convert to 0-based index)
            sales[product - 1][salesperson - 1] += amount;
        }

        // ---------------- DISPLAY TABLE ----------------

        System.out.println("\n\n\t\tSALES REPORT");
        System.out.println("Product\t  1\t\t  2\t\t  3\t\t  4\t\tRow Total");

        for (int product = 0; product < 5; product++) {
            System.out.printf("%d\t", (product + 1));
            double rowTotal = 0;

            for (int salesperson = 0; salesperson < 4; salesperson++) {
                System.out.printf("%10.2f", sales[product][salesperson]);
                rowTotal += sales[product][salesperson];
            }

            System.out.printf("%12.2f%n", rowTotal);
        }

        // Column totals
        System.out.print("\nCol Totals");

        for (int salesperson = 0; salesperson < 4; salesperson++) {
            double colTotal = 0;

            for (int product = 0; product < 5; product++) {
                colTotal += sales[product][salesperson];
            }

            System.out.printf("%10.2f", colTotal);
        }

        System.out.println(); // final new line
    }
}
