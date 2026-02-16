class Solution {
    public int[] rearrangeArray(int[] nums) {
        int posindex = 0;
        int negindex = 1;
        int[] result = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            if(nums[i] > 0){
                result[posindex] = nums[i];
                posindex += 2;
            }
            else{
                result[negindex] = nums[i];
                negindex += 2;
            }
        }
        return result;
    }
}