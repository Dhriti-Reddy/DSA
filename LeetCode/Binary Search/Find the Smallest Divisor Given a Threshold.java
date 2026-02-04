class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = 0;
        for(int num : nums){
            if(high < num){
                high = num;
            }
        }

        while(low <= high){
            int mid = low + (high - low)/2;
            long total = 0;
            for(int i=0; i<nums.length; i++){
                total += (nums[i] + mid - 1L) / mid;
            }
            if(total <= threshold){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }
}