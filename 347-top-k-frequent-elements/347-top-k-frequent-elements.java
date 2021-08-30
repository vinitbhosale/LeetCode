class Solution {
    // Time Complexity O(NlogK) and Space Complexity O(n + k)
     public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> num_count = new HashMap<>();
        
         int[] res = new int[k];
        
        for(int n : nums){
            num_count.put(n, num_count.getOrDefault(n, 0) + 1);
        }
        
        Queue<Integer> pq = new PriorityQueue<>((a,b) -> num_count.get(a) - num_count.get(b));
        
        for(int n : num_count.keySet()){
            pq.add(n);
            if(pq.size() > k)
                pq.poll();
        }
        
        for(int i = k - 1; i >= 0; i--){
            res[i] = pq.poll();
        }
        
        return res;
        
    }
}
