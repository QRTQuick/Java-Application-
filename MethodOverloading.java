import java.util.Scanner;

public class MethodOverloading {

    // this method Finds perimeter of a square 
    public static void perimeter(int length) {
        length *= 4;
        System.out.println("\nPerimeter = " + length);
    }

    //  this method Finds perimeter of a rectangle
    public static void perimeter(int length, int height) {
        length *= 2;
        height *= 2;
        System.out.println("\nPerimeter = " + (length + height));
    }

    //  this method Finds perimeter of a triangle
    public static void perimeter(double base, int height) {
        height *= 2;
        System.out.println("\nPerimeter = " + (base + height));
    }
// main menthod 
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        char choice;

        do {
            // Show menu for user instrutions 
            System.out.println("\n=== MENSURATION ===");
            System.out.println("1. Square");
            System.out.println("2. Rectangle");
            System.out.println("3. Triangle");
            System.out.println("4. Exit");
            System.out.print("Enter your option (1-4): ");
            int option = input.nextInt();

            switch (option) {
                case 1:
                    // Square case
                    System.out.print("Enter Length: ");
                    int length = input.nextInt();
                    perimeter(length);
                    break;

                case 2:
                    // Rectangle case
                    System.out.print("Enter Length: ");
                    length = input.nextInt();
                    System.out.print("Enter Height: ");
                    int height = input.nextInt();
                    perimeter(length, height);
                    break;

                case 3:
                    // Triangle case 
                    System.out.print("Enter Base: ");
                    double base = input.nextDouble();
                    System.out.print("Enter Height: ");
                    height = input.nextInt();
                    perimeter(base, height);
                    break;

                case 4:
                    // Exit user from the code loop
                    System.out.println("Goodbye!");
                    input.close();
                    return;

                default:
                    // tell the user Invalid option
                    System.out.println("Invalid input, try again.");
            }

            // Ask the user to repeat
            System.out.print("\nRun again? (y/n): ");
            choice = input.next().charAt(0);

        } while (choice == 'y' || choice == 'Y');

        System.out.println("Program Ended.");
        input.close();
    }
}