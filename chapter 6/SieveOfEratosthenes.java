public class SieveOfEratosthenes {

    public static void main(String[] args) {

        // Create boolean array of size 1000 (index 0–999)
        boolean[] isPrime = new boolean[1000];

        // Initialize all elements to true (assume all numbers are prime)
        for (int i = 2; i < isPrime.length; i++) {
            isPrime[i] = true;
        }

        // Begin sieve
        for (int i = 2; i * i < isPrime.length; i++) {
            if (isPrime[i]) {
                // Mark all multiples of i (except i itself) as false
                for (int j = i * 2; j < isPrime.length; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Output prime numbers between 2 and 999
        System.out.println("Prime numbers from 2 to 999:");
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                System.out.print(i + " ");
            }
        }
    }
}
