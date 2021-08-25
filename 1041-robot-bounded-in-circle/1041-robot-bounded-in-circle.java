class Solution {
    // Time Complexity O(N) and Space Complexity O(1)
    public boolean isRobotBounded(String instructions) {
        int x = 0, y = 0, idx = 0;
        // north, east, south, west
        int[][] direction = new int[][] {{0,1}, {1,0}, {0,-1}, {-1,0}};
        
        for(int i = 0; i < instructions.length(); i++){
            if(instructions.charAt(i) == 'R'){
                // For robot to face left i.e east side based on our direction 2D  array its on 1 position
                // So to not get array out of bound we are adding 1 to the idx and taking the reminder by % 4
                idx = (idx + 1) % 4;
            }else if (instructions.charAt(i) == 'L'){
                // For robot to face left i.e WEST side based on our direction 2D  array its on 3 position
                // So to not get array out of bound we are adding 3 to the idx and taking the reminder by % 4
                idx = (idx + 3) % 4;
            }else{
                x += direction[idx][0];
                y += direction[idx][1];
            }
        }
        
        return (x == 0 && y == 0) || (idx != 0);
    }
}