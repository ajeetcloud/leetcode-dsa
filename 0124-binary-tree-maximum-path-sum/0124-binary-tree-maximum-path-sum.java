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

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        gain(root);
        return maxSum;    
    }

    private int gain(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int leftGain = Math.max(0, gain(node.left));
        int rightGain = Math.max(0, gain(node.right));

        maxSum = Math.max(maxSum, leftGain + node.val + rightGain);
        return node.val + Math.max(leftGain, rightGain);
    }
}




