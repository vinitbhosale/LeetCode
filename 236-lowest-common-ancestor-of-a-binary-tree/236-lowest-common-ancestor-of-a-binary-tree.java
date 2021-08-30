/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // DFS Time O(N) Space O(N)
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        return dfs(root, p , q);
    }
    
    private TreeNode dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return null;
        
        if(root == p || root == q) return root;
        
        TreeNode left = dfs(root.left, p ,q);
        TreeNode right = dfs(root.right, p ,q);
        
        if(left != null && right != null) 
            return root;
        else
            return left != null ? left : right;
    }
    

//---------------------------------------------------------------------------------------------------------------//
    
    //BFS Time O(N) Space O(N)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        Stack<TreeNode> stack = new Stack<>();
        
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        
        parents.put(root, null);
        stack.push(root);
        
        while(!parents.containsKey(p) || !parents.containsKey(q)){
            TreeNode node = stack.pop();
            if(node.left != null){
                parents.put(node.left, node);
                stack.push(node.left);
            }
            if(node.right != null){
                parents.put(node.right, node);
                stack.push(node.right);
            }
        }
        
        Set<TreeNode> ancestor = new HashSet<>();
       
        // parents.entrySet().forEach(entry -> {
        //     TreeNode key = entry.getKey();
        //     TreeNode value = entry.getValue();
        //    System.out.println( "Key: "+key.val+" "+"value: " +(value != null ? value.val : ""));
        // });
        
        
        while(p!=null){
            ancestor.add(p);
            p = parents.get(p);
        }
        
        while(!ancestor.contains(q))
            q = parents.get(q);
        
        return q;
    }
}
