class Solution {
    // Brute Force Time Complexity O(N^2) and Space complexity O(1)
    public int trap(int[] height) {
        
        if(height.length < 2  || height == null)
            return 0;
        
        int waterCount = 0;
        
        // looping from second position as ist position will level will never have water till one position before last
        for(int i = 1; i < height.length - 1; i++){
            int leftMax = 0;
            int rightMax = 0;
            
            // leftMax for ith position
            for(int j = i; j >=0; j--){
                leftMax = Math.max(leftMax, height[j]);
            }
            // rightMax for ith position
             for(int j = i; j < height.length; j++){
                rightMax = Math.max(rightMax, height[j]);
            }
            
            // calculate the water count by taking min from leftMax and rightMax and subtracting it with the height at ith position
            waterCount += Math.min(leftMax, rightMax) - height[i];
        }
        
        return waterCount;
    }
//------------------------------------------------------------------------------------------------------------------------//
    //Time Complexity O(N) and Space complexity O(1)
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        
        int left = 0;
        int right = height.length - 1;
        int res= 0;
        int level = 0;
        
        while(left < right){
           
            int lower = height[height[left] < height[right] ? left++ : right--];
    
            level = Math.max(level, lower);
           
            res += level - lower;
          
          
        }
        return res;
    }
}
