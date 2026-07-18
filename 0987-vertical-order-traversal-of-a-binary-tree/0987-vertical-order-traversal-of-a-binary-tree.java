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
record Triplet(int col, int row, int val) {}
class Solution {

    List<Triplet> triplets = new ArrayList<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        dfs(root, 0, 0);
        triplets.sort((a, b) -> {
            if (a.col() != b.col()) return Integer.compare(a.col(), b.col());
            if (a.row() != b.row()) return Integer.compare(a.row(), b.row()) ;
            return Integer.compare(a.val(), b.val()); // value is tie-breaker
        });
        
        int col = Integer.MIN_VALUE;
        // Now create the result via grouping triplets
        for (Triplet triplet: triplets) {
            int currentCol = triplet.col();
            if (col != currentCol) {
                result.add(new ArrayList<>());
                col = currentCol;
            }
            // get the last triplet and add current value
            result.get(result.size() - 1).add(triplet.val());
        }
        return result;
    }

    private void dfs(TreeNode node, int col, int row) {
        if (node == null) {
            return;
        }
        // PreOrder
        // Visit first
        triplets.add(new Triplet(col, row, node.val));
        
        dfs(node.left, col - 1, row + 1); // go left
        dfs(node.right, col + 1,row + 1); // go right
    }
}
