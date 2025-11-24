public class EnhancedForLoop{
	
	public static void main(String[] args){
		sums(args);
	}
	
	public static void sums(String[] multipleArgs){
		double sum = 0;
		for(String arg : multipleArgs){
			sum += Double.parseDouble(arg);
		}
		
		System.out.printf("The sum of the argument is: %.2f%n",sum);
	}
	
}