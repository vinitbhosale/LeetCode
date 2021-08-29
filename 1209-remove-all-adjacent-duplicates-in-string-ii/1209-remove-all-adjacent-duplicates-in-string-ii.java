class Solution {
    // Brute Force Time Complexity O(N^2/k) and Space Complexity O(1)
    public String removeDuplicates(String s, int k) {
    StringBuilder sb = new StringBuilder(s);
    int length = -1;
    while (length != sb.length()) {
        length = sb.length();
        for (int i = 0, count = 1; i < sb.length(); ++i) {
            if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                count = 1;
            } else if (++count == k) {
                sb.delete(i - k + 1, i + 1);
                break;
            }
        }
    }
    return sb.toString();
}
    
//------------------------------optimize------------------------------------------------------//
    
    // Time Complexity O(N) and Space Complexity O(N)
    public String removeDuplicates(String s, int k) {
        StringBuilder res = new StringBuilder(s);
        Stack<Integer> count = new Stack<Integer>();
        
        for(int i = 0; i < res.length(); i++){
            char current = res.charAt(i);
            
            if(i == 0 || res.charAt(i-1) != current){
                count.push(1);
            }else{
                int increment = count.pop() + 1;
                if(increment == k){
                    res.delete(i - k + 1, i+1);
                    // change the i position since we deleted some string.
                    i = i - k;
                }else{
                    count.push(increment);
                }
            }
        }
        
        return res.toString();
    }
}
