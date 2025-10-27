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
    public int sumOfLeftLeaves(TreeNode root) {
         if (root == null) return 0;
        int sum = 0;

        // Check if left child is a leaf
        if (isLeaf(root.left)) {
            sum += root.left.val;
        } else {
            // Recur on left subtree if not a leaf
            sum += sumOfLeftLeaves(root.left);
        }

        // Always recur on right subtree
        sum += sumOfLeftLeaves(root.right);

        return sum;
    }

    private boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }
}