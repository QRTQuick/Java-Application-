import java.util.Scanner;

public class FibonacciAllParts {

    // ========================
    // Part (a): Fibonacci using int
    // ========================
    public static int fibonacciInt(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int a = 0;
        int b = 1;
        int fib = 0;

        for (int i = 2; i <= n; i++) {
            fib = a + b;
            a = b;
            b = fib;
        }

        return fib;
    }

    // ========================
    // Part (b): Largest Fibonacci that fits in int
    // ========================
    public static void largestIntFibonacci() {

        int a = 0;
        int b = 1;
        int index = 1;

        while (true) {
            int next = a + b;

            // Overflow check: negative means overflow in int
            if (next < 0) {
                break;
            }

            a = b;
            b = next;
            index++;
        }

        System.out.println("\n==========================");
        System.out.println("Largest Fibonacci (int)");
        System.out.println("==========================");
        System.out.println("Index: " + index);
        System.out.println("Value: " + a);
        System.out.println("==========================\n");
    }

    // ========================
    // Part (c): Fibonacci using double
    // ========================
    public static double fibonacciDouble(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        double a = 0;
        double b = 1;
        double fib = 0;

        for (int i = 2; i <= n; i++) {
            fib = a + b;
            a = b;
            b = fib;
        }

        return fib;
    }

    // ========================
    // Part (c): Largest Fibonacci that fits in double
    // ========================
    public static void largestDoubleFibonacci() {

        double a = 0;
        double b = 1;
        int index = 1;

        while (true) {
            double next = a + b;

            // double overflow becomes Infinity
            if (Double.isInfinite(next)) {
                break;
            }

            a = b;
            b = next;
            index++;
        }

        System.out.println("\n==========================");
        System.out.println("Largest Fibonacci (double)");
        System.out.println("==========================");
        System.out.println("Index: " + index);
        System.out.println("Approx Value: " + a);
        System.out.println("==========================\n");
    }

    // ========================
    // Main Menu
    // ========================
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        while (true) {

            System.out.println("===================================");
            System.out.println("        FIBONACCI PROGRAM");
            System.out.println("===================================");
            System.out.println("1. Compute Fibonacci(n) using int");
            System.out.println("2. Largest Fibonacci that fits in int");
            System.out.println("3. Compute Fibonacci(n) using double");
            System.out.println("4. Largest Fibonacci that fits in double");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = input.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter n: ");
                    int n1 = input.nextInt();
                    System.out.println("Fibonacci(" + n1 + ") = " + fibonacciInt(n1));
                    break;

                case 2:
                    largestIntFibonacci();
                    break;

                case 3:
                    System.out.print("Enter n: ");
                    int n2 = input.nextInt();
                    System.out.println("Fibonacci(" + n2 + ") = " + fibonacciDouble(n2));
                    break;

                case 4:
                    largestDoubleFibonacci();
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
