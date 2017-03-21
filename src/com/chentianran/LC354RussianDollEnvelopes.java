package com.chentianran;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Tianran on 3/20/2017.
 */
public class LC354RussianDollEnvelopes {
	public int maxEnvelopes(int[][] envelopes) {
		if(envelopes == null || envelopes.length == 0 || envelopes[0].length == 0) {
			return 0;
		}
		Arrays.sort(envelopes, new Comparator<int[]>(){
			@Override
			public int compare(int[] e1, int[] e2) {
				if(e1[0] == e2[0]) {
					return e2[1] - e1[1];
				}
				return e1[0] < e2[0] ? -1 : 1;
			}
		});
		int result = 1;
		int[] dp = new int[envelopes.length];
		for(int i = 0; i < envelopes.length; i++) {
				dp[i] = 1;
				for(int j = 0; j < i; j++) {
						if(envelopes[i][1] > envelopes[j][1]) {
							dp[i] = Math.max(dp[i], dp[j] + 1);
						}
				}
				result = Math.max(result, dp[i]);
		}
		return result;
	}
}
