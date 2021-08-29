class Solution {
    private class Visit {
        String userName;
        int timeStamp;
        String website;
        
        public Visit(String user, int time, String website) {
            this.userName = user;
            this.timeStamp = time;
            this.website = website;
        }
    }
    
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        
        List<Visit> visitList = new ArrayList<>();
        
        for(int i = 0; i < username.length; i++){
            visitList.add(new Visit(username[i], timestamp[i], website[i]));
        }
        
        // sorting the visitList based on the timestamp
        Comparator<Visit> cmp = (v1, v2) -> { return v1.timeStamp - v2.timeStamp; };
        Collections.sort(visitList, cmp);
        
        // creating map of user and all the visited website of that user
        Map<String, List<String>> userWebsiteMap = new HashMap<>();
        
        for(Visit v : visitList){
           
            userWebsiteMap.putIfAbsent(v.userName, new ArrayList<>());
            
            userWebsiteMap.get(v.userName).add(v.website);
        }
        
        // getting count for each sequence
        Map<List<String>, Integer> freqMap = new HashMap<>();
        
        for(List<String> webList : userWebsiteMap.values()){
            
            // condition to avoid the number of wesite visited by user are less than 3
            if(webList.size() < 3)
                continue;
            Set<List<String>> sequenceSet = getSequence(webList);
            
            for(List<String> seq : sequenceSet){
                
                freqMap.putIfAbsent(seq, 0);
                
                freqMap.put(seq, freqMap.get(seq) + 1);
            }
        }
        
        List<String> result = new ArrayList<>();
        int max = 0;
        
        for(Map.Entry<List<String>, Integer> entry : freqMap.entrySet()){
            if(entry.getValue() > max){
                max = entry.getValue();
                result = entry.getKey();
            }else if(entry.getValue() == max){
                if(entry.getKey().toString().compareTo(result.toString()) < 0){
                    result = entry.getKey();
                }
            }
        }
        
        return result;
        
    }
    
    private Set<List<String>> getSequence(List<String> webList) {
        Set<List<String>> seqList = new HashSet<>();
        
        for(int i = 0; i < webList.size(); i++){
            for(int j = i + 1; j < webList.size(); j++){
                for(int k = j + 1; k < webList.size(); k++){
                    List<String> list = new ArrayList<>();
                    list.add(webList.get(i));
                    list.add(webList.get(j));
                    list.add(webList.get(k));
                    
                    seqList.add(list);
                }
            }
        }
        
        return seqList;
    }
}