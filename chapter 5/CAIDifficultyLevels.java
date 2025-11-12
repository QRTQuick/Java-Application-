import java.security.SecureRandom;
import java.util.Scanner;

public class CAIDifficultyLevels{
    private static final SecureRandom random = new SecureRandom();
    private static int correctCount = 0;
    private static int totalQuestions = 0;

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter difficulty level (1-4): ");
        int difficulty = input.nextInt();
        
        while (true){
            int num1 = generateNumber(difficulty);
            int num2 = generateNumber(difficulty);
            int correctAnswer = num1 * num2;
            
            System.out.printf("How much is %d times %d? ", num1, num2);
            int userAnswer = input.nextInt();
            
            if (userAnswer == correctAnswer) {
                displayCorrectResponse();
                correctCount++;
            } else {
                displayIncorrectResponse();
            }
            totalQuestions++;
            
            if (totalQuestions % 10 == 0) {
                double percentage = (double) correctCount / 10 * 100;
                System.out.printf("Score: %.0f%%%n", percentage);
                if (percentage < 75) {
                    System.out.println("Please ask your teacher for extra help.");
                } else {
                    System.out.println("Congratulations, you are ready to go to the next level!");
                }
                correctCount = 0;
                totalQuestions = 0;
                System.out.print("Start a new session? (yes/no): ");
                String response = input.next();
                if (response.equalsIgnoreCase("yes")) {
                    System.out.print("Enter difficulty level (1-4): ");
                    difficulty = input.nextInt();
                } else {
                    break;
                }
            }
        }
    }
    
    public static int generateNumber(int difficulty) {
        int max = (int) Math.pow(10, difficulty) - 1;
        return 1 + random.nextInt(max);
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
            case 1: System.out.println("No. Please try again."); break;
            case 2: System.out.println("Wrong. Try once more."); break;
            case 3: System.out.println("Don't give up! No."); break;
            case 4: System.out.println("Keep trying."); break;
        }
    }
}