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
    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> pq = new LinkedList<>();
        if (root == null) {
            return root;
        }
        pq.offer(root);
        while (pq.size() > 0) {
            TreeNode node = pq.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null) {
                pq.offer(node.left);
            }
            if (node.right != null) {
                pq.offer(node.right);
            }
        }
        return root;
    }
}










