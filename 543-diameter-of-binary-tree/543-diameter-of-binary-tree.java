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
    // Time Complexity O(N) and Space Complexity O(N)
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return -1;
        ans = 1;
        traverseTree(root);
        return ans - 1;
    }
    
    public int traverseTree(TreeNode node){
        if(node == null) return 0;
       
        int left = traverseTree(node.left);
        int right = traverseTree(node.right);
        
        ans = Math.max(ans, left + right + 1);
        System.out.println(node.val +" "+ans);
        return Math.max(left, right) + 1;
        
           
        
    }
}