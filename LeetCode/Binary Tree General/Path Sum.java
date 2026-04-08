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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;

        if(root.left == null && root.right == null){
            return targetSum == root.val;
        }

        int remaining = targetSum - root.val;

        boolean leftcheck = hasPathSum(root.left, remaining);
        boolean rightcheck = hasPathSum(root.right, remaining);

        return leftcheck || rightcheck;
    }
}