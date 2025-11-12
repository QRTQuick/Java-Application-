import java.util.Scanner;

public class SquareOfAnyCharacter{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter side length: ");
        int side = input.nextInt();
        System.out.print("Enter fill character: ");
        char fillCharacter = input.next().charAt(0);

        squareOfAsterisks(side, fillCharacter);
    }

    public static void squareOfAsterisks(int side, char fillCharacter){
        for (int row = 1; row <= side; row++){
            for (int col = 1; col <= side; col++){
                System.out.print(fillCharacter);
            }
            System.out.println();
        }
    }
}