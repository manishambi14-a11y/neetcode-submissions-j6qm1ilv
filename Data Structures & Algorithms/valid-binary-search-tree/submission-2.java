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
    public boolean isValidBST(TreeNode root) {
        int min = -10001;
        int max = 10001;
        return dfs(root, min, max);
    }
    private boolean dfs(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        } 
        if (root.val >= max || root.val <= min) {
            return false;
        }
        return true && dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
    }
}







