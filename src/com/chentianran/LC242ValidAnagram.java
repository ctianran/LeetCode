package com.chentianran;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tianran on 2/19/2017.
 */
public class LC242ValidAnagram {
	public boolean isAnagramI(String s, String t) {
		if(s.length() != t.length()) {
			return false;
		}
		int[] array = new int[26];
		for(int i = 0; i < s.length(); i++) {
			array[s.charAt(i) - 'a']++;
			array[t.charAt(i) - 'a']--;
		}
		for(int num : array) {
			if(num != 0) {
				return false;
			}
		}
		return true;
	}

	public boolean isAnagramII(String s, String t) {
		if(s.length() != t.length()) {
			return false;
		}
		Map<Character, Integer> map = new HashMap<>();
		for(char ch : s.toCharArray()) {
			Integer count = map.get(ch);
			if(count == null) {
				map.put(ch, 1);
			} else {
				map.put(ch, count + 1);
			}
		}

		for(int i = 0; i < t.length(); i++) {
			char ch = t.charAt(i);
			if(map.containsKey(ch)) {
				Integer count = map.get(ch);
				if(count == 1) {
					map.remove(ch);
				} else {
					map.put(ch, count - 1);
				}
			} else {
				return false;
			}
		}
		return map.size() == 0;
	}

	public static void main(String[] args) {
		String s = "abc";
		String t = "bca";
		LC242ValidAnagram sol = new LC242ValidAnagram();
		System.out.println(sol.isAnagramII(s, t));
	}
}
