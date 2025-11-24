public class ArrayOperations {

    public static void main(String[] args) {

        // a) Create counts array with 10 elements
        int[] counts = new int[10];

        // Set all 10 elements to zero
        for (int i = 0; i < counts.length; i++) {
            counts[i] = 0;
        }

        // b) Create bonus array with 15 elements
        int[] bonus = new int[15];

        // Add 1 to each of the 15 elements
        for (int i = 0; i < bonus.length; i++) {
            bonus[i] = bonus[i] + 1;
        }

        // c) Create bestScores array with 5 elements (example values)
        int[] bestScores = {95, 87, 78, 92, 88};

        // Display each value in column format
        System.out.println("Best Scores (Column Format):");
        for (int i = 0; i < bestScores.length; i++) {
            System.out.println(bestScores[i]);
        }
    }
}
