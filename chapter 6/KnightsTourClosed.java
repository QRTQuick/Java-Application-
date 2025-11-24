public class KnightsTourClosed {

    public static void main(String[] args) {

        int[][] board = new int[8][8];

        int[] horizontal = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int[] vertical   = { -1, -2, -2, -1, 1, 2, 2, 1 };

        int currentRow = 0;
        int currentColumn = 0;

        // Save the start square for closed-tour test
        int startRow = currentRow;
        int startColumn = currentColumn;

        board[currentRow][currentColumn] = 1;

        int moveCounter = 1;

        while (moveCounter < 64) {
            boolean moved = false;

            for (int move = 0; move < 8; move++) {
                int nextRow = currentRow + vertical[move];
                int nextColumn = currentColumn + horizontal[move];

                if (nextRow >= 0 && nextRow < 8 &&
                    nextColumn >= 0 && nextColumn < 8 &&
                    board[nextRow][nextColumn] == 0) {

                    currentRow = nextRow;
                    currentColumn = nextColumn;

                    board[currentRow][currentColumn] = ++moveCounter;

                    moved = true;
                    break;
                }
            }

            if (!moved) {
                break;  // tour ends early
            }
        }

        // ------------------------------------------
        //  CLOSED TOUR TEST GOES **RIGHT HERE**
        // ------------------------------------------

        boolean isClosedTour = false;

        for (int move = 0; move < 8; move++) {
            int checkRow = currentRow + vertical[move];
            int checkCol = currentColumn + horizontal[move];

            if (checkRow == startRow && checkCol == startColumn) {
                isClosedTour = true;
                break;
            }
        }

        // ------------------------------------------

        System.out.println("\nTour Completed Moves: " + moveCounter);

        if (moveCounter == 64) {
            System.out.println("This is a FULL tour!");

            if (isClosedTour) {
                System.out.println("This is also a CLOSED tour.");
            } else {
                System.out.println("But it is NOT a closed tour (open tour).");
            }

        } else {
            System.out.println("Tour ended early. Not full, not closed.");
        }

        // Display board
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                System.out.printf("%3d", board[r][c]);
            }
            System.out.println();
        }
    }
}
