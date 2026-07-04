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

record Frame(TreeNode node, boolean expanded) {}

class Solution {

    public void flatten(TreeNode root) {

        // DFS Recursive approach    
        // dfsFlatten(root);

        // Iterative DFS
        flattenIterative(root);

        // Morris provides constant space
        //morrisTraversal(root);
    }

    private void flattenIterative(TreeNode root) {

        Deque<Frame> stack = new ArrayDeque<>();
        Map<TreeNode, TreeNode> tailMap = new HashMap<>();
        stack.push(new Frame(root, false));

        while (!stack.isEmpty()) {
            Frame f = stack.pop();
            TreeNode node = f.node();
            if (node == null) {
                continue;
            }

            if (!f.expanded()) {
                stack.push(new Frame(node, true)); // 2nd time putting it
                stack.push(new Frame(node.right, false));
                stack.push(new Frame(node.left, false));
            } 
            else {
                TreeNode leftTail = tailMap.get(node.left);
                TreeNode rightTail = tailMap.get(node.right);
                if (leftTail != null) {
                    leftTail.right = node.right;
                    node.right = node.left;
                    node.left = null;
                }
                TreeNode tail;
                if (rightTail != null) {
                    tail = rightTail;
                }
                else if (leftTail != null) {
                    tail = leftTail;
                }
                else {
                    tail = node;
                }
                tailMap.put(node, tail);
            }
        }

    }

    // Constant Space traversal
    private void morrisTraversal(TreeNode root) {

        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode prev = curr.left;
                while (prev.right != null) {
                    prev = prev.right;
                }
                prev.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }

    private TreeNode dfsFlatten(TreeNode node) {

        if (node == null) {
            return null;
        }

        TreeNode leftTail = dfsFlatten(node.left);
        TreeNode rightTail = dfsFlatten(node.right);

        if (leftTail != null) {
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
        }

        if (rightTail != null) {
            return rightTail;
        }
        if (leftTail != null) {
            return leftTail;
        }

        return node;
    }
}
