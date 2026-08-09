class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;

        int held = -prices[0]; // Profit after buying stock on day 0
        int sold = 0;          // Profit after selling stock
        int reset = 0;         // Profit while in cooldown/free state

        for (int i = 1; i < prices.length; i++) {
            int prevSold = sold;

            // Sell stock held from yesterday
            sold = held + prices[i];
            
            // Hold existing stock OR buy new stock after cooldown (reset)
            held = Math.max(held, reset - prices[i]);
            
            // Stay in reset OR enter reset from yesterday's sale
            reset = Math.max(reset, prevSold);
        }

        // Best result is either selling on the last day or being in reset
        return Math.max(sold, reset);
    }
}