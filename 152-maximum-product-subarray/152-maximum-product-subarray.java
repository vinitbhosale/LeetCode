class Solution {
    // Brute Force
    // Time Complexity O(n^2) and Space Complexity O(1)
//      public int maxProduct(int[] nums) {
//         if (nums.length == 0) return 0;

//         int result = nums[0];

//         for (int i = 0; i < nums.length; i++) {
//             int accu = 1;
//             for (int j = i; j < nums.length; j++) {
//                 accu *= nums[j];
//                 result = Math.max(result, accu);
//             }
//         }

//         return result;
//     }
    
//--------------------------------------OPTIMIZE-----------------------------------//
    // Dp Solution
    // Time Complexity O(N) and Space Complexity O(1)
    public int maxProduct(int[] nums) {
        if(nums.length == 0) return 0;
        
        int max = nums[0];
        int min = nums[0];
        int result = nums[0];
        
        for(int i  = 1; i < nums.length; i++){
            int temp_max = Math.max(nums[i] * max, Math.max(nums[i] * min, nums[i]));
            min = Math.min(nums[i] * max, Math.min(nums[i] * min, nums[i]));
            
            max = temp_max;
            result = Math.max(result, max);
        }
        
        return result;
    }
}