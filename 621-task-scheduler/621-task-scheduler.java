class Solution {
    // Time Complexity O(N) and Space Complexity O(1)
    public int leastInterval(char[] tasks, int n) {
        int[] char_count = new int[26];
        
        // count of each task
        for(char c : tasks){
            char_count[c - 'A']++;
        }
        
        // Sort in ASC on count of each tasks
        Arrays.sort(char_count);
        
        // Get the Count - 1 of the highest frequency tasks
        int max_val = char_count[25] - 1;
        
        // idle sots will be the mas count frequency - 1 * the number of cool down period
        int idle_slot = max_val * n;
        
        // iterate through each tasks from back and fill the idela slots
        for(int i = 24; i >=0; i--){
            idle_slot -= Math.min(char_count[i], max_val);
        }
        
        return idle_slot > 0 ? idle_slot + tasks.length : tasks.length;
    }
}