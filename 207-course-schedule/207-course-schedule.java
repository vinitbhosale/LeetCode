class Solution {
    //dfs 
    // Time Complexity O(E + V) and Space Complexity O(E + V)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0)return true;
        
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<Integer>());
        
        for(int[] pre : prerequisites)
            graph.get(pre[1]).add(pre[0]);
        
        int[] visited = new int[numCourses];
        
        for(int i = 0; i < numCourses; i++)
            if(!dfs(graph, visited, i)) return false;
        
        return true;
    }
    
    private boolean dfs(List<List<Integer>> graph, int[] visited, int v){
        visited[v] = 1;
        
        List<Integer> adj = graph.get(v);
        
        for(int i = 0; i < adj.size(); i++){
            int eligibleCourse = adj.get(i);
            if(visited[eligibleCourse] == 1) return false;
            
            if(visited[eligibleCourse] == 0)
                if(!dfs(graph, visited, eligibleCourse)) return false;
        }
        
        visited[v] = 2;
        
        return true;
    }
    
//------------------------------------------------------------------------------------------//   
    
    // BFS
    // Time Complexity O(E + V) and Space Complexity O(E + V)
    public boolean canFinish(int numCourses, int[][] prerequisites){
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<Integer>());
        
        int[] inDegree = new int[numCourses];
        for(int[] pre : prerequisites){
            graph.get(pre[1]).add(pre[0]);
            inDegree[pre[0]]++;
        }
            
            
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++)
            if(inDegree[i] == 0) queue.add(i);
        
        while(!queue.isEmpty()){
            int current = queue.remove();
            for(int courses : graph.get(current)){
                inDegree[courses]--;
                if(inDegree[courses] == 0) queue.add(courses);
            }
            numCourses--;
        }
        
        return numCourses == 0;
    }
}
