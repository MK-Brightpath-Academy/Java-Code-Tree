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
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> seen = new HashSet<>();
        return dfs(root, seen, k);
    }

    private boolean dfs(TreeNode node, Set<Integer> seen, int k) {
        if (node == null) return false;

        if (seen.contains(k - node.val)) {
            return true;
        }
        seen.add(node.val);

        return dfs(node.left, seen, k) || dfs(node.right, seen, k);
    }
}