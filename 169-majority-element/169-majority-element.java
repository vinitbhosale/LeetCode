class Solution {
//--------------------------------Brute Force---------------------------------------------//
    // Time COmplexity O(N^2) and Space COmplexity O(1)
    public int majorityElement(int[] nums) {
        int majorityCount = nums.length/2;

        for (int num : nums) {
            int count = 0;
            for (int elem : nums) {
                if (elem == num) {
                    count += 1;
                }
            }

            if (count > majorityCount) {
                return num;
            }

        }

        return -1;    
    }
    
//---------------------------------Optimization to O(N)-----------------------------------//
    // Time Complexity O(N) adn Space Complexity (N)
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> nums_count = new HashMap<>();
        
        for(int n : nums){
            int count = nums_count.containsKey(n) ? nums_count.get(n) : 0;
            nums_count.put(n, count + 1);
        }
        Map.Entry<Integer, Integer> max_element = null;
        for(Map.Entry<Integer, Integer> entry : nums_count.entrySet()){
            if(max_element == null || entry.getValue() > max_element.getValue()){
                max_element = entry;
            }
        }
        return max_element.getKey();
    }
    
//---------------------------------Boyer-Moore voting Algo-------------------------------//
    //Time Complexity O(N) and Space COmplexity O(1)
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        
        for(int n : nums) {
            if(count == 0)
                candidate = n;
            
            count += (n == candidate) ? 1 : -1;
        }
        
        return candidate;
    }
}
// [3,2,3]
