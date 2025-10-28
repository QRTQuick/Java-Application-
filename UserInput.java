import java.util.Scanner;

public class UserInput{
	public static void main(String[] argrs){
		Scanner input = new Scanner(System.in);
		double bal = 5678.98;
		System.out.print("Enter your name: ");
		String firstName = input.nextLine();
		//System.out.printf("Hello %s",firstName);
		
		System.out.print("Enter lastname: ");
		String lastName = input.nextLine();
		
		System.out.print("Enter your age: ");
		//byte age = input.nextByte();
		short age = input.nextShort();
		// next.charAt(0) : READS a word from the user and returns the firts character of that word 
		System.out.printf("Welcome %s %s to fistbank %n",firstName,lastName);
		System.out.printf("You are %d year old %n",age);
		System.out.printf("Your account balance is $%.2f%n",bal);
		//input.close();
	}
}