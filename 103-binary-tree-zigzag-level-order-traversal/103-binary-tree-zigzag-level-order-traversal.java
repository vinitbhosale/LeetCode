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
    // BFS Time Complexity O(N) and Space Complexity O(N)
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if(root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            
            List<Integer> currentLevel = new ArrayList<>();
            
            for(int i = 0; i < size; i++){
                TreeNode curr = queue.remove();
                
                if(curr.left != null){
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }
                if(level % 2 == 0){
                    currentLevel.add(curr.val);
                }else{
                    currentLevel.add(0,curr.val);
                }
                
            }
            level++;
            result.add(currentLevel);
        }
        
        return result;
    }
    
//---------------------------------------------------------------------------------------//
// DFS Time Complexity O(N) and Space Complexity O(log N)
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if(root == null) return result;
        
        dfs(root, 0, result);
        
        return result;
    }
    
    private void dfs(TreeNode root, int level, List<List<Integer>> result) {
        
        if(level == result.size()){
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            result.add(list);
        }else {
            if (level % 2 == 0)
                result.get(level).add(root.val);
            else
                result.get(level).add(0, root.val);
        }
        
        if(root.left != null)
            dfs(root.left, level + 1, result);
        if(root.right != null)
            dfs(root.right, level + 1, result);
        
    }
}
