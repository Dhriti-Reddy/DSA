class Solution {
    public boolean canJump(int[] nums) {
        int farthestreach = 0;
        int possiblereach = 0;
        for(int i=0; i<nums.length; i++){
            if(i > farthestreach){
                return false;
            }
            else{
                possiblereach = i + nums[i];
                if(farthestreach < possiblereach){
                    farthestreach = possiblereach;
                }
            }
        }
        return true;
    }
}