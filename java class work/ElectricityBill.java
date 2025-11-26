import java.util.Scanner;

// Enum for customer types
enum CustomerType {
    REGULAR,
    BUSINESS,
    VIP
}

public class ElectricityBill {

    // Static method to calculate bill
    public static double calculateBill(int units, CustomerType type) {

        double pricePerUnit;

        // Decide price based on units
        if (units <= 100) {
            pricePerUnit = 30;   // ₦30 per unit
        } else if (units <= 300) {
            pricePerUnit = 25;   // ₦25 per unit
        } else {
            pricePerUnit = 20;   // ₦20 per unit
        }

        // Total cost before discount
        double total = units * pricePerUnit;

        // Apply discount based on customer type
        if (type == CustomerType.BUSINESS) {
            total = total - (total * 0.05);   // 5% discount
        } else if (type == CustomerType.VIP) {
            total = total - (total * 0.10);   // 10% discount
        }

        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get user inputs
        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Units Consumed: ");
        int units = sc.nextInt();
        sc.nextLine(); // Clear buffer

        System.out.print("Enter Customer Type (REGULAR / BUSINESS / VIP): ");
        String typeInput = sc.nextLine().toUpperCase();

        CustomerType type = CustomerType.valueOf(typeInput);

        // Loop to show bill breakdown in blocks of 50 units
        System.out.println("\n--- BILL BREAKDOWN (Per 50 Units) ---");
        int remaining = units;

        for (int i = 1; remaining > 0; i++) {
            int block = Math.min(50, remaining);  // Use 50 or the remaining units
            System.out.println("Block " + i + ": " + block + " units");
            remaining -= block;
        }

        // Calculate final bill
        double finalBill = calculateBill(units, type);

        // Print final output
        System.out.println("\nCustomer Name: " + name);
        System.out.println("Customer Type: " + type);
        System.out.println("Units Consumed: " + units);
        System.out.println("Total Bill: ₦" + finalBill);
    }
}