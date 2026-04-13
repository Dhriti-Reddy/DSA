class Solution {
    int absdiff = Integer.MAX_VALUE;
    TreeNode prev = null;
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return absdiff;
    }
    public void inorder(TreeNode curr){
        if(curr == null) return;
        inorder(curr.left);
        if(prev != null){
            int diff = curr.val - prev.val;
            if(diff < absdiff){
                absdiff = diff;
            }
        }
        prev = curr;
        inorder(curr.right);
    }
}
