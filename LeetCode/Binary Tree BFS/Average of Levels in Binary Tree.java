class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        if(root == null) return new ArrayList<>();
        ArrayList<Double> result = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty()){
            int levelsize = q.size();
            double sum = 0;
            for(int i=0; i<levelsize; i++){
                TreeNode curr = q.poll();
                sum += curr.val;
                if(curr.left != null){
                   q.offer(curr.left);
                }
                if(curr.right != null){
                   q.offer(curr.right);
                }
            } 
            double avg = sum / levelsize;
            result.add(avg);
        }
        return result;
    }
}