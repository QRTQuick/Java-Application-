import java.util.Scanner;

public class SwitchCaseStatement{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		int mark;
		String fullName;
		
		System.out.print("Enter your full name: ");
		fullName = input.nextLine();
		
		System.out.print("Enter your mark: ");
		mark = input.nextInt();
		
		switch(mark/10){
			case 0:
			case 1:
			case 2:
			case 3:
				System.out.printf("%s ->%d -> F%n",fullName, mark);
				break;
			case 4:
				System.out.printf("%s ->%d -> E%n",fullName, mark);
				break;
			case 5:
				System.out.printf("%s ->%d -> D%n",fullName, mark);
				break;
			case 6:
				System.out.printf("%s ->%d -> C%n",fullName, mark);
				break;
			case 7:
				System.out.printf("%s ->%d -> B%n",fullName, mark);
				break;
			case 8:
			case 9:
			case 10:
				System.out.printf("%s ->%d -> A%n",fullName, mark);
				break;
			default:
				System.out.println("invalid input");
		}
	}
}