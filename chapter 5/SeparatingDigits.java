import java.util.Scanner;

public class SeparatingDigits{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer between 1 and 99999: ");
        int number = input.nextInt();

        displayDigits(number);
    }

    public static int quotient(int a, int b){
        return a / b;
    }

    public static int remainder(int a, int b){
        return a % b;
    }

    public static void displayDigits(int number){
        if (number < 1 || number > 99999){
            System.out.println("Number must be between 1 and 99999");
            return;
        }

        String digits = "";
        int divisor = 10000;

        while (divisor >= 1){
            int digit = quotient(number, divisor);
            if (digit != 0 || divisor == 1){
                digits += digit + "  ";
            }
            number = remainder(number, divisor);
            divisor = quotient(divisor, 10);
        }
        System.out.println(digits);
    }
}