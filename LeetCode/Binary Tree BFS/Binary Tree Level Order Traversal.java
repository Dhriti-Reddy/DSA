class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty()){
            int levelsize = q.size();
            ArrayList<Integer> level = new ArrayList<>();
            for(int i=0; i<levelsize; i++){
                TreeNode curr = q.poll();
                level.add(curr.val);
                if(curr.left != null){
                    q.offer(curr.left);
                } 
                if(curr.right != null){
                    q.offer(curr.right);
                }
            }
            result.add(level);
        }
        return result;
    }
}   