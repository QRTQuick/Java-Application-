import java.util.Scanner;

public class Sum{
	public static void main(String[] args){
		Scanner input = new Scanner (System.in);
		
		int num, sum = 0, i=1;
		
		while (i<=10){
			System.out.printf("Input no.%d: ",i);
			num = input.nextInt();
			sum+=num;
			i++;
		}
		System.out.printf("Sum -> %d",sum);
		input.close();
	}
}