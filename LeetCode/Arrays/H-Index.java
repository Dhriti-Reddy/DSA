class Solution {
    public int hIndex(int[] citations) {
        int h;
        int answer = 0;
        for(h=0; h<=citations.length; h++){
            int count = 0;
            for(int i=0; i<citations.length; i++){
                if(citations[i] >= h){
                    count += 1;
                }
            }
            if(count >= h){
                answer = h;
            }
        }
        return answer;
    }
}