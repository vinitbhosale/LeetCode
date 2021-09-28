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
    public int goodNodes(TreeNode root) {
        int max = Integer.MIN_VALUE;
        
        return dfs(root, max);
    }
    
    private int dfs(TreeNode node, int max) {
        // base condition
        if(node == null) return 0;
        
        int count = node.val >= max ? 1 : 0;
        
        count += dfs(node.left, Math.max(node.val, max));
        count += dfs(node.right, Math.max(node.val, max));
        
        return count;
    }
}