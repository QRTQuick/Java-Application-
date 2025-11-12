import java.util.Scanner;

public class QualityPoints{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter student's average: ");
        int average = input.nextInt();

        System.out.printf("Quality points: %d%n", qualityPoints(average));
    }

    public static int qualityPoints(int average){
        if (average >= 90) return 4;
        else if (average >= 80) return 3;
        else if (average >= 70) return 2;
        else if (average >= 60) return 1;
        else return 0;
    }
}