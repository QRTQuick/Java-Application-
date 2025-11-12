import java.util.Scanner;

public class DistanceBetweenPoints{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter x1 y1 x2 y2: ");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();

        System.out.printf("Distance: %.2f%n", distance(x1, y1, x2, y2));
    }

    public static double distance(double x1, double y1, double x2, double y2){
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}