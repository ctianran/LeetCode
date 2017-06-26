package com.chentianran;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Tianran on 6/25/2017.
 */
public class LC139WordBreak {
	public boolean wordBreak(String s, List<String>wordDict) {
		Set<String> dict = new HashSet<>();

		for(String str : wordDict) {
			dict.add(str);
		}
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		for(int i = 1; i < dp.length; i++) {
			for(int j = 0; j < i; j++) {
				if(dp[j] && dict.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[s.length()];
	}
}
