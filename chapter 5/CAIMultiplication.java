import java.security.SecureRandom;
import java.util.Scanner;

public class CAIMultiplication{
    private static final SecureRandom random = new SecureRandom();

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        while (true){
            int num1 = 1 + random.nextInt(9);
            int num2 = 1 + random.nextInt(9);
            int correctAnswer = num1 * num2;
            
            System.out.printf("How much is %d times %d? ", num1, num2);
            int userAnswer = input.nextInt();
            
            while (userAnswer != correctAnswer) {
                System.out.print("No. Please try again: ");
                userAnswer = input.nextInt();
            }
            
            System.out.println("Very good!");
        }
    }
}