class Solution {
    // Time Complexity O(n * log(sum of arry)) and Space Complexity O(1)
    public int splitArray(int[] nums, int m) {
        // total MAX sum of the array for which we are going to split the array abd
        int sum = 0;
        // MAx number in the array
        int max = 0;
        
        for(int num : nums){
            max = Math.max(max, num);
            sum += num;
        }
        
        int low = max;
        int high = sum;
        // BInary search 
        while(low < high){
            int mid = low + (high - low) / 2;
            System.out.println("low: "+low+" high: "+high);
            System.out.println("mid: "+mid);
            // Check the no. of pieces can form for that total mid value
            int pieces = split(nums, mid);
            System.out.println("pieces: "+pieces);
            // If greater the m that means more small subarry increase the sum value for mid
            if(pieces > m){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        
        return low;
    }
    
    private int split(int[] arr, int target){
        
        int pieces = 1;
        int tempSum = 0;
        
        for(int num : arr){
            if(tempSum + num > target){
                tempSum = num;
                pieces++;
            }else{
                tempSum += num;
            }
        }
        
        return pieces;
    }
}