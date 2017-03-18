package com.chentianran;

/**
 * Created by Tianran on 3/17/2017.
 */
public class LC132PalindromePartitioningII {
	public int minCuts(String s) {
		if(s == null || s.length() == 0) {
			return -1;
		}
		if(s.length() == 1) {
			return 0;
		}
		int[] dp = new int[s.length() + 1];
		
	}
}
