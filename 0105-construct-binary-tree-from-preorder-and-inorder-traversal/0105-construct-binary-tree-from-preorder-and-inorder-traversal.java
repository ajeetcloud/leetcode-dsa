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

    Map<Integer, Integer> inOrderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        int length = preorder.length;
        for (int i = 0; i < length; i++) {
            inOrderMap.put(inorder[i], i);
        }
        return dfs(preorder, inorder, 0, length - 1, 0, length - 1);
    }

private TreeNode dfs(int[] preorder, int[] inorder, int startIndexPre, int endIndexPre, int startIndexIn,
int endIndexIn) {

    if (startIndexPre > endIndexPre || startIndexIn > endIndexIn) {
        return null;
    }

    TreeNode root = new TreeNode(preorder[startIndexPre]);
    int inOrderRootIndex = inOrderMap.get(root.val);
    int elementsInLeftSubTree = inOrderRootIndex - startIndexIn;
    /*
    // For loop makes it quadratic time complexity, using map brings it back to linear
    for (int i = startIndexIn; i <= endIndexIn; i++) {
        if (inorder[i] == root.val) {
            inOrderRootIndex = i;
            break;
        }
        elementsInLeftSubTree++;
    }
    */

    root.left = dfs(preorder, inorder, startIndexPre + 1, startIndexPre + elementsInLeftSubTree, startIndexIn, inOrderRootIndex - 1);
    root.right = dfs(preorder, inorder, startIndexPre + elementsInLeftSubTree + 1, endIndexPre, inOrderRootIndex + 1, endIndexIn);

    return root;
}
}




















