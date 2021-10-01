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
class Solution {
    // BFS Time Complexity O(N) and Space Complexity O(D) D: diameter of tree
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> res = new LinkedList<Integer>();
        if(root == null) return res;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i =0; i < size; i++){
                TreeNode curr = queue.poll();
                
                if(i == 0) res.add(curr.val);
                
                if(curr.right != null) queue.offer(curr.right);
                if(curr.left != null) queue.offer(curr.left);
            }
        }
        
        return res;
        
    }
//-----------------------------------------------------------------------------------//
    // DFS
    // Time Complexity O(N) and Space Complexity O(H)
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        
        dfs(root, 0, result);
        
        return result;
    }
    
    private void dfs(TreeNode root, int level, List<Integer> result){
      
        if(level == result.size())
            result.add(root.val);
        
        if(root.right != null)
            dfs(root.right, level + 1, result);
        if(root.left != null)
            dfs(root.left, level + 1, result);
    }
} 
