package Easy.BestTimeToBuyAndSellStock;

public class Solution {
    // NeetCode explanation
    // https://youtu.be/1pkOgXD63yU?si=naBBpxplZOZoObWj

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
//        System.out.println(s.maxProfit(new int[]{7, 6, 4, 3, 1}));
//        System.out.println(s.maxProfit(new int[]{1, 4, 2}));
    }

    public int maxProfit(int[] prices) {
        // we are going to use 2 pointers for this problem.
        // we initialize l pointer at 0, r pointer at l + 1. l is the buy day, r is the sell day.
        // we keep moving r to the right, until it meets the right end of the array
        // we check if sell day price is greater than buy day price, then record that as the profit.

        // the expected answer is not the best day to buy and sell but rather the maximum profit.
        // so we keep updating the maximum profit we encountered so far.

        // say there is a day buying price is greater than selling price, that means we have missed our chance,
        // and now we need to start from that day again, and keep an eye of the profit on the days to the right

        // when r has reached the end of array, we went through all the sales, and we persisted the max possible profit.

        int l = 0;
        int r = 1;

        int maxProfit = 0;

        while (r < prices.length) {
            if (prices[l] < prices[r]) {
                maxProfit = Math.max(maxProfit, prices[r] - prices[l]);
            } else {
                l = r;
            }

            r++;
        }

        return maxProfit;
    }
}
