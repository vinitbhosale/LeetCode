class Solution {
    // Bottom-up Approach Time Complexity (N * M) N:amount M:coins and Space Complexity O(N)
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        
        // i is amount we going to make from coins i : 0, 1, 3, .......11 
        for(int i = 0; i <= amount; i++){
            for(int j = 0; j < coins.length; j++){
                // condition to check if taking  coin can we make the i amount
                if(coins[j] <= i){
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                } else {
                    break;
                }
            }
        }
        
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
