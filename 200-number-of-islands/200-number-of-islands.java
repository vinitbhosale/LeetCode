class Solution {
    // DFS Time Complexity O(M X N) Space complexity O(M X N)
   public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
       
        int count = 0;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1'){
                    count += 1;
                    dfs(grid, i, j);    
                }
                
            }
        }
        
        return count;
    }
    
    public void dfs(char[][] grid, int i, int j){
        // base condition
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0')
            return;
        
        // make the position value to 0
        grid[i][j] = '0';
        
        // look for other four directions
        dfs(grid,i-1,j);//up
        dfs(grid,i+1,j);//down
        dfs(grid,i,j-1);//left
        dfs(grid,i,j+1);//right
    }
    
//--------------------------------------------------------------------------------------------------------------------------------------------------------------//
    
    // BFS Time Complexity O(M X N) Space complexity O(M X N)
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int m = grid.length, n = grid[0].length;
        
        boolean[][] visited = new boolean[m][n];
        
        // to hold the positions of the grid
        Queue<int[]> queue = new LinkedList<>();
        
        int count = 0;
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                    bfs(grid, queue, visited);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    int[][] dirs = {{0,1}, {1,0}, {0, -1}, {-1, 0}};
    private void bfs(char[][] grid, Queue<int[]> queue, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;
        
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] dir : dirs) {
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];
                
                // if out of bound or water(0) then continue 
                if (x < 0 || x >= m || y < 0 || y >=n || visited[x][y] || grid[x][y] == '0') 
                    continue;
                
                // Else if land then make it visited and add to the queue to look other 4 direction
                visited[x][y] = true;
                queue.offer(new int[]{x, y});
            }
        }
    }
}
