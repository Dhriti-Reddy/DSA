class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        for(int weight : weights){
            if(low < weight){
                low = weight;
            }
        }
        int high = 0;
        for(int i=0; i<weights.length; i++){
            high += weights[i];
        }

        while(low <= high){
            int mid = low + (high - low)/2;
            int consecutive = 0;
            int day = 1;
            for(int i = 0; i<weights.length; i++){
                consecutive += weights[i];
                if(consecutive > mid){
                    consecutive = weights[i];
                    day += 1;
                }
            }
            if(day <= days){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }
}