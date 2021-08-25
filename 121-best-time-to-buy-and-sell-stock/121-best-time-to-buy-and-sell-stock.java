class Solution {
    // Brute force O(N^2) Space O(1)
     public int maxProfit(int prices[]) {
        int maxprofit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxprofit)
                    maxprofit = profit;
            }
        }
        return maxprofit;
     }
    
//-------------------------------optimize--------------------------------------------//
    
    // One Pass Time O(N) and space O(1)
    public int maxProfit(int[] prices) {
        int min_value = Integer.MAX_VALUE;
        int max_profit = 0;
        
        for(int i = 0 ; i < prices.length; i++){
            if(prices[i] < min_value){
                min_value = prices[i];
            }else if(prices[i] - min_value > max_profit){
                max_profit = prices[i] - min_value;
            }
        }
        return max_profit;
    }
}
