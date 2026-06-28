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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        return dfs(root, p, q);
    }

    private TreeNode dfs(TreeNode node, TreeNode p, TreeNode q) {
        
        if (node == null) {
            return null;
        }

        if (node == p || node == q) {
            return node;
        }

        TreeNode leftAns = dfs(node.left, p, q);
        TreeNode rightAns = dfs(node.right, p, q);

        if (leftAns != null && rightAns != null) {
            return node;
        }
        if (leftAns != null) {
            return leftAns;
        }
        return rightAns;
    }
}