class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>(),
        first_seen = new HashMap<>(), last_seen = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            if(first_seen.get(nums[i]) == null) first_seen.put(nums[i], i);
             last_seen.put(nums[i], i);
            int freq = count.containsKey(nums[i]) ? count.get(nums[i]) : 0;
            count.put(nums[i], freq + 1);
        }
         int min_length = nums.length;
        int degree = Collections.max(count.values());
        
        for(int n : count.keySet()){
            if(count.get(n) == degree){
                min_length = Math.min(min_length, last_seen.get(n) - first_seen.get(n) + 1);
            }
        }
        
        return min_length;
    }
}