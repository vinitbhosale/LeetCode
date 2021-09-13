class Solution {
    // Time Complexityv O(ELogE) and Space Complexity O(E)
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> graph = new HashMap<>();
        
        for(List<String> ticket : tickets){
            graph.putIfAbsent(ticket.get(0), new PriorityQueue<String>((a,b) -> a.compareTo(b)));
            graph.get(ticket.get(0)).add(ticket.get(1));
        }
        
        List<String> result = new ArrayList<>();
        dfs(graph, result, "JFK");
        
        return result;
        
    }
    
    private void dfs(HashMap<String, PriorityQueue<String>> graph, List<String> result, String s){
        PriorityQueue<String> destination = graph.get(s);
        while(destination != null && !destination.isEmpty()){
            String dest = destination.poll();
            dfs(graph, result, dest);
        }
        result.add(0, s);
        
    }
}