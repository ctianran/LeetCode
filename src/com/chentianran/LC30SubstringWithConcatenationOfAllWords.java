package com.chentianran;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tianran on 3/19/2017.
 */
public class LC30SubstringWithConcatenationOfAllWords {
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> result = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		for(String str : words) {
			Integer count = map.get(str);
			if(count == null) {
				map.put(str, 1);
			} else {
				map.put(str, count + 1);
			}
		}

		int len = words[0].length();
		for(int i = 0; i <= s.length() - len * words.length; i++) {
			Map<String, Integer> copy = new HashMap<>(map);
			for(int j = 0; j < words.length; j++) {
				String temp = s.substring(i + j * len, i + j * len + len);
				if(copy.containsKey(temp)) {
					Integer count = copy.get(temp);
					if(count == 1) {
						copy.remove(temp);
					} else {
						copy.put(temp, count - 1);
					}
					if(copy.isEmpty()) {
						result.add(i);
					}
				} else {
					break;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String s = "barfoothefoobarman";
		String[] words = new String[] {"foo", "bar"};
		LC30SubstringWithConcatenationOfAllWords sol = new LC30SubstringWithConcatenationOfAllWords();
		List<Integer> res = sol.findSubstring(s, words);
		System.out.println(res);
	}
}
