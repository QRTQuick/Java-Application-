import java.util.ArrayList;
import java.util.List;

/**
 * Solves the Eight Queens Problem using the standard Backtracking Algorithm.
 * Also includes a utility function to calculate the "Elimination Number"
 * as described in the heuristic problem statement (Exercise 6.24).
 */
public class EightQueensSolver {

    private static final int N = 8; // The size of the chessboard (8x8)
    private static int solutionCount = 0; // Counter for the number of solutions found

    /**
     * Main method to run the Eight Queens solver and demonstrate the Elimination Number calculation.
     */
    public static void main(String[] args) {
        System.out.println("--- Eight Queens Problem Solver (N=" + N + ") ---");
        
        // 1. Solve the problem using Backtracking (Systematic Search)
        // A boolean array 'board' is used to represent the columns where queens are placed.
        // board[i] stores the column index (0-7) of the queen in row i.
        int[] board = new int[N]; 
        solve(board, 0);

        System.out.println("\nTotal unique solutions found: " + solutionCount);

        // 2. Demonstration of the Heuristic Elimination Number (Exercise 6.24)
        System.out.println("\n--- Elimination Number Calculation ---");
        System.out.println("The heuristic suggests placing the first queen on the square that eliminates the fewest future squares.");
        System.out.println("Corner square (0, 0) eliminates: " + calculateEliminationNumber(0, 0) + " squares.");
        System.out.println("Center square (3, 3) eliminates: " + calculateEliminationNumber(3, 3) + " squares.");
    }

    /**
     * Recursive Backtracking function to place queens row by row.
     * @param board The current state of the board (board[row] = column index of the queen).
     * @param row The current row being considered (from 0 to N-1).
     */
    private static void solve(int[] board, int row) {
        // Base case: All N queens have been successfully placed.
        if (row == N) {
            solutionCount++;
            printSolution(board);
            return;
        }

        // Recursive step: Try placing a queen in every column of the current row.
        for (int col = 0; col < N; col++) {
            // Check if placing a queen at (row, col) is safe from previously placed queens.
            if (isSafe(board, row, col)) {
                // If safe, place the queen and move to the next row.
                board[row] = col;
                solve(board, row + 1);
                // No need for explicit 'undo' (backtrack step) as the column assignment 
                // will be overwritten in the next iteration or when returning up the call stack.
            }
        }
    }

    /**
     * Checks if a queen placed at (row, col) attacks any previously placed queens.
     * @param board The current board configuration.
     * @param row The current row.
     * @param col The current column.
     * @return true if the placement is safe, false otherwise.
     */
    private static boolean isSafe(int[] board, int row, int col) {
        // Check previously placed queens (rows < current row)
        for (int prevRow = 0; prevRow < row; prevRow++) {
            int prevCol = board[prevRow];
            
            // 1. Check same column (Vertical attack)
            if (prevCol == col) {
                return false;
            }

            // 2. Check diagonals (Diagonal attack)
            // The absolute difference in rows must equal the absolute difference in columns.
            if (Math.abs(prevRow - row) == Math.abs(prevCol - col)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Calculates the Elimination Number for a given square (r, c).
     * This is the number of squares attacked by a single queen at (r, c) on an empty board.
     * The queen is placed at (r, c), where 0 <= r, c < N.
     * @param r The row index.
     * @param c The column index.
     * @return The total number of eliminated squares.
     */
    private static int calculateEliminationNumber(int r, int c) {
        // Use a Set to store unique coordinates to avoid double-counting squares.
        List<String> eliminatedSquares = new ArrayList<>();
        
        // Helper to add unique coordinates
        java.util.function.BiConsumer<Integer, Integer> addSquare = (row, col) -> {
            if (row >= 0 && row < N && col >= 0 && col < N) {
                eliminatedSquares.add(row + "," + col);
            }
        };

        // 1. Row and Column (8 + 8 = 16 squares total)
        for (int i = 0; i < N; i++) {
            addSquare.accept(r, i); // Row
            addSquare.accept(i, c); // Column
        }
        
        // 2. Diagonals
        // Top-Left to Bottom-Right (\)
        for (int i = -N; i < N; i++) {
            addSquare.accept(r + i, c + i);
        }
        
        // Top-Right to Bottom-Left (/)
        for (int i = -N; i < N; i++) {
            addSquare.accept(r + i, c - i);
        }
        
        // The elimination number is the count of unique squares attacked.
        // We use a Set to count unique elements in the list.
        return new java.util.HashSet<>(eliminatedSquares).size();
    }


    /**
     * Utility method to print a found solution in a readable grid format.
     * @param board The solution board configuration.
     */
    private static void printSolution(int[] board) {
        System.out.println("\nSolution #" + solutionCount + ":");
        String separator = "---".repeat(N) + "-";
        
        for (int r = 0; r < N; r++) {
            System.out.println(separator);
            for (int c = 0; c < N; c++) {
                if (board[r] == c) {
                    System.out.print("| Q "); // Queen is placed here
                } else {
                    System.out.print("|   "); // Empty square
                }
            }
            System.out.println("|");
        }
        System.out.println(separator);
    }
}