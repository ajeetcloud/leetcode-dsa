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
    public int diameterOfBinaryTree(TreeNode root) {

        if (root == null) {
            return 0;
        }

        // one of these  can be diameter
        // 1. diameter can pass through root
        int diameter = height(root.left) + height(root.right);
        // 2. left subtree can have diameter
        int leftDiameter = diameterOfBinaryTree(root.left);
        // 3. right subtree can have diameter
        int rightDiameter = diameterOfBinaryTree(root.right);

        return Math.max(diameter, Math.max(leftDiameter, rightDiameter));
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }
}