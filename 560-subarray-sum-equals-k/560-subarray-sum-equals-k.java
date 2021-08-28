class Solution {
    // Brute Force O(N^3) and space complexity O(1)
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        
        // start will go till nums.lenght - 1
        for(int start = 0; start < nums.length; start++) {
            // end will go till nums.lenght
            for(int end = start + 1; end <= nums.length; end++) {
                int sum = 0;
                // sum all the elements from start to end-1
                for(int i = start ; i < end; i++) {
                    sum += nums[i];
                }
                if(sum == k)
                    count++;
            }
        }
        
        return count;
    }

//--------------------------------Optimization to O(N^2)------------------------------------------------//
    
    // Cumulative sum approach Time Complexity O(N^2) and Space COmplexity O(1)
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        
        // start will go till nums.lenght - 1
        for(int start = 0; start < nums.length; start++) {
            int sum = 0;
            // end will go till nums.lenght - 1
            for(int end = start; end < nums.length; end++) {
                sum += nums[end];
                if(sum == k)
                    count++;
            }
        }
        
        return count;
    }

//--------------------------------Optimization to O(N)------------------------------------------------//
    
    // One pass approach Time Complexity O(N) and Space COmplexity O(N) used HashMAp
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        // Map key:cumulative sum and value: count of that sum
        map.put(0, 1);
        
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            
            if(map.containsKey(sum - k))
                count += map.get(sum - k);
            
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
}
