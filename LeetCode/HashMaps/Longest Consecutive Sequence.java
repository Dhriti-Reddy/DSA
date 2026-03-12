class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        int maxlength = 0;
        for(int num : set){
            if(!set.contains(num - 1)){
                int currentNum = num;
                int count = 1;
                while(set.contains(currentNum + 1)){
                    currentNum++;
                    count++;
                }
                maxlength = Math.max(maxlength, count);
            }
        }
        return maxlength;
    }
}