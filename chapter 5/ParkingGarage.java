import java.util.Scanner;

public class ParkingGarage{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        double totalReceipts = 0.0;
        double hours;

        System.out.print("Enter hours parked (or -1 to quit): ");
        hours = input.nextDouble();

        while (hours != -1){
            double charge = calculateCharges(hours);
            totalReceipts += charge;
            System.out.printf("Current charge: $%.2f, Total receipts: $%.2f%n", charge, totalReceipts);
            System.out.print("Enter hours parked (or -1 to quit): ");
            hours = input.nextDouble();
        }
    }

    public static double calculateCharges(double hours){
        double minFee = 2.00;
        double maxCharge = 10.00;
        double extraRate = 0.50;
        int maxIncludedHours = 3;

        if (hours <= maxIncludedHours){
            return minFee;
        } else{
            double charge = minFee + Math.ceil(hours - maxIncludedHours) * extraRate;
            return Math.min(charge, maxCharge);
        }
    }
}