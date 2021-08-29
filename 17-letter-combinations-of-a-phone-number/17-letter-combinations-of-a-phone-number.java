class Solution {
    // Time Complexity O(4^N * N) and Space Complexity O(N)
    public List<String> letterCombinations(String digits) {
        Map<Character, String> phone = new HashMap<>();
        
        phone.put('2', "abc");
        phone.put('3', "def");
        phone.put('4', "ghi");
        phone.put('5', "jkl");
        phone.put('6', "mno");
        phone.put('7', "pqrs");
        phone.put('8', "tuv");
        phone.put('9', "wxyz");
        
        List<String> result = new ArrayList<>();
        
        if(digits.length() == 0)
            return result;
        
        StringBuilder sb = new StringBuilder();
        
        backTrack(phone, digits, sb, result, 0);
        
        return result;
        
    }
    
    private void backTrack(Map<Character, String> phone, String digits, StringBuilder sb, 
                          List<String> result, int start){
        
        if(sb.length() == digits.length()){
            result.add(sb.toString());
            return;
        }
        
        for(int i = start; i < digits.length(); i++){
            
            String str = phone.get(digits.charAt(i));
            
            for(int j = 0; j < str.length(); j++){
                sb.append(str.charAt(j));
             
                backTrack(phone, digits, sb, result, i + 1);
                
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        
    }
}