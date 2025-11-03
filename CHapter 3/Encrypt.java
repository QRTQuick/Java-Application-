import java.util.Scanner;

public class Encrypt {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a 4-digit integer to encrypt: ");
        int number = input.nextInt();

        // Extract each digit
        int d1 = number / 1000;
        int d2 = (number / 100) % 10;
        int d3 = (number / 10) % 10;
        int d4 = number % 10;

        // Encrypt each digit
        d1 = (d1 + 7) % 10;
        d2 = (d2 + 7) % 10;
        d3 = (d3 + 7) % 10;
        d4 = (d4 + 7) % 10;

        // Swap first ↔ third, second ↔ fourth
        int temp = d1; d1 = d3; d3 = temp;
        temp = d2; d2 = d4; d4 = temp;

        int encryptedNumber = d1 * 1000 + d2 * 100 + d3 * 10 + d4;
        System.out.println("Encrypted number: " + encryptedNumber);
    }
}
