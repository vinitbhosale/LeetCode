class Solution {
    // Time Complexity O(max K * n) K = number and n length of string AND Space O(m+n)
    // m : number of letters and n: number of digits
    public String decodeString(String s) {
        Stack<Integer> counts = new Stack<Integer>();
        Stack<String> results = new Stack<String>();
        
        String res = "";
        int index = 0;
        
        while(index < s.length()){
            if(Character.isDigit(s.charAt(index))){
                int count = 0;
                // max k loop
                while(Character.isDigit(s.charAt(index))){
                    count = 10 * count + s.charAt(index) - '0';
                    index += 1;
                }
                counts.push(count);
            }else if(s.charAt(index) == '['){
                results.push(res);
                res = "";
                index += 1;
            }else if(s.charAt(index) == ']'){
                StringBuilder temp = new StringBuilder(results.pop());
                int count = counts.pop();
                for(int i = 0; i < count; i++){
                    temp.append(res);
                }
                res = temp.toString();
                index += 1;
            }else{
                res += s.charAt(index);
                index += 1;
            }
        }
        
        return res;
    }
}