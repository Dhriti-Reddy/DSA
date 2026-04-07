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
    int preorderindex = 0;
    int[] preorder;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        } 
        return subTree(0, inorder.length-1);
    }
    public TreeNode subTree(int left, int right){
        if(left > right){
            return null;
        }
        int rootvalue = preorder[preorderindex];
        preorderindex++;
        int inorderindex = map.get(rootvalue);

        TreeNode root = new TreeNode(rootvalue);
        root.left = subTree(left, inorderindex-1);
        root.right= subTree(inorderindex+1, right);

        return root;
    }
}