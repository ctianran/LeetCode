package com.chentianran;

import java.util.Arrays;

/**
 * Created by Tianran on 2/19/2017.
 */
public class LC387FirstUniqueCharacterInAString {
	//two pass solution
	public int firstUniqueCharI(String s) {
		if(s == null || s.isEmpty()) {
			return -1;
		}
		if(s.length() == 1) {
			return 0;
		}
		int[] array = new int[26];
		for(int i = 0; i < s.length(); i++) {
			array[(s.charAt(i) - 'a')]++;
		}
		for(int i = 0; i < s.length(); i++) {
			if(array[s.charAt(i) - 'a'] == 1) {
				return i;
			}
		}
		return -1;
	}
	//one pass solution
	public int firstUniqueCharII(String s) {
		if(s == null || s.isEmpty()) {
			return -1;
		}
		if(s.length() == 1) {
			return 0;
		}
		int[] array = new int[26];
		Arrays.fill(array, -2);
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			int index = ch - 'a';
			if(array[index] == -2) {
				array[index] = i;
			} else if(array[index] >= 0 && array[index] < s.length()) {
				array[index] = -1;
			}
		}
		int result = Integer.MAX_VALUE;
		for(int num : array) {
			if(num != -1 && num != -2) {
				result = Math.min(result, num);
			}
		}
		return result == Integer.MAX_VALUE ? -1 : result;
	}
}
