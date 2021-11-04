class Solution {
    // Time Complexity O((R * C) ^ 2) and Space Complexity O(1)
    public int[][] candyCrush(int[][] board) {
        int row = board.length, col = board[0].length;
        boolean toCrush = false;
        
        // Equal value in rows and making them negative
        for(int r = 0; r < row; r++){
            // column increase by 2 since we want to look atleast 3 same values
            for(int c = 0 ; c + 2 < col; c++){
                int cell = Math.abs(board[r][c]);
                if(cell !=0 && cell == Math.abs(board[r][c + 1]) && cell == Math.abs(board[r][c + 2])){
                    board[r][c] = board[r][c + 1] = board[r][c + 2] = -cell;
                    toCrush = true;
                }
            }
        }
        
         // Equal value in columns and making them negative
         // row increase by 2 since we want to look atleast 3 same values
        for(int r = 0; r + 2 < row; r++){
            for(int c = 0 ; c < col; c++){
                int cell = Math.abs(board[r][c]);
                if(cell !=0 && cell == Math.abs(board[r + 1][c]) && cell == Math.abs(board[r + 2][c])){
                    board[r][c] = board[r + 1][c] = board[r + 2][c] = -cell;
                    toCrush = true;
                }
            }
        }
        
        // Gravity bringing top non negative numbers down
        for(int c = 0; c < col; c++){
            int rowIdx = row - 1;
            for(int r = row - 1; r >=0; r--){
                if(board[r][c] > 0)
                    board[rowIdx--][c] = board[r][c];
            }
            
            while(rowIdx >= 0)
                 board[rowIdx--][c] = 0;
        }
        
        return toCrush ? candyCrush(board) : board;
    }
}