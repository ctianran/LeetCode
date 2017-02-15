package com.chentianran;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Tianran on 2/14/2017.
 */
public class LC3LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}
		Set<Character> set = new HashSet<>();
		int fast = 0;
		int slow = 0;
		int result = 0;
		while(fast < s.length()) {
			if(set.contains(s.charAt(fast))) {
				set.remove(s.charAt(slow++));
			} else {
				set.add(s.charAt(fast++));
				result = Math.max(result, fast - slow);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String s = "abcabcbb";
		LC3LongestSubstringWithoutRepeatingCharacters sol = new LC3LongestSubstringWithoutRepeatingCharacters();
		int res = sol.lengthOfLongestSubstring(s);
		System.out.println(res);
	}
}
