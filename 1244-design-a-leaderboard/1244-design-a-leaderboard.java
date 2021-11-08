class Leaderboard {
    
    private Map<Integer, Integer> scores;
    public Leaderboard() {
        scores = new HashMap<>();
    }
    
    public void addScore(int playerId, int score) {
        if(!scores.containsKey(playerId))
            scores.put(playerId, 0);

        scores.put(playerId, scores.get(playerId) + score);
        
    }
    
    public int top(int K) {
        Queue<Integer> q = new PriorityQueue<>((a, b) -> scores.get(a) - scores.get(b));
        
        int total = 0;
        for(Integer entry : scores.keySet()){
            q.offer(entry);
            if(q.size() > K)
                q.poll();
             
        }
        while(!q.isEmpty()){
            total += scores.get(q.poll());
        }
        
        return total;
        
    }
    
    public void reset(int playerId) {
        scores.put(playerId, 0);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */