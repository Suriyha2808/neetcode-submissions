class Solution {
    public int maxProfit(int[] prices) {
        int profit=0;
        int buy=101;
        int sell=0;
        for(int i=0;i<prices.length;i++)
        {
            if(prices[i]<buy)
            {
                buy=prices[i];
            }
            if(profit<prices[i]-buy)
            {
                profit=prices[i]-buy;
            }
        }
        return profit;
    }
}
