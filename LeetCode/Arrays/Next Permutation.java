class Solution {
    public void nextPermutation(int[] nums) {
        boolean found = false;
        for(int i=nums.length-2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                int pivot = i;
                int bigger = 0;
                for(int j=nums.length-1; j>pivot; j--){
                    if(nums[j] > nums[pivot]){
                        bigger = j;
                        break;
                    }
                }
                int temp = nums[i];
                nums[i] = nums[bigger];
                nums[bigger] = temp;

                int left = pivot+1;
                int right = nums.length-1;
                while(left < right){
                    int swap = nums[left];
                    nums[left] = nums[right];
                    nums[right] = swap;
                    left++;
                    right--;
                }
                found = true;
                break;
            }
        }
        if(!found){
            int left = 0;
            int right = nums.length - 1;
            while(left < right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
    }
}