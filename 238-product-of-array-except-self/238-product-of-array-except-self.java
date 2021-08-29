class Solution {
    // Time Complexity O(N) and Space Complexity O(1) 
    public int[] productExceptSelf(int[] nums) {
         int N  = nums.length;
        
        int[] left = new int[N];
        //int[] right = new int[N];
        
        left[0] = 1;
       //right[N-1] = 1;
        
        //int[] output = new int[N];
        
        for(int i = 1; i < N; i++){
            left[i] = nums[i - 1] * left[i -1];
        }
        System.out.print(Arrays.toString(left));
        
        // for(int i = N - 2; i >= 0; i--){
        //     right[i] = nums[i + 1] * right[i + 1];
        // }
        // For space complexity O(1)
         int R = 1;
         for(int i = N - 1 ; i >= 0; i--){
            left[i] = left[i] * R;
            R *= nums[i];
         }
       
        
//         for(int i = 0; i < N; i++){
//             output[i] = left[i] * right[i];
//         }
        
        return left;
    }
}