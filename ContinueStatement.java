public class ContinueStatement{
	public static void main(String[] args){
		int i=0;
		while (i<10){
			i++;
			if(i==4||i==9){
			continue;
			}
			
			System.out.printf("Testing the continue statement %d%n",i);
			
		}
	}
}