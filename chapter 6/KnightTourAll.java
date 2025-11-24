import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * KnightTourAll
 *
 * Implements parts (a) - (d) of the Knight's Tour exercises:
 *  a) simple random/manual tour until stuck
 *  b) deterministic pick-first valid move strategy
 *  c) accessibility heuristic (Warnsdorff-like), includes running 64 tours
 *  d) accessibility + lookahead tie-breaker
 *
 * Run and use the menu to select which part to execute.
 */
public class KnightTourAll {

    // Knight moves (horizontal and vertical) described in the problem statement
    private static final int[] H = { 2, 1, -1, -2, -2, -1, 1, 2 };
    private static final int[] V = { -1, -2, -2, -1, 1, 2, 2, 1 };

    private static final int N = 8; // board is 8x8
    private static final Random rnd = new Random();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (;;) {
            System.out.println("\nKnight's Tour — choose part to run:");
            System.out.println("1) Part (a) — random/manual-style until stuck");
            System.out.println("2) Part (b) — deterministic pick-first valid move");
            System.out.println("3) Part (c) — accessibility heuristic (plus run 64 tours)");
            System.out.println("4) Part (d) — accessibility + lookahead tie-breaker");
            System.out.println("5) Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    runPartA(sc);
                    break;
                case 2:
                    runPartB(sc);
                    break;
                case 3:
                    runPartC(sc);
                    break;
                case 4:
                    runPartD(sc);
                    break;
                case 5:
                    System.out.println("Bye.");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // ------------------ Utility helpers ------------------

    private static boolean inBounds(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

    // returns list of valid move indices (0..7) from position (r,c) that are unvisited
    private static List<Integer> validMoves(int r, int c, int[][] board) {
        List<Integer> res = new ArrayList<>();
        for (int m = 0; m < 8; m++) {
            int nr = r + V[m];
            int nc = c + H[m];
            if (inBounds(nr, nc) && board[nr][nc] == 0) {
                res.add(m);
            }
        }
        return res;
    }

    // prints the board's visit order or 0 for unvisited
    private static void printBoard(int[][] board) {
        System.out.println("Board (row 0..7 top to bottom):");
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                System.out.printf("%3d", board[r][c]);
            }
            System.out.println();
        }
    }

    // marks a board with 0s and returns a fresh board
    private static int[][] freshBoard() {
        return new int[N][N];
    }

    // ------------------ PART (a) ------------------
    // Random/manual style: pick a random valid move until stuck.
    private static void runPartA(Scanner sc) {
        System.out.println("\nPART (a) — Random/manual-style until stuck");
        int[] start = promptStart(sc);
        int sr = start[0], scol = start[1];

        int[][] board = freshBoard();
        int step = 1;
        int r = sr, c = scol;
        board[r][c] = step++;

        while (true) {
            List<Integer> moves = validMoves(r, c, board);
            if (moves.isEmpty()) break;

            // choose uniformly at random among valid moves
            int m = moves.get(rnd.nextInt(moves.size()));
            r += V[m];
            c += H[m];
            board[r][c] = step++;
        }

        printBoard(board);
        int visited = countVisited(board);
        System.out.printf("Part (a) finished. Moves made (visited squares): %d%n", visited);
    }

    // ------------------ PART (b) ------------------
    // Deterministic: at each step try moves 0..7 in order, pick the first valid.
    private static void runPartB(Scanner sc) {
        System.out.println("\nPART (b) — Deterministic pick-first valid move");
        int[] start = promptStart(sc);
        int sr = start[0], scol = start[1];

        int[][] board = freshBoard();
        int step = 1;
        int r = sr, c = scol;
        board[r][c] = step++;

        while (true) {
            boolean moved = false;
            for (int m = 0; m < 8; m++) {
                int nr = r + V[m], nc = c + H[m];
                if (inBounds(nr, nc) && board[nr][nc] == 0) {
                    r = nr; c = nc;
                    board[r][c] = step++;
                    moved = true;
                    break; // pick first valid move
                }
            }
            if (!moved) break;
        }

        printBoard(board);
        int visited = countVisited(board);
        System.out.printf("Part (b) finished. Moves made (visited squares): %d%n", visited);
    }

    // ------------------ PART (c) ------------------
    // Accessibility heuristic (Warnsdorff-like). Also run 64 tours.
    private static void runPartC(Scanner sc) {
        System.out.println("\nPART (c) — Accessibility heuristic (Warnsdorff-like)");
        System.out.println("1) Run a single tour from a start position");
        System.out.println("2) Run 64 tours (every starting square) and count full tours");
        System.out.print("Choice: ");
        int choice = sc.nextInt();

        if (choice == 1) {
            int[] start = promptStart(sc);
            int[][] board = warnsdorffTour(start[0], start[1], false);
            printBoard(board);
            int visited = countVisited(board);
            System.out.printf("Visited squares: %d%n", visited);
        } else if (choice == 2) {
            int fullCount = 0;
            int total = N * N;
            // run tour from each starting square (r,c)
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    int[][] board = warnsdorffTour(r, c, true);
                    int visited = countVisited(board);
                    if (visited == total) fullCount++;
                }
            }
            System.out.printf("Out of %d starting squares, full tours found: %d%n", N * N, fullCount);
        } else {
            System.out.println("Invalid choice.");
        }
    }

    // Warnsdorff tour implementation; when 'decrementAccessibility' is true we update accessibility as we go.
    // If 'silent' true, we won't print internal details. (Here silent isn't used to print.)
    private static int[][] warnsdorffTour(int sr, int sc, boolean silent) {
        int[][] board = freshBoard();
        int[][] accessibility = initialAccessibility(); // initial accessibility values

        int step = 1;
        int r = sr, c = sc;
        board[r][c] = step++;

        // decrement accessibility for squares that become unavailable? We'll update on the fly:
        // For each move we will set accessibility of the visited square to 0 and decrease accessibility of
        // its neighbors by 1 (since they lose this incoming move).
        decrementAccessibilityForVisit(accessibility, r, c);

        while (true) {
            List<Integer> moves = validMoves(r, c, board);
            if (moves.isEmpty()) break;

            // choose the move whose destination has smallest accessibility value
            int bestMove = -1;
            int bestAcc = Integer.MAX_VALUE;
            for (int m : moves) {
                int nr = r + V[m], nc = c + H[m];
                int acc = accessibility[nr][nc];
                if (acc < bestAcc) {
                    bestAcc = acc;
                    bestMove = m;
                }
            }

            // perform move
            r += V[bestMove];
            c += H[bestMove];
            board[r][c] = step++;
            decrementAccessibilityForVisit(accessibility, r, c);
        }

        return board;
    }

    // Build the initial accessibility array as specified in the problem
    private static int[][] initialAccessibility() {
        int[][] access = new int[N][N];
        // Hardcode the pattern given
        int[][] template = {
            {2,3,4,4,4,4,3,2},
            {3,4,6,6,6,6,4,3},
            {4,6,8,8,8,8,6,4},
            {4,6,8,8,8,8,6,4},
            {4,6,8,8,8,8,6,4},
            {4,6,8,8,8,8,6,4},
            {3,4,6,6,6,6,4,3},
            {2,3,4,4,4,4,3,2}
        };
        for (int r = 0; r < N; r++) for (int c = 0; c < N; c++) access[r][c] = template[r][c];
        return access;
    }

    // When we visit square (r,c), set its accessibility to 0 and decrement accessibility of each unvisited neighbor by 1
    private static void decrementAccessibilityForVisit(int[][] accessibility, int r, int c) {
        accessibility[r][c] = 0;
        for (int m = 0; m < 8; m++) {
            int nr = r + V[m];
            int nc = c + H[m];
            if (inBounds(nr, nc) && accessibility[nr][nc] > 0) {
                accessibility[nr][nc]--;
            }
        }
    }

    // ------------------ PART (d) ------------------
    // Accessibility + lookahead tie-breaker
    private static void runPartD(Scanner sc) {
        System.out.println("\nPART (d) — Accessibility + one-move lookahead tie-breaker");

        System.out.println("1) Single tour from a starting position");
        System.out.println("2) Run 64 tours (every starting square) using heuristic+lookahead");
        System.out.print("Choice: ");
        int choice = sc.nextInt();

        if (choice == 1) {
            int[] start = promptStart(sc);
            int[][] board = lookaheadTour(start[0], start[1], false);
            printBoard(board);
            int visited = countVisited(board);
            System.out.printf("Visited squares: %d%n", visited);
        } else if (choice == 2) {
            int fullCount = 0;
            int total = N * N;
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    int[][] board = lookaheadTour(r, c, true);
                    int visited = countVisited(board);
                    if (visited == total) fullCount++;
                }
            }
            System.out.printf("Out of %d starting squares, full tours found: %d%n", N * N, fullCount);
        } else {
            System.out.println("Invalid choice.");
        }
    }

    // Implement accessibility with lookahead tie-breaker:
    // - choose moves with minimum accessibility
    // - if tie among candidates, for each candidate simulate its onward valid moves and choose the candidate
    //   with the minimal minimum accessibility among its onward destinations (i.e., lookahead one move)
    private static int[][] lookaheadTour(int sr, int sc, boolean silent) {
        int[][] board = freshBoard();
        int[][] accessibility = initialAccessibility();

        int step = 1;
        int r = sr, c = sc;
        board[r][c] = step++;
        decrementAccessibilityForVisit(accessibility, r, c);

        while (true) {
            List<Integer> candidates = validMoves(r, c, board);
            if (candidates.isEmpty()) break;

            // determine minimum accessibility among candidates
            int minAcc = Integer.MAX_VALUE;
            for (int m : candidates) {
                int nr = r + V[m], nc = c + H[m];
                int acc = accessibility[nr][nc];
                if (acc < minAcc) minAcc = acc;
            }

            // filter candidates to those with minAcc
            List<Integer> tied = new ArrayList<>();
            for (int m : candidates) {
                int nr = r + V[m], nc = c + H[m];
                if (accessibility[nr][nc] == minAcc) tied.add(m);
            }

            int chosenMove = -1;
            if (tied.size() == 1) {
                chosenMove = tied.get(0);
            } else {
                // lookahead: for each tied move, examine onward moves from the candidate square and
                // compute the minimal accessibility among those onward moves (lower is better).
                // Choose the tied move for which that minimal next accessibility is smallest.
                int bestTieMetric = Integer.MAX_VALUE;
                for (int m : tied) {
                    int candR = r + V[m], candC = c + H[m];
                    // gather onward moves of the candidate (must be unvisited on current board)
                    List<Integer> onward = validMoves(candR, candC, board);
                    // if no onward moves, metric is very large (we may want to avoid dead ends)
                    if (onward.isEmpty()) {
                        // A potential improvement is to treat no onward moves as very bad (large metric)
                        // so we won't choose it unless forced.
                        if (bestTieMetric > Integer.MAX_VALUE / 2) {
                            // keep scanning others
                        }
                        int metric = Integer.MAX_VALUE / 2;
                        if (metric < bestTieMetric) {
                            bestTieMetric = metric;
                            chosenMove = m;
                        }
                        continue;
                    }
                    int minNextAcc = Integer.MAX_VALUE;
                    for (int om : onward) {
                        int nr = candR + V[om], nc = candC + H[om];
                        int acc = accessibility[nr][nc];
                        if (acc < minNextAcc) minNextAcc = acc;
                    }
                    // smaller minNextAcc is better (it means the chosen candidate leads to a square
                    // that itself is more constrained)
                    if (minNextAcc < bestTieMetric) {
                        bestTieMetric = minNextAcc;
                        chosenMove = m;
                    }
                }
            }

            // perform chosen move
            r += V[chosenMove];
            c += H[chosenMove];
            board[r][c] = step++;
            decrementAccessibilityForVisit(accessibility, r, c);
        }

        return board;
    }

    // ------------------ Misc helpers ------------------

    // Count visited squares (>0)
    private static int countVisited(int[][] board) {
        int cnt = 0;
        for (int r = 0; r < N; r++) for (int c = 0; c < N; c++) if (board[r][c] != 0) cnt++;
        return cnt;
    }

    private static int[] promptStart(Scanner sc) {
        System.out.print("Enter starting row (0..7): ");
        int r = sc.nextInt();
        System.out.print("Enter starting column (0..7): ");
        int c = sc.nextInt();
        if (!inBounds(r, c)) {
            System.out.println("Out of bounds; using 0,0 as fallback.");
            r = 0; c = 0;
        }
        return new int[] { r, c };
    }
}
