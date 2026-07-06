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

    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        
        result = new ArrayList<>();
        dfs(root, 1);

        return result;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (result.size() < depth) {
            result.add(root.val);
        }   
        int newDepth = depth + 1;
        dfs(root.right, newDepth);
        dfs(root.left, newDepth);
    }
}



