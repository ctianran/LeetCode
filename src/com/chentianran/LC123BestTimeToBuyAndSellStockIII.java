package com.chentianran;

/**
 * Created by Tianran on 8/25/2017.
 */
public class LC123BestTimeToBuyAndSellStockIII {
	public int maxProfit(int[] prices) {
		if(prices == null || prices.length == 0) {
			return 0;
		}
		int[] left = new int[prices.length];
		int[] right = new int[prices.length];

		left[0] = 0;
		right[prices.length - 1] = 0;

		int min = prices[0];
		for(int i = 1; i < prices.length; i++) {
			left[i] = Math.max(prices[i] - min, left[i - 1]);
			min = Math.min(min, prices[i]);
		}

		int max = prices[prices.length - 1];
		for(int i = prices.length - 2; i >= 0; i--) {
			right[i] = Math.max(max - prices[i], right[i + 1]);
			max = Math.max(max, prices[i]);
		}
		int res = 0;
		for(int i = 0; i < prices.length; i++) {
			res = Math.max(res, left[i] + right[i]);
		}

		return res;
	}
}
