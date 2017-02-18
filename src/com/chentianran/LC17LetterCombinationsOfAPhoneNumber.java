package com.chentianran;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianran on 2/17/2017.
 */
public class LC17LetterCombinationsOfAPhoneNumber {
	private static final String[] KEYS = {"", "","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	public List<String> letterCombinationsI(String digits) {
		List<String> result = new ArrayList<>();
		if(digits == null || digits.isEmpty()) {
			return result;
		}
		StringBuilder sb = new StringBuilder();
		helper(digits, 0, sb, result);
		return result;
	}

	private void helper(String digits, int index, StringBuilder sb, List<String> result) {
		if(index == digits.length()) {
			result.add(sb.toString());
			return;
		}
		String cur = KEYS[(digits.charAt(index) - '0')];
		for(int i = 0; i < cur.length(); i++) {
			sb.append(cur.charAt(i));
			helper(digits, index + 1, sb, result);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}
