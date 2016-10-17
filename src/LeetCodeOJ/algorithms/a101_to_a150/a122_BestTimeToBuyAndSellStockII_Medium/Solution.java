package algorithms.a101_to_a150.a122_BestTimeToBuyAndSellStockII_Medium;

/**
 * Created by 31798 on 2016/10/17.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int profit = 0;
        for (int i = 0, j; i < prices.length; i = j + 1) {
            while (i + 1 < prices.length && prices[i] >= prices[i + 1]) {
                i++;
            }
            j = i + 1;
            while (j + 1 < prices.length && prices[j] <= prices[j + 1]) {
                j++;
            }
            if (j < prices.length) {
                profit += prices[j] - prices[i];
            }
        }
        return profit;
    }
}