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

    boolean seen = false;
    TreeNode successor = null;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        
        dfs(root, p);
        return successor;
    }

    // This does not use the BST property
    private void dfs(TreeNode node, TreeNode p) {

        if (node == null || successor != null) {
            return;
        }
        dfs(node.left, p);
        if (successor != null) {
            return;
        }
        // visit
        if (seen) {
            successor = node;
            return;
        }
        if (node.val == p.val) {
            seen = true;
        }
        dfs(node.right, p);
        
    }
}