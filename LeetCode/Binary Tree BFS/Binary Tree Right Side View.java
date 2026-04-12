class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty()){
            int levelsize = q.size();
            for(int i=0; i<levelsize; i++){
             TreeNode curr = q.poll();
             if(curr.left != null){
                q.offer(curr.left);
             }
             if(curr.right != null){
                q.offer(curr.right);
             }
             if(i == levelsize-1){
                result.add(curr.val);
             }
            }
        }
        return result;
    }
}