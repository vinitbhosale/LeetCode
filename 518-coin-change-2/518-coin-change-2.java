class Solution {
    // Time Complexity O(n * m) and Space Complesity O(n+m)
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= amount; j++){
                if(j == 0) dp[i][j] = 1;
                else if( i == 0) dp[i][j] = 0;
                else if(coins[i - 1] <= j)
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        
        return dp[n][amount];
//         
    }
//------------------------------Optimize--------------------------------//
    // Time Complexity O(Coins) and space Complexity O(n)
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        
        dp[0] = 1;
        for(int c : coins){
            for(int i = c; i <= amount; i++){
                dp[i] += dp[i - c];
            }
        }
        
        return dp[amount];
    }
}
