import java.util.Scanner;

public class Classwork1{
	public static void main (String[] args){
		Scanner input = new Scanner(System.in);
		
		int num;
		int nCount=0, pCount=0, zCount=0;
		System.out.println("Input -1 when done");
		
		while(true){
			System.out.print("Input number: ");
			num = input.nextInt();
			
			
			if (num==-1){
				break;
			}
			else if (num<-1){
				nCount++;
			}
			else if (num>0){
				pCount++;
			}
			else{
				zCount++;
			}
		}
		System.out.printf("Negative -> %d\nPositive -> %d\nZero -> %d\n",nCount,pCount,zCount);
	}
}