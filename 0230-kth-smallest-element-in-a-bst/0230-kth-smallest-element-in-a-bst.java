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

    private int count = 0;
    private int result = 0;

    public int kthSmallest(TreeNode root, int k) {

        dfs(root, k);
        return result;
    }

    // Inorder
    private void dfs(TreeNode node, int k) {

        if (node == null || count >= k) {
            return;
        }
        dfs(node.left, k);
        // Visit
        count++;
        if (count == k) {
            result = node.val;
            return;
        }
        dfs(node.right, k);
       
    }
}