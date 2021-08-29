class Solution {
    // Time Complexity O(N * logN) N: number of logs Space Complexity O(logN)
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            // log1 < log2 = -1
            // log1 == log2 = 0
            // log1 > log2 = 1 
            
            // log1
            int index1 = log1.indexOf(" ");
            String id1 = log1.substring(0, index1);
            String main1 = log1.substring(index1 + 1);
            
            // log2
            int index2 = log2.indexOf(" ");
            String id2 = log2.substring(0, index2);
            String main2 = log2.substring(index2 + 1);
            
            boolean isDigit1 = Character.isDigit(main1.charAt(0));
            boolean isDigit2 = Character.isDigit(main2.charAt(0));
            
            // Both logs are letter log
            if(!isDigit1 && !isDigit2){
                // check to if logs are same
                int value = main1.compareTo(main2);
                // Same then based on the logs ID
                if(value == 0) return id1.compareTo(id2);
                // else arrange based on comparator
                return value;
            }
            
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });   
        
        return logs;
    }
}