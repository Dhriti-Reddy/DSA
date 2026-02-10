class Solution {
    public int majorityElement(int[] nums) {
        int confidence = 1;
        int first = nums[0];
        for(int i = 1; i<nums.length; i++){
            if(confidence == 0){
                first = nums[i];
            }
            
            if(nums[i] == first){
                confidence += 1;
            }
            else{
                confidence -= 1;
            }
        }
        return first;
    }
}