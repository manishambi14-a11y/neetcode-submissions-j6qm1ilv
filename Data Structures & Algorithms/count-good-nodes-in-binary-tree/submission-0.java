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
    public int goodNodes(TreeNode root) {
        int res[] = new int[1];
        int prev = -101;
        dfs(root, res, prev);
        return res[0];
    }
    private void dfs(TreeNode root, int[] res, int prev) {
        if (root == null) {
            return;
        }
        if (root.val >= prev) {
            prev = Math.max(root.val, prev);
            res[0] = res[0] + 1;
        }
        dfs(root.left, res, prev);
        dfs(root.right, res, prev);
    }
}
