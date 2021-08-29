class Solution {
     //Brute Force Time complexity O(N^2) space complexity O(1)
    public int maxArea(int[] height) {
        int maxarea = 0;
        for (int i = 0; i < height.length; i++)
            for (int j = i + 1; j < height.length; j++)
                maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i));
        return maxarea;
    }

//----------------------------------Optimize-----------------------------------------------------//
    
    // Time complexity O(N) and space complexity O(1)
    public int maxArea(int[] height) {
        int max =0;
        int a_pointer = 0;
        int b_pointer = height.length - 1;
        
        while(a_pointer < b_pointer){
            if (height[a_pointer] < height[b_pointer]){
                max = Math.max(max, height[a_pointer] * (b_pointer - a_pointer));
                a_pointer++;
            }else{
                max = Math.max(max, height[b_pointer] * (b_pointer - a_pointer));
                b_pointer--;
            }
        }
        return max;
    }
}
