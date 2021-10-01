class Solution {
    // Time Complexity O(N * M) and Space Complexity O(N * M)
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int longestIncPath = 0;
        int[][] cache = new int[rows][cols];
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++){
                int len = dfs(matrix, i, j, rows, cols, cache);
                longestIncPath = Math.max(longestIncPath, len);
            }
        }
        
        return longestIncPath;
    }
    
    public static final int[][] dirs = {{-1,0}, {1, 0}, {0, -1}, {0, 1}};
    
    private int dfs(int[][] matrix, int i, int j, int rows, int cols, int[][] cache){
        // check if the value at position present in cache 
        if(cache[i][j] != 0)
            return cache[i][j];
        
        int max = 0;
        
        for(int[] dir : dirs){
            int x = i + dir[0];
            int y = j + dir[1];
            
            // check the direction postion is less the the previous call the continue
            if(x < 0 || x >= rows || y < 0 || y >= cols || matrix[x][y] <= matrix[i][j])
                continue;
            
            // calculate the length by adding 1 and recursive call for that position
            int len = dfs(matrix, x, y, rows, cols, cache);
            // get the max value for that position
            max = Math.max(max, len);
        }
        
        cache[i][j] = max + 1;
        return cache[i][j];
    }
}