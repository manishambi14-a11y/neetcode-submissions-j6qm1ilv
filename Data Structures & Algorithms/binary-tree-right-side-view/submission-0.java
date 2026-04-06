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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode rightSide = null;
            int len = q.size();
            for (int i = 0; i < len; i++) {
                TreeNode temp = q.poll();
                if (temp != null) {
                    rightSide = temp;
                    q.add(temp.left);
                    q.add(temp.right);
                }
            }
            if (rightSide != null) {
                list.add(rightSide.val);
            }
        }
        return list;
    }
}







