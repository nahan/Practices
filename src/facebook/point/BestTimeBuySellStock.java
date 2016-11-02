package facebook.point;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
// 122

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
// 123

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
// 188

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
// 309

/**
 * Created by Han on 11/2/16.
 */
public class BestTimeBuySellStock {

    // 1.
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int max = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }

    // 2.
    public int maxProfitII(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - prices[i - 1];
            max += Math.max(profit, 0);
        }
        return max;
    }

    // 3.
    public int maxProfitIII(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int maxProfit = 0;
        int minPrice = prices[0];
        int[] dp = new int[prices.length];
        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            dp[i] = Math.max(dp[i - 1], prices[i] - minPrice);
        }
        int maxPrice = prices[prices.length - 1];
        int temp = 0;
        for (int i = prices.length - 2; i >= 0; i--) {
            maxPrice = Math.max(maxPrice, prices[i]);
            temp = Math.max(temp, maxPrice - prices[i]);
            maxProfit = Math.max(maxProfit, temp + dp[i]);
        }
        return maxProfit;
    }

}
