public class TypeCasting{
	public static void main(String [] args){
		//widening
		double num = 10;
		System.out.printf("the value is %f%n",num);
		
		//narrowing
		double price = 32.89;
		int result =(int)price;
		System.out.printf("the value is %d%n", result);
		
}
}