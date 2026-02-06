class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums1.length > nums2.length){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int low = 0;
        int high = nums1.length;
        int total = nums1.length + nums2.length;
        int totalleft = (total + 1)/2;

        int leftmax1 = 0, rightmin1 = 0, leftmax2 = 0, rightmin2 = 0;

        while(low <= high){
            int mid = low + (high - low)/2;
            int arr2left = totalleft - mid;

            leftmax1 = (mid == 0) ? Integer.MIN_VALUE : nums1[mid-1];
            rightmin1 = (mid == nums1.length) ? Integer.MAX_VALUE : nums1[mid];
            leftmax2 = (arr2left == 0) ? Integer.MIN_VALUE : nums2[arr2left-1];
            rightmin2 = (arr2left == nums2.length) ? Integer.MAX_VALUE : nums2[arr2left];

            if(leftmax1 <= rightmin2 && leftmax2 <= rightmin1){
                break;
            }
            else if(leftmax1 > rightmin2){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        if(total%2 == 0){
            return (Math.max(leftmax1, leftmax2) + Math.min(rightmin1, rightmin2)) / 2.0;
        }
        else{
            return (double)Math.max(leftmax1, leftmax2);
        }
    }
}
