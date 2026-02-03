class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int low = 1;
        int high = 0;
        for(int bloom : bloomDay){
            if (bloom > high){
                high = bloom;
            }
        }
        if ((long) bloomDay.length < (long) m * k) {
            return -1;
        }

        while(low <= high){
            int mid = low + (high - low)/2;
            int consecutive = 0;
            int bouquet = 0;
            for(int i=0; i<bloomDay.length; i++){
                if(bloomDay[i] <= mid){
                    consecutive += 1;
                    if(consecutive == k){
                       bouquet += 1;
                       consecutive = 0;
                    }
                }
                else{
                   consecutive = 0;
                }
            }
            if(bouquet >= m){
                high =mid-1;
            }
            else{
                low=mid+1;
            }
        } 
        return low;
    }
}