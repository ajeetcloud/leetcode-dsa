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

        private Set<Integer> toDelete;
        private List<TreeNode> forest;

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        forest = new ArrayList<>();
        toDelete = new HashSet<>();
        for (int val: to_delete) {
            toDelete.add(val);
        }
        // If root is not to be deleted, have to handle edge case
        if (!toDelete.contains(root.val)) {
            forest.add(root);
        }
        dfs(root);

        return forest;
    }

    private TreeNode dfs(TreeNode node) {

        if (node == null) {
            return null;
        }

        // post-order
        node.left = dfs(node.left);
        node.right = dfs(node.right);

        // visit
        if (toDelete.contains(node.val)) {
            if (node.left != null) {
                forest.add(node.left);
            }
            if (node.right != null) {
                forest.add(node.right);
            }
            return null;
        }
        return node;
    }
}



























