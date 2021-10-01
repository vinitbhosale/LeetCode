class Solution {
    // Time COmplexity O(n) and Space Complexity O(N)
    public String countAndSay(int n) {
        StringBuilder res = new StringBuilder("1");
        
        if(n <= 0) return "";
        if(n == 1) return res.toString();
        
        for(int i = 1; i < n; i++){
            StringBuilder curr = new StringBuilder();
            for(int j = 0; j < res.length(); j++){
                int count = 1;
                
                while(j + 1 < res.length() && res.charAt(j) == res.charAt(j + 1)){
                    count++;
                    j++;
                }
                
                curr.append(count).append(res.charAt(j));
            }
            res = curr;
        }
        
        return res.toString();
    }
}