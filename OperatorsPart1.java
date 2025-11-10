public class OperatorsPart1{
	public static void main(String[] args){
		int num = 50;
		
		//compound assignment operator
		num+= 8;
		num-= 7;
		num*= 4;
		num/= 6;
		num^= 3;
		num%= 2;
		System.out.printf("Value = %d%n",num);
		
		//arithmetic operator
		int num1 = 10;
		int num2 = 4;
		String name = "Noble";
		
		int sum = num1 + num2;
		int product = num1 * num2;
		int difference = num1 - num2;
		double divide = (double)num1/num2;
		int modulus = num1%num2;
		
		System.out.printf("Sum is %d%nDifference is %d%nProduct is %d%nDivide is %f%nModulus is %d%n",sum,difference,product,divide,modulus);
		System.out.println(name + sum);
		
		//Relational Operators
		
		int firstNum = 12;
		int secondNum = 15;
		boolean isGreater = firstNum>secondNum;
		boolean isLesser = firstNum<secondNum;
		boolean isGreaterThanOrEqualTo = firstNum>=secondNum;
		boolean isLesserThanOrEqualTo = firstNum<=secondNum;
		boolean isNotEqualTo = firstNum!=secondNum;
		boolean isEqualTo = firstNum==secondNum;


		
		System.out.printf("is firstNum>secondNum? %b%nis firstNum<secondNum? %b%nis firstNum>=secondNum? %b%nis firstNum<=secondNum? %b%nis firstNum!=secondNum? %b%nis firstNum==secondNum? %b%n",isGreater,isLesser,isGreaterThanOrEqualTo,isLesserThanOrEqualTo,isNotEqualTo,isEqualTo);
	}
}