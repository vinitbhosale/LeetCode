class Solution {
    // Time Complexity O(NlogN) and Space Complexity O(1)
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a,b) -> (a[0] - b[0]) - (a[1] - b[1]));
        
        int minCost = 0;
        for(int i = 0; i < costs.length / 2; i++){
            minCost += costs[i][0];
            minCost += costs[costs.length / 2 + i][1];
        }
        
        return minCost;
    }
}