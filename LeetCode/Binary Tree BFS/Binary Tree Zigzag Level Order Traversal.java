class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        boolean lefttoright = true;
        while(!q.isEmpty()){
            int levelsize = q.size();
            ArrayList<Integer> level = new ArrayList<>();
            for(int i=0; i<levelsize; i++){
                TreeNode curr = q.poll();
                if(lefttoright){
                    level.add(curr.val);
                }
                else{
                    level.add(0, curr.val);
                }
                if(curr.left != null){
                    q.offer(curr.left);
                } 
                if(curr.right != null){
                    q.offer(curr.right);
                }
            }
            result.add(level);
            lefttoright = !lefttoright;
        }
        return result;
    }
}

        
       