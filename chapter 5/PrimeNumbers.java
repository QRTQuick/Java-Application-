public class PrimeNumbers{
    public static void main(String[] args){
        System.out.println("Prime numbers less than 10000:");
        int count = 0;
        
        for (int number = 2; number < 10000; number++){
            if (isPrime(number)){
                System.out.print(number + " ");
                count++;
                if (count % 10 == 0) {
                    System.out.println();
                }
            }
        }
        System.out.printf("\nTotal primes: %d%n", count);
    }

    public static boolean isPrime(int number){
        if (number <= 1) return false;
        if (number == 2) return true;
        if (number % 2 == 0) return false;

        int limit = (int) Math.sqrt(number);
        for (int i = 3; i <= limit; i += 2){
            if (number % i == 0){
                return false;
            }
        }
        return true;
    }
}