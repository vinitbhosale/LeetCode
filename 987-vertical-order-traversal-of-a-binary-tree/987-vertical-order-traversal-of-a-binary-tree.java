/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// DFS

class Solution {
    private  Map<Integer, ArrayList<Pair<Integer, Integer>>> col_table;
    int minCol, maxCol;
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        col_table = new HashMap<>();
        minCol = 0;
        maxCol = 0;
        
        List<List<Integer>>  result = new ArrayList<>();
        
        if(root == null) return result;
        
        dfs(root, 0, 0);
        
        for(int i = minCol; i <= maxCol; i++){
            Collections.sort(col_table.get(i), new Comparator<Pair<Integer, Integer>>(){
               @Override
                public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2){
                    if(p1.getKey().equals(p2.getKey()))
                        return p1.getValue() - p2.getValue();
                    else
                        return p1.getKey() - p2.getKey();
                }
            });
            
            List<Integer> sortedCol = new ArrayList<>();
            for(Pair<Integer, Integer> p : col_table.get(i))
                sortedCol.add(p.getValue());
            
            result.add(sortedCol);
        }
        
        return result;
        
        
        
    }
    
    private void dfs(TreeNode node, int row, int col){
        if(node == null) return;
        
        if(!col_table.containsKey(col))
            col_table.put(col, new ArrayList<Pair<Integer, Integer>>());
        
        col_table.get(col).add(new Pair<>(row, node.val));
        minCol = Math.min(minCol, col);
        maxCol = Math.max(maxCol, col);
        
        dfs(node.left, row + 1, col - 1);
        dfs(node.right, row + 1, col + 1);
    }
}
//-----------------------------------------------------------------------------------------------------//
// BFS
class Solution { 

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if(root == null) return result;
        
        Map<Integer, ArrayList<Pair<Integer, Integer>>> col_table;
        int minCol, maxCol;
        
        col_table = new HashMap<>();
        minCol = 0;
        maxCol = 0;
        
        Queue<Pair<TreeNode, Pair<Integer, Integer>>> queue = new ArrayDeque();
        int row = 0;
        int col = 0;
        queue.offer(new Pair(root, new Pair(row, col)));
        
        while(!queue.isEmpty()){
            Pair<TreeNode, Pair<Integer, Integer>> current_pair = queue.poll();
            
            TreeNode current_node = current_pair.getKey();
            row = current_pair.getValue().getKey();
            col = current_pair.getValue().getValue();
            
            col_table.putIfAbsent(col, new ArrayList<Pair<Integer, Integer>>());
            col_table.get(col).add(new Pair<>(row, current_node.val));
            
            minCol = Math.min(minCol, col);
            maxCol = Math.max(maxCol, col);
            
            if(current_node.left != null)
                queue.offer(new Pair(current_node.left, new Pair(row + 1, col - 1)));
            if(current_node.right != null)
                queue.offer(new Pair(current_node.right, new Pair(row + 1, col + 1)));
            
        }
        
         for(int i = minCol; i <= maxCol; i++){
            Collections.sort(col_table.get(i), new Comparator<Pair<Integer, Integer>>(){
               @Override
                public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2){
                    if(p1.getKey().equals(p2.getKey()))
                        return p1.getValue() - p2.getValue();
                    else
                        return p1.getKey() - p2.getKey();
                }
            });
            
            List<Integer> sortedCol = new ArrayList<>();
            for(Pair<Integer, Integer> p : col_table.get(i))
                sortedCol.add(p.getValue());
            
            result.add(sortedCol);
        }
        
        return result;
        
    }

}
