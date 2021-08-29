class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backTrack(result, "", 0, 0, n);
        return result;
        
    }
    
    private void backTrack(List<String> result, String str, int open, int close, int max){
       
        if(str.length() == max * 2){
            result.add(str);
            return;
        }
        /*
        if(open == max && close == max){
            result.add(str);
            return;
        }
        */
        
        if(open < max) backTrack(result, str + "(", open + 1, close, max);
        if(close < open) backTrack(result, str + ")", open, close + 1, max);
    }
}