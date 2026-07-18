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
record Pair(int col, TreeNode node) {}
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Map<Integer, List<Integer>> colToElements = new HashMap<>();

        int minColIndex = Integer.MAX_VALUE;
        int maxColIndex = Integer.MIN_VALUE;

        // BFS takes care of row wise sorting and left to right elements
        Queue<Pair> queue = new ArrayDeque<>();
        Pair rootPair = new Pair(0, root);
        queue.offer(rootPair);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {

                Pair pairNode = queue.poll();
                TreeNode node = pairNode.node();
                int currentCol = pairNode.col();

                colToElements.computeIfAbsent(currentCol, k -> new ArrayList<>()).add(node.val);

                if (node.left != null) {
                    queue.offer(new Pair(currentCol - 1, node.left));
                }
                if (node.right != null) {
                    queue.offer(new Pair(currentCol + 1, node.right));
                }
                minColIndex = Math.min(minColIndex, currentCol);
                maxColIndex = Math.max(maxColIndex, currentCol);
            }
        }


        // 2. collect in result from colToElements
        for (int i = minColIndex; i <= maxColIndex; i++) {
            result.add(new ArrayList<>());
            result.get(result.size() - 1).addAll(colToElements.get(i));
        }
        return result;
    }
}
