import java.util.Scanner;

public class Rounding{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        double x;

        System.out.print("Enter a double value (or -1 to quit): ");
        x = input.nextDouble();

        while (x != -1){
            double y = Math.floor(x + 0.5);
            System.out.printf("Original: %.2f, Rounded: %.0f%n", x, y);
            System.out.print("Enter a double value (or -1 to quit): ");
            x = input.nextDouble();
        }
    }
}