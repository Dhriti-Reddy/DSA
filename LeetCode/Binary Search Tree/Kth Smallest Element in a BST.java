class Solution {
    int count = 0;
    int var;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return var;
    }
    public void inorder(TreeNode curr, int k){
        if(curr == null) return;
        inorder(curr.left, k);
        count++;
        if(count == k){
            var = curr.val;
            return;
        }
        inorder(curr.right, k);
    }
}