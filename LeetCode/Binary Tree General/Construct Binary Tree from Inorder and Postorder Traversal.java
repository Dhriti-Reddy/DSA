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

    int postIndex;
    int[] postorder;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        this.postorder = postorder;
        postIndex = postorder.length - 1;

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return subTree(0, inorder.length - 1);
    }

    public TreeNode subTree(int left, int right) {

        if (left > right) return null;

        int rootValue = postorder[postIndex--];
        int inorderIndex = map.get(rootValue);

        TreeNode root = new TreeNode(rootValue);

        root.right = subTree(inorderIndex + 1, right);
        root.left  = subTree(left, inorderIndex - 1);

        return root;
    }
}