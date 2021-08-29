class Solution {
    // DFS Time Complexity O(R*C) and Space Complexity O(R*C)
    private boolean[][] seen;
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0 ) return 0;
        
        int max = 0;
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        seen= new boolean[rows][cols];
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(!seen[i][j] && grid[i][j] == 1)
                    max = Math.max(areaDFS(i, j, grid), max);
            }
        }
        return max;
    }
    
    private int areaDFS(int row, int col, int[][] grid){
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || seen[row][col] || (grid[row][col] == 0)) {
            return 0;
        }
        
        seen[row][col] = true;
        
        return (1 + areaDFS(row+1, col, grid) + areaDFS(row-1, col, grid) + areaDFS(row, col-1, grid) + areaDFS(row, col+1, grid));
    }
    
//-----------------------------------------------------------------------------------------------------------------------------------// 
    
    
    // BFS Time Complexity O(R*C) and Space Complexity O(R*C)
//     private static int[][] directions = new int[][]{{0,1}, {1,0}, {0,-1}, {-1, 0}};
//     boolean[][] visited;
//     public int maxAreaOfIsland(int[][] grid) {
//         if(grid == null || grid.length == 0 || grid[0].length == 0 ) return 0;
        
//         int max = 0;
        
//         int rows = grid.length;
//         int cols = grid[0].length;
        
//         visited= new boolean[rows][cols];
        
//         for(int i = 0; i < rows; i++){
//             for(int j = 0; j < cols; j++){
//                 if(grid[i][j] == 1 && !visited[i][j])
//                     max = Math.max(areaBFS(i, j, grid), max);
//             }
//         }
//         return max;
    
//     }
    
//     private int areaBFS(int i, int j, int[][] grid) {
//         Queue<int[]> queue = new LinkedList<>();
//         int result = 0;
//         queue.offer(new int[]{i, j});
//         visited[i][j] = true;
        
//         while(!queue.isEmpty()){
//             int[] pos = queue.poll();
//             result++;
//             for(int[] dir : directions){
//                 int x = pos[0] + dir[0];
//                 int y = pos[1] + dir[1];
                
//                 if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || visited[x][y] || grid[x][y] == 0)
//                     continue;
                
//                 queue.offer(new int[]{x, y});
//                 visited[x][y] = true;
//             }
//         }
        
//         return result;
//     }
}