package com.chentianran;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Tianran on 2/13/2017.
 */
public class LC266PalindromePermutation {
	public boolean isPal(String s) {
		Set<Character> set = new HashSet<>();
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if(set.contains(ch)) {
				set.remove(ch);
			} else {
				set.add(ch);
			}
		}
		return set.size() == 0 || set.size() == 1;
	}
}
