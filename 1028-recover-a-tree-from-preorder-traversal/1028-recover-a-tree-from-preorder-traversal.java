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

record NodePair(int nodeVal, int depth) {}

class Solution {
    public TreeNode recoverFromPreorder(String traversal) {

        Queue<NodePair> queue = new ArrayDeque<>();
        int i = 0;
        int n = traversal.length();
        while (i < n) {
            int dashes = 0;
            while (i < n && traversal.charAt(i) == '-') {
                dashes++;
                i++;
            }
            int val = 0;
            while (i < n && Character.isDigit(traversal.charAt(i))) {
                val = val * 10 + (traversal.charAt(i) - '0');
                i++;
            }
            queue.offer(new NodePair(val, dashes));
        }
        return dfs(queue, -1);
    }

    private TreeNode dfs(Queue<NodePair> queue, int currentDepth) {

        if (queue.isEmpty() || queue.peek().depth() <= currentDepth) {
            return null;
        }
        NodePair node = queue.poll();
        // visit
        TreeNode treeNode = new TreeNode(node.nodeVal());
        treeNode.left = dfs(queue, node.depth());
        treeNode.right = dfs(queue, node.depth());

        return treeNode;
    }
}