class Solution {
    // Brute Force O(n^3) Space Complexity O(min(m, n)) 
//      public int lengthOfLongestSubstring(String s) {
//         int n = s.length();

//         int res = 0;
//         for (int i = 0; i < n; i++) {
//             for (int j = i; j < n; j++) {
//                 if (checkRepetition(s, i, j)) {
//                     res = Math.max(res, j - i + 1);
//                 }
//             }
//         }

//         return res;
//     }

//     private boolean checkRepetition(String s, int start, int end) {
//         int[] chars = new int[128];

//         for (int i = start; i <= end; i++) {
//             char c = s.charAt(i);
//             chars[c]++;
//             if (chars[c] > 1) {
//                 return false;
//             }
//         }

//         return true;
//     }
    
 //----------------------------------------Optimize---------------------------------------------//
    
    // Time complexity O(N) Space Complexity O(min(m, n)) 
    public int lengthOfLongestSubstring(String s) {
        
        int a_pointer = 0;
        int b_pointer = 0;
        
        int max = 0;
        
        HashSet<Character> set = new HashSet<>();
        
        while(b_pointer < s.length()){
            
            if(!set.contains(s.charAt(b_pointer))){
                set.add(s.charAt(b_pointer));
                max = Math.max(max, set.size());
                b_pointer++;
            }else{
                set.remove(s.charAt(a_pointer));
                a_pointer++;
            }
        }
        return max;
    }
}