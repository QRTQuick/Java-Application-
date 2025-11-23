public class TurtleGraphics {

    // Directions: 0 = right, 1 = down, 2 = left, 3 = up
    private static int direction = 0;

    // Pen state
    private static boolean penDown = false;

    // Turtle position
    private static int row = 0;
    private static int col = 0;

    // 20-by-20 floor
    private static int[][] floor = new int[20][20];

    public static void main(String[] args) {

        // Example program: draws a 12×12 square
        int[][] commands = {
                {2},       // pen down
                {5, 12},   // move 12
                {3},       // right turn
                {5, 12},
                {3},
                {5, 12},
                {3},
                {5, 12},
                {1},       // pen up
                {6},       // display floor
                {9}        // end
        };

        runProgram(commands);
    }

    public static void runProgram(int[][] cmds) {

        for (int[] cmd : cmds) {

            int command = cmd[0];

            switch (command) {

                case 1: // Pen up
                    penDown = false;
                    break;

                case 2: // Pen down
                    penDown = true;
                    break;

                case 3: // Turn right
                    direction = (direction + 1) % 4;
                    break;

                case 4: // Turn left
                    direction = (direction + 3) % 4;
                    break;

                case 5: // Move forward N spaces
                    int spaces = cmd[1];
                    move(spaces);
                    break;

                case 6: // Display floor
                    printFloor();
                    break;

                case 9: // End program
                    System.out.println("Program ended.");
                    return;

                default:
                    System.out.println("Unknown command.");
            }
        }
    }

    public static void move(int spaces) {
        for (int i = 0; i < spaces; i++) {

            // Draw if pen is down
            if (penDown)
                floor[row][col] = 1;

            // Move in the current direction
            switch (direction) {
                case 0: // right
                    if (col + 1 < 20) col++;
                    break;

                case 1: // down
                    if (row + 1 < 20) row++;
                    break;

                case 2: // left
                    if (col - 1 >= 0) col--;
                    break;

                case 3: // up
                    if (row - 1 >= 0) row--;
                    break;
            }
        }
    }

    public static void printFloor() {
        for (int r = 0; r < 20; r++) {
            for (int c = 0; c < 20; c++) {
                System.out.print(floor[r][c] == 1 ? "*" : " ");
            }
            System.out.println();
        }
    }
}
