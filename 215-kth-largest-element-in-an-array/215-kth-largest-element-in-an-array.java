class Solution {
    // Time Complexity O(NlogN) Space Complexity O(1)
    // public int findKthLargest(int[] nums, int k) {
    //     final int N = nums.length;
    //     Arrays.sort(nums);
    //     return nums[N - k];
    // }
    
 //-----------------------------Optimize----------------------------------------------//  
    
    // Time Complexity O(NlogK) Space Complexity O(k)
    public int findKthLargest(int[] nums, int k) {
        // insert numbers with lowest value to be high priority
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> a - b);
        
        for(int n : nums){
            queue.offer(n);
            if(queue.size() > k)
                queue.poll();
        }
        
        return queue.poll();
    }
}