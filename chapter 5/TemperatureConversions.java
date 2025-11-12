import java.util.Scanner;

public class TemperatureConversions{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter 1 for F->C, 2 for C->F: ");
        int choice = input.nextInt();

        if (choice == 1){
            System.out.print("Enter Fahrenheit temperature: ");
            double fahrenheit = input.nextDouble();
            System.out.printf("Celsius: %.2f%n", celsius(fahrenheit));
        } else if (choice == 2){
            System.out.print("Enter Celsius temperature: ");
            double celsius = input.nextDouble();
            System.out.printf("Fahrenheit: %.2f%n", fahrenheit(celsius));
        } else{
            System.out.println("Invalid choice");
        }
    }

    public static double celsius(double fahrenheit){
        return 5.0 / 9.0 * (fahrenheit - 32);
    }

    public static double fahrenheit(double celsius){
        return 9.0 / 5.0 * celsius + 32;
    }
}