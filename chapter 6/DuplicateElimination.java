import java.util.Scanner;

public class DuplicateElimination{
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		int uniqueNums[] = new int[5];
		int count = 0;
		boolean checker = true;
		
		// while loop to append to the array
		while(count < 5){
			
			System.out.println();
			
			System.out.println("------------------------------");
			System.out.print("Enter a random unique number: ");
			int uniqueNumEntered = input.nextInt();
			System.out.println("------------------------------");
			
			System.out.println();
			if(uniqueNumEntered < 10 || uniqueNumEntered > 100){
				System.out.println("Number must be greater than ten and less than 100");
				continue;
			}
			
			
			checker = true;
			
			// to checker if a number exist
			for(int i = 0; i < count; i++){
				if(uniqueNums[i] == uniqueNumEntered){
					checker = false;
					break;
				}
			}
			
			if(checker == false){
				System.out.println("Number already entered");
				continue;
			}
			
			uniqueNums[count] = uniqueNumEntered;
			count++;
			
			// print current active unique numbers
			System.out.println("------------------------------");
			for(int uniqueN : uniqueNums){
				System.out.print(uniqueN + " ");
			}
			System.out.println();
			System.out.println("------------------------------");
			
			System.out.println();

		}
		
		input.close();
	}
	
}