class Solution {
    // Time O(N) and Space O(N)
    public boolean isValid(String s) {
        
        // if the length is less than 2 we cant check if the String is Valid
        if(s.length() % 2 != 0) return false;
        
        Stack<Character> stack = new Stack<>();
        
        for(char c: s.toCharArray()){
            // For open push to stack and for clos pop from stack
            
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else if(c == ')' && !stack.isEmpty() && stack.peek() == '('){
                stack.pop(); 
            }else if(c == '}' && !stack.isEmpty() && stack.peek() == '{'){
                stack.pop(); 
            }else if(c == ']' && !stack.isEmpty() && stack.peek() == '['){
                stack.pop(); 
            }else{
                return false;
            }
        }
        // check if stack empty 
        return stack.isEmpty();
    }
}