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
    public int sumRootToLeaf(TreeNode root) {
          return dfs(root, 0);
    }

    private int dfs(TreeNode node, int currentVal) {
        if (node == null) return 0;

        // Update binary number
        currentVal = (currentVal << 1) | node.val;

        // If leaf node, return the complete binary number
        if (node.left == null && node.right == null) {
            return currentVal;
        }

        // Otherwise, recurse left and right
        return dfs(node.left, currentVal) + dfs(node.right, currentVal);
  
    }
}