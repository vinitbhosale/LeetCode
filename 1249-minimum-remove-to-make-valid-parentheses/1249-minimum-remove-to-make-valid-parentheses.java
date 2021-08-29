class Solution {
   // Using STACK Time Complexity O(N) and Space Complexity O(N)
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> indexToBeRemove = new HashSet<>();
        
        for(int i = 0; i< s.length(); i++){
            if(s.charAt(i) == '(')
                stack.push(i);
            if(s.charAt(i) == ')'){
                if(stack.isEmpty())
                    indexToBeRemove.add(i);
                else
                    stack.pop();
            }  
        }
        
        while(!stack.isEmpty()) indexToBeRemove.add(stack.pop());
        
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(!indexToBeRemove.contains(i))
                result.append(s.charAt(i));
        }
        
        return result.toString();
    }
    
//--------------------------------------------------------------------------------------------------------------------------//
    
    // Using two StringBuilder Time Complexity O(N) and Space Complexity O(N)
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int open = 0;
        
        for(char ch : s.toCharArray()){
            if(ch == '('){
                open++;
            }
            else if(ch == ')'){
                // yet not encounter open bracket'(' no need to decrement open count;
                if(open == 0) continue;
                open--;
            }
            sb.append(ch);
        }
        
        // Reverse iterate String to check if any open bracket is left;
        StringBuilder result = new StringBuilder();
        for(int i = sb.length() - 1; i >=0; i--){
            if(sb.charAt(i) == '(' && open-- > 0) continue;
            
            result.append(sb.charAt(i));
        }
        
        return result.reverse().toString();
    }
}
