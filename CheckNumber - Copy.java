import java.util.Scanner;

public class CheckNumber {
    public static void main(String[] args) {
		//prepare for input in take 
        Scanner sc = new Scanner(System.in);

        int positive = 0;
        int negative = 0;
        int zero = 0;
		// start while loop 
        while (true) {
            System.out.print("Enter a number (type -1 to stop): ");
            int num = sc.nextInt();

            if (num == -1) {
                System.out.println("Program ended.");
                break;
            }

            if (num > 0) {
                System.out.println("Positive number");
                positive++;
            } else if (num < 0) {
                System.out.println("Negative number");
                negative++;
            } else {
                System.out.println("Zero");
                zero++;
            }
        }
		// print result 
        System.out.println();
        System.out.println("Total positive numbers: " + positive);
        System.out.println("Total negative numbers: " + negative);
        System.out.println("Total zeros: " + zero);
    }
}