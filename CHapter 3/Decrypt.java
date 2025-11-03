import java.util.Scanner;

public class Decrypt {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the encrypted 4-digit integer: ");
        int number = input.nextInt();

        // Extract each digit
        int d1 = number / 1000;
        int d2 = (number / 100) % 10;
        int d3 = (number / 10) % 10;
        int d4 = number % 10;

        // Swap back (reverse of encryption)
        int temp = d1; d1 = d3; d3 = temp;
        temp = d2; d2 = d4; d4 = temp;

        // Reverse encryption
        d1 = (d1 + 10 - 7) % 10;
        d2 = (d2 + 10 - 7) % 10;
        d3 = (d3 + 10 - 7) % 10;
        d4 = (d4 + 10 - 7) % 10;

        int decryptedNumber = d1 * 1000 + d2 * 100 + d3 * 10 + d4;
        System.out.println("Decrypted number: " + decryptedNumber);
    }
}
