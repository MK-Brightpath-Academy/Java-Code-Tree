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
    public int findSecondMinimumValue(TreeNode root) {
       if (root == null) return -1;
        return dfs(root, root.val);
    }

    private int dfs(TreeNode node, int minVal) {
        if (node == null) return -1;

        // If this node's value is greater than the smallest value, it could be a candidate
        if (node.val > minVal) return node.val;

        // Otherwise, check its children
        int left = dfs(node.left, minVal);
        int right = dfs(node.right, minVal);

        // If both children returned -1, means no valid second min found
        if (left == -1) return right;
        if (right == -1) return left;

        // Return the smaller of the two valid candidates
        return Math.min(left, right);  
    }
}