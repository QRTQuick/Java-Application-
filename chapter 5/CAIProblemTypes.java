import java.security.SecureRandom;
import java.util.Scanner;

public class CAIProblemTypes{
    private static final SecureRandom random = new SecureRandom();
    private static int correctCount = 0;
    private static int totalQuestions = 0;

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter difficulty level (1-4): ");
        int difficulty = input.nextInt();
        System.out.print("Enter problem type (1:add, 2:sub, 3:mult, 4:div, 5:mix): ");
        int problemType = input.nextInt();
        
        while (true){
            if (generateQuestion(difficulty, problemType)) {
                correctCount++;
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
                    System.out.print("Enter problem type (1:add, 2:sub, 3:mult, 4:div, 5:mix): ");
                    problemType = input.nextInt();
                } else {
                    break;
                }
            }
        }
    }
    
    public static boolean generateQuestion(int difficulty, int problemType) {
        int num1 = generateNumber(difficulty);
        int num2 = generateNumber(difficulty);
        int operation;

        if (problemType == 5) {
            operation = 1 + random.nextInt(4);
        } else {
            operation = problemType;
        }

        int correctAnswer = 0;
        String operator = "";

        switch (operation) {
            case 1: // Addition
                correctAnswer = num1 + num2;
                operator = "plus";
                break;
            case 2: // Subtraction
                correctAnswer = num1 - num2;
                operator = "minus";
                break;
            case 3: // Multiplication
                correctAnswer = num1 * num2;
                operator = "times";
                break;
            case 4: // Division
                while (num2 == 0) {
                    num2 = generateNumber(difficulty);
                }
                num1 = num1 * num2; // Adjust so division is exact
                correctAnswer = num1 / num2;
                operator = "divided by";
                break;
        }

        System.out.printf("How much is %d %s %d? ", num1, operator, num2);
        Scanner input = new Scanner(System.in);
        int userAnswer = input.nextInt();

        if (userAnswer == correctAnswer) {
            displayCorrectResponse();
            return true;
        } else {
            displayIncorrectResponse();
            return false;
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