package com.chentianran;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tianran on 2/24/2017.
 */
public class LC159LongestSubstringWithAtMostTwoDistinctCharacters {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}
		Map<Character, Integer> map = new HashMap<>();
		int slow = 0;
		int result = 0;
		for(int fast = 0; fast < s.length(); fast++) {
			char ch = s.charAt(fast);
			Integer count = map.get(ch);
			if(count == null) {
				map.put(ch, 1);
			} else {
				map.put(ch, count + 1);
			}
			while(map.size() > 2) {
				ch = s.charAt(slow++);
				count = map.get(ch);
				if(count == 1) {
					map.remove(ch);
				} else {
					map.put(ch, count - 1);
				}
			}
			result = Math.max(result, fast - slow + 1);
		}
		return result;
	}

	public static void main(String[] args) {
		String s = "ecebababac";
		LC159LongestSubstringWithAtMostTwoDistinctCharacters sol = new LC159LongestSubstringWithAtMostTwoDistinctCharacters();
		int res = sol.lengthOfLongestSubstringTwoDistinct(s);
		System.out.println(res);
	}
}
