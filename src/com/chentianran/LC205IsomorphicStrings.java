package com.chentianran;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tianran on 2/26/2017.
 */
public class LC205IsomorphicStrings {
	public boolean isIsomorphic(String s, String t) {
		if(s.length() != t.length()) {
			return false;
		}
		if(s.equals(t)) {
			return true;
		}
		Map<Character, Character> map = new HashMap<>();
		for(int i = 0; i < s.length(); i++) {
			char ch1 = s.charAt(i);
			char ch2 = t.charAt(i);
			if(map.containsKey(ch1)) {
				if(map.get(ch1) != ch2) {
					return false;
				}
			} else {
				if(map.containsValue(ch2)) {
					return false;
				}
				map.put(ch1, ch2);
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String s = "abca";
		String t = "xyzx";
		LC205IsomorphicStrings sol = new LC205IsomorphicStrings();
		System.out.println(sol.isIsomorphic(s, t));
	}
}
