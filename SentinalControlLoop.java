import java.util.Scanner;

public class SentinalControlLoop{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		int num;
		int sum=0;
		
		while(true){
			System.out.print("Input number(Input -1 when done): ");
			num = input.nextInt();
			
			
			if (num==-1){
				break;
			}
			sum+=num;
		}
		System.out.printf("Sum -> %d",sum);
	}
}