class Solution {
      // Brute Force Time Complexity O(N^2) and Space Complexity O(1)
    public int maxSubArray(int[] nums) {
        int maxSubarray = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int currentSubarray = 0;
            for (int j = i; j < nums.length; j++) {
                currentSubarray += nums[j];
                maxSubarray = Math.max(maxSubarray, currentSubarray);
            }
        }
        
        return maxSubarray;
    }
    
//------------------------------Optimize----------------------------------------//
    
    //Time Complexity O(N) and Space Complexity O(1) 
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int currentMax = max;
        
        for(int i = 1; i< nums.length; i++){
            if(nums[i]+currentMax > nums[i]){
                currentMax = nums[i]+currentMax;
                max = Math.max(max, currentMax);
            }else{
                currentMax = nums[i];
                max = Math.max(max, currentMax);
            }
        }
        return max;
    }
}
