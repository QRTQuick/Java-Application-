import java.util.Scanner;

public class EvenOdd{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int number;

        System.out.print("Enter an integer (or -1 to quit): ");
        number = input.nextInt();

        while (number != -1) {
            System.out.printf("%d is even: %b%n", number, isEven(number));
            System.out.print("Enter an integer (or -1 to quit): ");
            number = input.nextInt();
        }
    }

    public static boolean isEven(int number){
        return number % 2 == 0;
    }
}