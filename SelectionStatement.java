public class SelectionStatement{
	public static void main(String[] argrs){
		int age = 18;
		
		//Single selection statement
		if(age >= 18){
			System.out.println("Wow, you're an Adult");
			System.out.println("Being an Adult is fun");
		}
		
		//Double selection statement
		int num1 = 5;
		int num2 = 25;
		
		if(num1 > num2)
			System.out.printf("%d is greater than %d%n",num1,num2);
		
		else
			System.out.printf("%d is greater than %d%n",num2,num1);
	}
}