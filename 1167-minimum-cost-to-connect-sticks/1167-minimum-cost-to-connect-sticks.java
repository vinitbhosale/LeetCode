class Solution {
    // Time Complexity O(NlogN) and Space Complexity O(NLogN)
    public int connectSticks(int[] sticks) {
        int totalCost = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for(int s : sticks)
            queue.offer(s);
        
        while(queue.size() > 1) {
            int cost = queue.poll() + queue.poll();
            
            totalCost += cost;
            
            queue.offer(cost);
        }
        
        return totalCost;
    }
}