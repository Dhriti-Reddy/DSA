class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0;
        int profit = 0;
        int sell;
        int maxprofit = 0;
        for(sell = 1; sell<prices.length; sell++){
            if(prices[sell] < prices[buy]){
                buy = sell;
            }
            else{
                profit = prices[sell] - prices[buy];
                if(maxprofit < profit){
                    maxprofit = profit;
                }
            }
        }
        return maxprofit;
    }
}