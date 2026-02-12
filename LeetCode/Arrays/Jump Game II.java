class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int currentend = 0;
        int farthest = 0;
        for(int i=0; i<nums.length-1; i++){
            int possible = i + nums[i];
            if(farthest < possible){
                farthest = possible;
            }
            if(i == currentend){
                jumps += 1;
                currentend = farthest;
            }
        }
        return jumps;
    }
}