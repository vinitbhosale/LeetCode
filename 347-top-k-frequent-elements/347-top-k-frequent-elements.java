class Solution {
     public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> num_count = new HashMap<>();
        
         int[] res = new int[k];
        
        for(int n : nums){
            int freq = num_count.containsKey(n) ? num_count.get(n) : 0;
            num_count.put(n,freq + 1);
        }
        
        Queue<Integer> pq = new PriorityQueue<>((a,b) -> num_count.get(a) - num_count.get(b));
        
        for(int n : num_count.keySet()){
            pq.add(n);
            if(pq.size() > k)
                pq.poll();
        }
        
        for(int i = 0; i < k; i++){
            res[i] = pq.poll();
        }
        
        return res;
        
    }
}