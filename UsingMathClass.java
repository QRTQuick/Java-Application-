import java.util.Scanner;

public class UsingMathClass{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);	
		System.out.println("Input number");
		
		int num1 = input.nextInt();
		int num2 = input.nextInt();
		
		System.out.println(Math.abs(num1));
		System.out.println(Math.abs(num2));
		System.out.println(Math.max(num1,num2));
		System.out.println(Math.min(num1,num2));
		System.out.println((int)Math.sqrt(num1));
		System.out.println((int)Math.pow(num1,2));
		System.out.println(Math.random());
	}
}