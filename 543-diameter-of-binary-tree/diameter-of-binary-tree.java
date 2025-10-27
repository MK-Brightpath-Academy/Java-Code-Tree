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
    public int diameterOfBinaryTree(TreeNode root) {
         return helper(root)[1]; // [0] = height, [1] = diameter
    }

    private int[] helper(TreeNode node) {
        if (node == null) return new int[]{0, 0};

        int[] left = helper(node.left);
        int[] right = helper(node.right);

        int height = 1 + Math.max(left[0], right[0]);
        int diameter = Math.max(left[0] + right[0], Math.max(left[1], right[1]));

        return new int[]{height, diameter};

    }
}