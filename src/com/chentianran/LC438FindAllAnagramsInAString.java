package com.chentianran;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tianran on 2/19/2017.
 */
public class LC438FindAllAnagramsInAString {
	public List<Integer> findAnagrams(String s, String t) {
		List<Integer> result = new ArrayList<>();
		if(s.length() < t.length()) {
			return result;
		}
		Map<Character, Integer> map = getMap(t);
		int charToMatch = map.size();
		int slow = 0;
		for(int fast = 0; fast < s.length(); fast++) {
			char ch = s.charAt(fast);
			Integer count = map.get(ch);
			if(count != null) {
				map.put(ch, count - 1);
				if(count == 1) {
					charToMatch--;
				}
			}
			if(fast >= t.length()) {
				ch = s.charAt(slow++);
				count = map.get(ch);
				if(count != null) {
					map.put(ch, count + 1);
					if (count == 0) {
						charToMatch++;
					}
				}
			}
			if(charToMatch == 0) {
				result.add(slow);
			}
		}
		return result;
	}

	private Map<Character, Integer> getMap(String t) {
		Map<Character, Integer> map = new HashMap<>();
		for(char ch : t.toCharArray()) {
			Integer count = map.get(ch);
			if(count == null) {
				map.put(ch, 1);
			} else {
				map.put(ch, count + 1);
			}
		}
		return map;
	}

	public static void main(String[] args) {
		String s = "cbaebabacd";
		String t = "abc";
		LC438FindAllAnagramsInAString sol = new LC438FindAllAnagramsInAString();
		List<Integer> res = sol.findAnagrams(s, t);
		System.out.println(res);
	}
}
