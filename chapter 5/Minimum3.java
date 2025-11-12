import java.util.Scanner;

public class Minimum3{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter three floating-point numbers: ");
        double num1 = input.nextDouble();
        double num2 = input.nextDouble();
        double num3 = input.nextDouble();

        System.out.printf("Minimum: %.2f%n", minimum3(num1, num2, num3));
    }

    public static double minimum3(double a, double b, double c){
        return Math.min(a, Math.min(b, c));
    }
}