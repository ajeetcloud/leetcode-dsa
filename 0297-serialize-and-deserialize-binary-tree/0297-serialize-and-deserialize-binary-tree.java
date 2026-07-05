/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    private int index = 0;

    public String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();
        dfs(root, sb);

        return sb.toString();
    }

    private void dfs(TreeNode node, StringBuilder sb) {

        if (node == null) {
            sb.append("n").append(",");
            return;
        }
        
        // visit
        sb.append(node.val).append(",");

        dfs(node.left, sb);
        dfs(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        Queue<String> queue = new ArrayDeque<>(Arrays.asList(data.split(",")));
        return deserializeDfsQueue(queue);
    }

    // This is DFS Recursive with Queue 
    private TreeNode deserializeDfsQueue(Queue<String> queue) {
        String token = queue.poll();
        if (token.equals("n")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(token));
        node.left = deserializeDfsQueue(queue);
        node.right = deserializeDfsQueue(queue);

        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));