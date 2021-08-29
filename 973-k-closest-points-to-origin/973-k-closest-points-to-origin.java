class Solution {
     // Max-Heap Time Complexity O(nlogK) and Space Complexity O(K)
    public int[][] kClosest(int[][] points, int k) {
        
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] * b[0] + b[1] * b[1] - a[0]*a[0] - 
                                               a[1]*a[1]);
        
        for(int[] p : points){
            pq.offer(p);
            if(pq.size() > k)
                pq.poll();
        }
        
        int[][] result = new int[k][2];
        int i = 0;
        while(!pq.isEmpty()) {
            result[i++] = pq.poll();
        }
              
        return result;
    }
}