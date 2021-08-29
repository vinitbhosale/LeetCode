class Solution {
    // Time Complexity: O(M^2 * N) where M is the length of each word and N is the total number of words in the input word list.
    // Space Complexity: O(M^2 * N)
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String word : wordList){
            set.add(word);
        }
        
        if(!set.contains(endWord))
            return 0;
        
        Queue<String> queue = new LinkedList<>();
        
        queue.offer(beginWord);
        int level = 1;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                
                String currentWord = queue.poll();
                
                char[] currentWordChar = currentWord.toCharArray();
                
                for(int j = 0; j < currentWordChar.length; j++){
                    
                    char originalChar = currentWordChar[j];
                    
                    for(char c = 'a'; c <= 'z'; c++){
                        
                        if(originalChar == c) continue;
                        
                        currentWordChar[j] = c;
                        
                        String newWord = String.valueOf(currentWordChar);
                        
                        if(newWord.equals(endWord)) return level + 1;
                        
                        if(set.contains(newWord)){
                            queue.offer(newWord);
                            // For not to get duplicate result
                            set.remove(newWord);
                        }
                    }
                    currentWordChar[j] = originalChar;
                }
            }
            level++;
        }
        
        return 0;
    }
}