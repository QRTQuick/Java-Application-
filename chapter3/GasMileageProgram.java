import java.util.Scanner;

public class GasMileageProgram {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int trip = 1;
        int totalTrips = 5;

        while (trip <= totalTrips) {
            System.out.print("Enter the number of miles driven: ");
            double miles = input.nextDouble();

            System.out.print("Enter the number of gallons used: ");
            double gallons = input.nextDouble();

            // Calculate miles per gallon
            double mpg = miles / gallons;

            System.out.printf("The MPG for trip %d was %.2f%n", trip, mpg);

            trip++; // increment trip
        }

        input.close();
    }
}
	
	
	 	
		
  