/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {

    int diameter = 0;

    public int diameter(Node root) {

        dfs(root);
        return diameter;
    }

    private int dfs(Node root) {

        int best1 = 0;
        int best2 = 0;

        if (root == null) {
            return 0;
        }

        List<Node> children = root.children;

        for (Node child : children) {

            int childHeight = 1 + dfs(child);
            if (childHeight > best1) {
                best2 = best1;
                best1 = childHeight;
            } 
            else if (childHeight > best2) {
                best2 = childHeight;
            }
        }

        diameter = Math.max(diameter, (best1 + best2));

        return best1;
    }
}
