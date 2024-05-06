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
    public List<String> binaryTreePaths(TreeNode root) {
     if (root == null) {
      return null;
     }
     List<String> left = binaryTreePaths(root.left);
     List<String> right = binaryTreePaths(root.right);
     List<String> ans = new ArrayList<>();
     String result = String.valueOf(root.val);
     if (left != null) {
      for (String smallAns: left) {
        ans.add(result + "->" + smallAns);
      }
     }
     


    }

    
}