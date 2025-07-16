class TicTacToeGame {
    private static final char EMPTY = '.';
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';
    
    /**
     * 初始化 3x3 的井字遊戲棋盤
     */
    static char[][] initializeBoard() {
        char[][] board = new char[3][3];
        
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = EMPTY;
            }
        }
        
        return board;
    }
    
    /**
     * 列印棋盤，包含行列座標
     */
    static void printBoard(char[][] board) {
        System.out.println("\n  井字遊戲棋盤");
        System.out.println("  0 1 2");
        
        for (int row = 0; row < 3; row++) {
            System.out.print(row + " ");
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col]);
                if (col < 2) System.out.print(" ");
            }
            System.out.println();
        }
    }
    
    /**
     * 放置棋子
     */
    static boolean placePiece(char[][] board, int row, int col, char player) {
        // 檢查座標是否有效
        if (row < 0 || row >= 3 || col < 0 || col >= 3) {
            System.out.printf("無效座標：(%d, %d)\n", row, col);
            return false;
        }
        
        // 檢查該位置是否已被佔用
        if (board[row][col] != EMPTY) {
            System.out.printf("位置 (%d, %d) 已被佔用\n", row, col);
            return false;
        }
        
        board[row][col] = player;
        System.out.printf("玩家 %c 在位置 (%d, %d) 放置棋子\n", player, row, col);
        return true;
    }
    
    /**
     * 檢查是否有玩家獲勝
     */
    static char checkWinner(char[][] board) {
        // 檢查行
        for (int row = 0; row < 3; row++) {
            if (board[row][0] != EMPTY && 
                board[row][0] == board[row][1] && 
                board[row][1] == board[row][2]) {
                return board[row][0];
            }
        }
        
        // 檢查列
        for (int col = 0; col < 3; col++) {
            if (board[0][col] != EMPTY && 
                board[0][col] == board[1][col] && 
                board[1][col] == board[2][col]) {
                return board[0][col];
            }
        }
        
        // 檢查主對角線
        if (board[0][0] != EMPTY && 
            board[0][0] == board[1][1] && 
            board[1][1] == board[2][2]) {
            return board[0][0];
        }
        
        // 檢查反對角線
        if (board[0][2] != EMPTY && 
            board[0][2] == board[1][1] && 
            board[1][1] == board[2][0]) {
            return board[0][2];
        }
        
        return EMPTY;  // 沒有獲勝者
    }
    
    /**
     * 檢查棋盤是否已滿
     */
    static boolean isBoardFull(char[][] board) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        char[][] board = initializeBoard();
        
        System.out.println("=== 井字遊戲示範 ===");
        printBoard(board);
        
        // 模擬一場遊戲
        int[][] moves = {
            {0, 0}, {0, 1}, {1, 1}, {0, 2}, {2, 2}  // X, O, X, O, X
        };
        
        char currentPlayer = PLAYER_X;
        
        for (int i = 0; i < moves.length; i++) {
            int row = moves[i][0];
            int col = moves[i][1];
            
            if (placePiece(board, row, col, currentPlayer)) {
                printBoard(board);
                
                char winner = checkWinner(board);
                if (winner != EMPTY) {
                    System.out.printf("\n🎉 玩家 %c 獲勝！\n", winner);
                    break;
                } else if (isBoardFull(board)) {
                    System.out.println("\n🤝 平手！");
                    break;
                }
                
                
                currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
            }
        }
    }
}
