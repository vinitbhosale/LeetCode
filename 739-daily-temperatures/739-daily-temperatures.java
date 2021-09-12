class Solution {
    // Time Complexity O(N) and Space Complexity O(N)
    public int[] dailyTemperatures(int[] T) {
        int[] nextWarmerDay = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        
        for(int i = T.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && T[i] >= T[stack.peek()])
                stack.pop();
            
            // if stacj is not empty the get the peek element index and subtract it with the recent temperature index
            nextWarmerDay[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            
            // inserting the index ofn the previous highest temperature
            stack.push(i);
        }
        
        return nextWarmerDay;
    }
}

//temperatures = [73,74,75,71,69,72,76,73]
//                0  1  2  3  4  5  6  7
