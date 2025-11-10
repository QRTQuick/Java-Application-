import java.util.Scanner;

public class UserInput{
	public static void main(String[] args){
		double bal= 402234;
		
		Scanner input = new Scanner (System.in);
		System.out.print("Enter your firstname: ");
		
		String firstName = input.nextLine();
				
		System.out.print("Enter your lastname: ");
		
		String lastName = input.nextLine();
		
		System.out.print("Enter your age: ");
		
		short age = input.nextShort();
		System.out.printf("Hello, %s %s of %d years of age.%nYou have $%.2f in your account%n",firstName,lastName,age,bal);
	}
}