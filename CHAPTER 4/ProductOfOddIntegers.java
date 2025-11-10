public class ProductOfOddIntegers{
    public static void main(String[] args){
		// variabeles 
        long product = 1;
        // for loop engine 
        for (int i = 1; i <= 15; i += 2){
            product *= i;
        }
        
        System.out.printf("Product of odd integers from 1 to 15: %d%n", product);
    }
}