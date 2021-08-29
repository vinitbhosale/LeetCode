class Solution {
   // Time Complexity O(N) and Space Complexity O(1)
    public void nextPermutation(int[] nums) {
        
        int k = nums.length - 2;
        
        while(k >=0 && nums[k] >= nums[k+1]){
            k--;
        }
        
        if(k == -1){
            reverse(nums, 0, nums.length - 1);
            return;
        }
        
        for(int i = nums.length - 1; i > k; i--){
            if(nums[i] > nums[k]){
                int temp = nums[k];
                nums[k] = nums[i];
                nums[i] = temp;
                break;
            }
        }
        // reversing to get the lexicographically next greater permutation
        reverse(nums, k + 1, nums.length - 1);
    }
    
    private void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}