import java.util.Random;

public class Maze {
    private final byte[][] board;
    private char[] direction;
    private int counter = 0;
    private boolean runFind = false;

    public Maze(byte[][] board) {
        this.board = new byte[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            System.arraycopy(board[i], 0, this.board[i], 0, board[i].length);
        }
        direction = new char[board.length * board[0].length];
    }

    public Maze(int rowRandom, int colRandom) {
        this.board = randomFill(rowRandom, colRandom);
        direction = new char[rowRandom * colRandom];
    }

    private byte[][] randomFill(int rows, int cols) {
        byte[][] generatedBoard = new byte[rows][cols];
        Random random = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                generatedBoard[i][j] = (byte) (random.nextInt(4) == 0 ? 1 : 0);
            }
        }

        generatedBoard[0][0] = 0;
        generatedBoard[rows - 1][cols - 1] = 0;

        return generatedBoard;
    }

    public void printBoard() {
        for (byte[] bytes : board) {
            for (byte aByte : bytes) {
                System.out.print((aByte == 0 ? '.' : 'X') + " ");
            }
            System.out.println();
        }
    }

    private boolean exist(int i, int j) {
        return i >= 0 && i < board.length && j >= 0 && j < board[i].length && board[i][j] == 0;
    }

    private boolean find(int i, int j) {
        if (!exist(i, j)) return false;

        board[i][j] = 2;

        if (i == board.length - 1 && j == board[i].length - 1) {
            board[i][j] = 7;
            return true;
        }

        if (find(i - 1, j)) {
            board[i][j] = 3; // Up
            direction[counter++] = 'U';
            return true;
        }
        if (find(i, j - 1)) {
            board[i][j] = 4; // Left
            direction[counter++] = 'L';
            return true;
        }
        if (find(i + 1, j)) {
            board[i][j] = 5; // Down
            direction[counter++] = 'D';
            return true;
        }
        if (find(i, j + 1)) {
            board[i][j] = 6; // Right
            direction[counter++] = 'R';
            return true;
        }

        board[i][j] = 0;
        return false;
    }

    public void printWay() {
        boolean res = find(0, 0);
        runFind = true;
        if (!res) {
            System.out.println("Path not found!");
            return;
        }

        for (byte[] bytes : board) {
            for (byte aByte : bytes) {
                switch (aByte) {
                    case 3 -> System.out.print("↑");
                    case 4 -> System.out.print('←');
                    case 5 -> System.out.print('↓');
                    case 6 -> System.out.print('→');
                    case 7 -> System.out.print('E');
                    case 2 -> System.out.print('•');
                    default -> System.out.print(aByte == 1 ? 'X' : '.');
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public void printDirection() {
        if (!runFind) {
            find(0, 0);
            runFind = true;
        }
        for (int i = counter - 1; i >= 0; i--) {
            System.out.print(direction[i] + " ");
        }
        System.out.println();
    }
}