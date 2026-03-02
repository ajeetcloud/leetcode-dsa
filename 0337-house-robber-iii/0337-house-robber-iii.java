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

record Pair(int robResult, int notRobResult) {}

class Solution {
    public int rob(TreeNode root) {

        Pair result = robHelper(root);

        return Math.max(result.robResult(), result.notRobResult()); 
    }

    private Pair robHelper(TreeNode root) {

        if (root == null) {
            return new Pair(0, 0);
        }

        Pair leftChildAns = robHelper(root.left);
        Pair rightChildAns = robHelper(root.right);

        int rootRobResult = root.val + leftChildAns.notRobResult() + rightChildAns.notRobResult();

        int rootNotRobResult = Math.max(leftChildAns.robResult(), leftChildAns.notRobResult())
                                + Math.max(rightChildAns.robResult(), rightChildAns.notRobResult());

        // Now root decides after childern got the answer
        Pair rootAns = new Pair(rootRobResult, rootNotRobResult);

        return rootAns;
    }
}
