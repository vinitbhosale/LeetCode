class Solution {
    // Time Complexity O(N) and SPace COmplexity O(N)
    public String removeDuplicates(String S) {
        char[] unique = new char[S.length()];
        int i =0;
        
        for(int j = 0; j < S.length(); j++){
            char current = S.charAt(j);
            
            if(i > 0 && unique[i-1] == current){
                i--;
            }else{
                unique[i] = current;
                i++;
            }
        }
        return new String(unique, 0, i);
    }
}