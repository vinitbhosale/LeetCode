class Solution {
    public int minMutation(String start, String end, String[] bank) {
     
        Set<String> bankSet = new HashSet<>();
        
        for(String str : bank){
            bankSet.add(str);
        }
        
        // Condition to check if the end string present in the bank or not
        if(!bankSet.contains(end))
            return -1;
        
        int mutation = 0;
        
        Queue<String> queue = new LinkedList<>();
        
        queue.offer(start);
        
        char[] charArray = {'A', 'C', 'G', 'T'};
        
        while(!queue.isEmpty()) {
            
            int size = queue.size();
            
            for(int i = 0; i < size; i++) {
                
                String currWord = queue.poll();
                
                char[] currWordArr = currWord.toCharArray();
                
                for(int j = 0; j < currWordArr.length; j++) {
                    
                    char originalChar = currWordArr[j];
                    
                    for(char ch : charArray) {
                        currWordArr[j] = ch;
                        
                        String newWord = String.valueOf(currWordArr);
                        
                        if(newWord.equals(end))
                            return mutation + 1;
                        
                        if(bankSet.contains(newWord)){
                            queue.offer(newWord);
                            // For not to get duplicate result
                            bankSet.remove(newWord);
                        }
                    }
                    currWordArr[j] = originalChar;
                } 
            }
            mutation++;
        }
        return -1; 
    }
    
}