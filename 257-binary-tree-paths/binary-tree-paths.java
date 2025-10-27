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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        buildPaths(root, "", result);
        return result;
    }

    private void buildPaths(TreeNode node, String path, List<String> result) {
        if (node == null) return;

        // Add current node to path
        path += node.val;

        // If leaf node → store path
        if (node.left == null && node.right == null) {
            result.add(path);
        } else {
            // Not leaf → continue DFS
            path += "->";
            buildPaths(node.left, path, result);
            buildPaths(node.right, path, result);
        }
    }
}