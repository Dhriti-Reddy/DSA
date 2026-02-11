class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0;
        int sell;
        int profit = 0;
        for(sell = 1; sell<prices.length; sell++){
            if(prices[sell] < prices[buy]){
                buy = sell;
            }
            else{
                profit += prices[sell] - prices[buy];
                buy++;
            }
        }
        return profit;
    }
}