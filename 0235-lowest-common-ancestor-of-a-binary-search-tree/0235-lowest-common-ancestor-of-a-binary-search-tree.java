/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    return getLCA(root, p.val, q.val);
  }

  public static TreeNode getLCA(TreeNode root, int a, int b) {
    if (root == null) {
      return null;
    }
    if (root.val == a || root.val == b) {
      return root;
    }

    if ((root.val > b && root.val < a) || (root.val > a && root.val < b)) {
      return root;
    }
    if (root.val < a && root.val < b) {
      return getLCA(root.right, a, b);
    }

    return getLCA(root.left, a, b);
  }
}