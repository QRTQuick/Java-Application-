public class OperatorPart2{
	public static void main(String[] argrs){
		int num1 = 30;
		int num2 = 35;
		int num3 = 17;
		// AND locical operator
		boolean result1 = (num1 > num2) && (num1 > num2);
		System.out.printf("the results is %b%n",result1);
		
		// OR logical operator
		boolean result2 = (num1 > num2) || (num1 > num2);
		System.out.printf("the results is %b%n",result2);
		
		
		// NOT logical operator
		boolean result3 = !((num1 > num2) && (num1 > num2));
		System.out.printf("the results is %b%n",result3);
		
		
		
		
	}
}