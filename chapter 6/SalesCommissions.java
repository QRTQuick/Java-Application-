import java.util.Scanner;

public class SalesCommissions {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // 9 counters for the 9 salary ranges
        int[] counter = new int[9];

        // Ask how many salespeople
        System.out.print("Enter number of salespeople: ");
        int n = input.nextInt();

        for (int i = 0; i < n; i++) {

            System.out.print("Enter gross sales for salesperson " + (i + 1) + ": ");
            double sales = input.nextDouble();

            // Calculate weekly salary
            int salary = (int) (200 + (0.09 * sales));  // truncate to int

            // Determine range index
            int rangeIndex = (salary / 100) - 2;

            // If salary is 1000 or more, put in last bucket
            if (rangeIndex >= 0 && rangeIndex <= 7) {
                counter[rangeIndex]++;
            } else {
                counter[8]++;
            }
        }

        // Print result table
        System.out.println("\nSalary Range\tCount");
        System.out.println("200–299:\t" + counter[0]);
        System.out.println("300–399:\t" + counter[1]);
        System.out.println("400–499:\t" + counter[2]);
        System.out.println("500–599:\t" + counter[3]);
        System.out.println("600–699:\t" + counter[4]);
        System.out.println("700–799:\t" + counter[5]);
        System.out.println("800–899:\t" + counter[6]);
        System.out.println("900–999:\t" + counter[7]);
        System.out.println("1000 and over:\t" + counter[8]);
    }
}
