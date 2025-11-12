import java.security.SecureRandom;
import java.util.Scanner;

public class CAIVariedResponses{
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
                displayIncorrectResponse();
                userAnswer = input.nextInt();
            }
            
            displayCorrectResponse();
        }
    }
    
    public static void displayCorrectResponse() {
        int response = 1 + random.nextInt(4);
        switch (response) {
            case 1: System.out.println("Very good!"); break;
            case 2: System.out.println("Excellent!"); break;
            case 3: System.out.println("Nice work!"); break;
            case 4: System.out.println("Keep up the good work!"); break;
        }
    }
    
    public static void displayIncorrectResponse() {
        int response = 1 + random.nextInt(4);
        switch (response) {
            case 1: System.out.print("No. Please try again: "); break;
            case 2: System.out.print("Wrong. Try once more: "); break;
            case 3: System.out.print("Don't give up! No: "); break;
            case 4: System.out.print("Keep trying: "); break;
        }
    }
}