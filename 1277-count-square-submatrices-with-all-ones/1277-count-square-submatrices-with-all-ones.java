class Solution {
    // Time Complexity O(M * N) and Space Complexity O(1)
    public int countSquares(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
    
        int count = 0;
            
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(matrix[i][j] == 1){
                    if(i == 0 || j == 0)
                        count += 1;
                    else{
                        int val = Math.min(Math.min(matrix[i-1][j], matrix[i][j-1]), matrix[i-1][j-1]) + matrix[i][j];
                        count += val;
                        matrix[i][j] = val;
                    }
                }
            }
        }
        
        return count;
    }
}