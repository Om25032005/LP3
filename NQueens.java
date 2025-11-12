import java.util.*;

public class NQueens {
    static int N;

    static boolean isSafe(int[][] board, int row, int col) {
        for (int i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;
        for (int i = row, j = col; i < N && j >= 0; i++, j--)
            if (board[i][j] == 1)
                return false;
        return true;
    }

    static boolean solveNQ(int[][] board, int col) {
        if (col >= N)
            return true;
        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;
                if (solveNQ(board, col + 1))
                    return true;
                board[i][col] = 0;
            }
        }
        return false;
    }

    static void printBoard(int[][] board) {
        for (int[] rows : board) {
            for (int x : rows)
                System.out.print(x + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value of N (board size): ");
        N = sc.nextInt();
        int[][] board = new int[N][N];
        System.out.print("Enter row (0-based) of first Queen: ");
        int row = sc.nextInt();
        System.out.print("Enter column (0-based) of first Queen: ");
        int col = sc.nextInt();
        board[row][col] = 1;
        if (solveNQ(board, 0)) {
            System.out.println("\nFinal N-Queens Board:");
            printBoard(board);
        } else {
            System.out.println("No solution exists!");
        }
        sc.close();
    }
}

//time O(n!)
//space O(n^2)