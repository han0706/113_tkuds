import java.util.Scanner;

public class TicTacToe5x5 {
    static final int SIZE = 5;
    static char[][] board = new char[SIZE][SIZE];
    static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        initBoard();

        System.out.println("=== 5x5 井字遊戲 ===");
        printBoard();

        while (true) {
            int row = -1, col = -1;

            while (true) {
                System.out.printf("玩家 %c 請輸入位置 (row col)：", currentPlayer);
                row = sc.nextInt();
                col = sc.nextInt();

                if (isValidMove(row, col)) {
                    break;
                } else {
                    System.out.println("無效位置，請重新輸入！");
                }
            }

            board[row][col] = currentPlayer;
            System.out.printf("玩家 %c 在位置 (%d, %d) 放置棋子\n", currentPlayer, row, col);
            printBoard();

            if (checkWin(row, col)) {
                System.out.printf("玩家 %c 獲勝！\n", currentPlayer);
                break;
            }

            if (isBoardFull()) {
                System.out.println("平手！");
                break;
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';  // 換人
        }

        sc.close();
    }

    static void initBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = '.';
            }
        }
    }

    static void printBoard() {
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static boolean isValidMove(int row, int col) {
        return row >= 0 && row < SIZE &&
               col >= 0 && col < SIZE &&
               board[row][col] == '.';
    }

    static boolean isBoardFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == '.') return false;
            }
        }
        return true;
    }

    static boolean checkWin(int row, int col) {
        char p = board[row][col];
        boolean win;

        
        win = true;
        for (int j = 0; j < SIZE; j++) {
            if (board[row][j] != p) {
                win = false;
                break;
            }
        }
        if (win) return true;

        
        win = true;
        for (int i = 0; i < SIZE; i++) {
            if (board[i][col] != p) {
                win = false;
                break;
            }
        }
        if (win) return true;

       
        if (row == col) {
            win = true;
            for (int i = 0; i < SIZE; i++) {
                if (board[i][i] != p) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }

        
        if (row + col == SIZE - 1) {
            win = true;
            for (int i = 0; i < SIZE; i++) {
                if (board[i][SIZE - 1 - i] != p) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }

        return false;
    }
}
