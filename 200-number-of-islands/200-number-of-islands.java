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
}