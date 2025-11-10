public class DoWhileLoop{
	public static void main (String[] args){
		int i = 1;
		
		do{
			System.out.println("This is a post test loop");
			i++;
		}
		while(i<=0);
		
		while(i<=0){
			System.out.println("This code won't run");
			i++;
		}
	}
}