class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return wordBreakerHelper(s, wordDict, new HashMap<String, List<String>>());
    }
    
    private List<String> wordBreakerHelper(String s, List<String> wordDict, Map<String, List<String>> memo){
        if(memo.containsKey(s)){
            return memo.get(s);
        }  
        List<String> result = new ArrayList<>();
        
        if(s.length() == 0){
            result.add("");
            return result;
        }
        
        for(String word : wordDict){
            if(s.startsWith(word)){
                List<String> subStrings = wordBreakerHelper(s.substring(word.length()), wordDict, memo);

                for(String subStr : subStrings){
                    String optionalSpace = subStr.isEmpty() ? "" : " ";
                    result.add(word + optionalSpace + subStr);
                }
            }
            
        }
        
        memo.put(s, result);
        
        return result;
    }
}


/**
 cat -> sand -> dog -> ""
 cats -> and -> dog -> ""
*/