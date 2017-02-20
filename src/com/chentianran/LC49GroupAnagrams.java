package com.chentianran;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tianran on 2/20/2017.
 */
public class LC49GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<List<String>>();
		if(strs == null || strs.length == 0) {
			return result;
		}
		Map<String, List<String>> map = new HashMap<>();
		for(String s : strs) {
			char[] array = new char[26];
			for(int i = 0; i < s.length(); i++) {
				array[s.charAt(i) - 'a']++;
			}
			String pattern = new String(array);
			if(map.containsKey(pattern)) {
				map.get(pattern).add(s);
			} else {
				List<String> list = new ArrayList<>();
				list.add(s);
				map.put(pattern, list);
			}
		}

		for(Map.Entry<String, List<String>> entry : map.entrySet()) {
			result.add(entry.getValue());
		}
		return result;
	}

	public static void main(String[] args) {
		String[] input = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
		LC49GroupAnagrams sol = new LC49GroupAnagrams();
		List<List<String>> res = sol.groupAnagrams(input);
		System.out.println(res);
	}
}
