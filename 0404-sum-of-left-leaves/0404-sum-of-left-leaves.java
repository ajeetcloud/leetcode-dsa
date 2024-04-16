/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
  public int sumOfLeftLeaves(TreeNode root) {
    return sumOfLeftLeaves(root, -1);
  }

  public int sumOfLeftLeaves(TreeNode root, int path) {
    if (root == null) {
      return 0;
    }
    if (root.left == null && root.right == null && path == 0) {
      return root.val;
    }
    int sum = 0;
    sum += sumOfLeftLeaves(root.left, 0);
    sum += sumOfLeftLeaves(root.right, 1);

    return sum;
  }
}