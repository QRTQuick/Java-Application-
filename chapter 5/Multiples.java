import java.util.Scanner;

public class Multiples{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int first, second;

        System.out.print("Enter two integers (or 0 0 to quit): ");
        first = input.nextInt();
        second = input.nextInt();

        while (first != 0 || second != 0){
            System.out.printf("%d is multiple of %d: %b%n", second, first, isMultiple(first, second));
            System.out.print("Enter two integers (or 0 0 to quit): ");
            first = input.nextInt();
            second = input.nextInt();
        }
    }

    public static boolean isMultiple(int first, int second){
        return second % first == 0;
    }
}