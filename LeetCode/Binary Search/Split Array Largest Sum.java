class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0;
        for(int num : nums){
            if(low < num){
                low = num;
            }
        }
        int high = 0;
        for (int i=0; i<nums.length; i++){
                high += nums[i];
            }
        

        while(low <= high){
            int mid = low + (high - low)/2;
            int sum = 0;
            int x = 1;
            for (int i = 0; i < nums.length; i++){
                sum += nums[i];
                if(sum > mid){
                    x += 1;
                    sum = nums[i];
                }
            }

            if(x <= k){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }
}