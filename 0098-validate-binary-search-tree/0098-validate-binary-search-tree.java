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
    public boolean isValidBST(TreeNode root) {

        return dfs(root, null, null);
    }

    private boolean dfs(TreeNode current, Integer min, Integer max) {

        if (current == null) {
            return true;
        }

        if (min != null && current.val <= min) {
            return false;
        }
        if (max != null && current.val >= max) {
            return false;
        }

        return dfs(current.left, min, current.val) && dfs(current.right, current.val, max);
    }
}