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

    // These serve like a scoreboard for top down DFS
    private int count = 0;
    private int result = 0;

    // This is iterative solution
    public int kthSmallest(TreeNode root, int k) {
        
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode current = root;

        while (true) {
            while (current != null) {   // dive left loop
                stack.push(current);
                current = current.left;
            }
            if (stack.isEmpty()) {
                break;
            }
            current = stack.pop();
            k--;
            if (k == 0) {
                return current.val;
            }
            current = current.right;
        }
        return -1;
    }

    public int kthSmallestRecursion(TreeNode root, int k) {

        dfsInorder(root, k);
        return result;
    }

    // Inorder
    private void dfsInorder(TreeNode node, int k) {

        if (node == null || count >= k) {
            return;
        }
        dfsInorder(node.left, k);
        // Visit
        count++;
        if (count == k) {
            result = node.val;
            return;
        }
        dfsInorder(node.right, k);
    }
}
