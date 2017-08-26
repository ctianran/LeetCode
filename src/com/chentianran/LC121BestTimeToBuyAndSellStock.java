package com.chentianran;

/**
 * Created by Tianran on 8/25/2017.
 */
public class LC121BestTimeToBuyAndSellStock {
	public int maxProfit(int[] prices) {
		if(prices == null || prices.length == 0) {
			return 0;
		}
		int min = prices[0];
		int res = 0;
		for(int i = 1; i < prices.length; i++) {
			res = Math.max(res, prices[i] - min);
			min = Math.min(min, prices[i]);
		}
		return res;
	}
}


