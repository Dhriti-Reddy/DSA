class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean helper(TreeNode curr, long minval, long maxval){
        if(curr == null) return true;
        if(curr.val <= minval || curr.val >= maxval) return false;
        boolean left = helper(curr.left, minval, curr.val);
        boolean right = helper(curr.right, curr.val, maxval);
        return (left && right);
    }
}