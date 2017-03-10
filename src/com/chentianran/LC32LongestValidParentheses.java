package com.chentianran;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Tianran on 3/9/2017.
 */
public class LC32LongestValidParentheses {
	public int longestValidParenthesesI(String s) {
		if(s == null || s.length() <= 1) {
			return 0;
		}
		int result = 0;
		int start = 0;
		Deque<Integer> stack = new LinkedList<>();
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if(ch == ')') {
				if(!stack.isEmpty()) {
						stack.pollFirst();
					  result = Math.max(result, stack.isEmpty() ? (i - start + 1) : (i - stack.peekFirst()));
				} else {
					start = i + 1;
				}
			} else {
				stack.offerFirst(i);
			}
		}
		return result;
	}

	public int longestValidParenthesesII(String s) {
		if(s == null || s.length() <= 1) {
			return 0;
		}
		int result = 0;
		int[] dp = new int[s.length()];
		dp[s.length() - 1] = 0;
		for(int i = s.length() - 2; i >= 0; i--) {
			if(s.charAt(i) == ')') {
				dp[i] = 0;
			} else {
				int j = i + 1 + dp[i+1];
				if(j < s.length() && s.charAt(j) == ')') {
					dp[i] = dp[i+1] + 2;
					if(j + 1 < s.length()) {
						dp[i] += dp[j+1];
					}
				}
			}
			result = Math.max(result, dp[i]);
		}
		return result;
	}

	public static void main(String[] args) {
		String s = "(()()(";
		LC32LongestValidParentheses sol = new LC32LongestValidParentheses();
		int res = sol.longestValidParenthesesI(s);
		System.out.println(res);
	}

}
