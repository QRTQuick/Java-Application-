public class ArgumentList{
	public static void main(String[] args){
		
		System.out.println(product(23));
		System.out.println(product(23, 43));
		System.out.println(product(23, 43, 134));
		System.out.println(product(23, 43, 134, 34));
		System.out.println(product(23, 43, 134, 34, 12));
		
	}
	
	public static int product(int... numbers){
		int result = 1;
		
		for(int i = 0; i < numbers.length; i++){
			result *= numbers[i];
		}
		
		return result;
	}
}