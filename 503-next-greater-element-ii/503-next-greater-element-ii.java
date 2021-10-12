class Solution {
    // Brute Force O(N^2) Space O(N)
    /**
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++){
            result[i] = -1;
            
            for(int j = 1; j < nums.length; j++){
                if(nums[(i + j) % nums.length] > nums[i]){
                    result[i] = nums[(i + j) % nums.length];
                    break;
                }
            }
        }
        
        return result;
    }*/
//--------------------------------Optimize Solutuion-----------------------------------------------//
    
    // Time Complexity  O(N) Space Complexity O(N)
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        Stack<Integer> stack = new Stack<>();
        int [] result = new int[nums.length];
        Arrays.fill(result, -1);
        
        for(int i = 0; i < len * 2; i++){
            
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i % len]){
                // System.out.println("value of i"+i+" "+i % len);
                result[stack.pop()] = nums[i % len];
                
            }
            
            if(i < len){
                // System.out.println("pushed ith value "+i);
                stack.push(i);
            }
        }
        
        return result;
    }
}