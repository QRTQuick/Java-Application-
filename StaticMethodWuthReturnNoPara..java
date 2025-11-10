public class StaticMethodWuthReturnNoPara{
	public static void main (String[] args){
		int result = addition();
		Syste.out.printf("The result is %d%n",result);
	}
	public static int adition(){
		int num1 = 16;
		int num2 = 8;
		int num3 = 50;
		
		int sum=num1+num2+num3;
		return sum;
	}
}