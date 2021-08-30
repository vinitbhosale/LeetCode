class Solution {
    // DFS Time Complexity O(V + E)
//     public int[] findOrder(int numCourses, int[][] prerequisites) {
//         List<List<Integer>> graph = new ArrayList<>();
        
//         for(int i = 0; i < numCourses; i++)
//             graph.add(new ArrayList<Integer>());
        
//         for(int[] pre : prerequisites)
//             graph.get(pre[1]).add(pre[0]);
        
//         int[] result = new int[numCourses];
//         int[] visited = new int[numCourses];
//         Stack<Integer> stack = new Stack<>();
        
//         for(int i = 0; i < numCourses; i++){
//             if(visited[i] == 0 && dfs(graph, visited, stack, i)) return new int[0];
//         }
        
//          for(int i = 0; i < numCourses; i++)
//             result[i] = stack.pop();
        
//         return result;
//     }
    
//     private boolean dfs(List<List<Integer>> graph, int[] visited, Stack<Integer> stack, int v){
//         visited[v] = 1;
        
//         List<Integer> adj = graph.get(v);
        
//         for(int i = 0; i < adj.size(); i++){
//             int eligibleCourse = adj.get(i);
            // Course is already visited
//             if(visited[eligibleCourse] == 1) return true;
            
//             if(visited[eligibleCourse] == 0 && dfs(graph, visited, stack, eligibleCourse))
//                 return true;
//         }
//         stack.push(v);
//         visited[v] = 2;
//         return false;
//     }
    //----------------------------------------------------------------------------------//
    // BFS topological sort
     public int[] findOrder(int numCourses, int[][] prerequisites) {
         List<List<Integer>> graph = new ArrayList<>();
         int counter = 0;
         int index = 0;
         
         for(int i = 0; i < numCourses; i++)
             graph.add(new ArrayList<Integer>());
         
         int[] degree = new int[numCourses];
         
         for(int[] pre : prerequisites){
            graph.get(pre[1]).add(pre[0]);
            degree[pre[0]]++;
         }
         
         Queue<Integer> queue = new LinkedList<>();
         
         for(int i = 0; i < numCourses; i++){
             if(degree[i] == 0) queue.add(i);
         }
         int[] result = new int[numCourses];
         
         while(!queue.isEmpty()){
             int current = queue.remove();
             result[index++] = current;
             for(int course : graph.get(current)){
                 degree[course]--;
                 if(degree[course] == 0){
                     queue.add(course);
                 }
             }
             counter++;
         }
        
         System.out.println(counter == index);

         return counter == numCourses ? result : new int[0];
         
         
     }
}