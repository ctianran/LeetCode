package com.chentianran;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tianran on 4/28/2017.
 */
public class LC451SortCharactersByFrequency {
	public String frequencySort(String s) {
		if(s == null || s.length() <= 2) {
			return s;
		}
		Map<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			Integer count = map.get(ch);
			if(count == null) {
				map.put(ch, 1);
			} else {
				map.put(ch, count + 1);
			}
		}

		List<Character> [] bucket = new List[s.length() + 1];
		for(char key : map.keySet()) {
			int f = map.get(key);
			if(bucket[f] == null) {
				bucket[f] = new ArrayList<>();
			}
			bucket[f].add(key);
		}

		StringBuilder sb = new StringBuilder();
		for(int i = bucket.length - 1; i >= 0; i--) {
			if(bucket[i] != null) {
				for(char ch : bucket[i]) {
					for(int k = 0; k < map.get(ch); k++) {
						sb.append(ch);
					}
				}
			}
		}
		return sb.toString();
	}
}
