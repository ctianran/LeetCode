package com.chentianran;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianran on 3/17/2017.
 */
public class LC131PalindromePartitioning {
	public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<List<String>>();
		if(s == null || s.length() == 0) {
			return result;
		}
		List<String> cur = new ArrayList<>();
		helper(s, 0, cur, result);
		return result;
	}

	private void helper(String s, int start, List<String> cur, List<List<String>> result) {
		if(start == s.length()) {
			result.add(new ArrayList<>(cur));
			return;
		}
		for(int i = start; i < s.length(); i++) {
			String str = s.substring(start, i + 1);
			if(isPal(str)) {
				cur.add(str);
				helper(s, i + 1, cur, result);
				cur.remove(cur.size() - 1);
			}
		}
	}

	private boolean isPal(String s) {
		int left = 0;
		int right = s.length();
		while(left < right) {
			if(s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}
