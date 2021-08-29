class Solution {
    // Time Complexity O(n^3) and Space Complexity O(n)
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        
        int maxLen = 0;
        
        // To get maximum length of the word in the dict
        for(String word : wordDict){
            maxLen = Math.max(maxLen, word.length());
        }
        
        dp[0] = true;
        for(int i = 0; i <= n; i++){
            for(int j = 0; j < i; j++){
                if(i - j > maxLen)
                    continue;
                if(dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[n];
    }
}

/*
s = "leetcode", wordDict = ["leet","code"]
     012345678    
     TFFFTFFFT
*/