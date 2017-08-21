package com.chentianran;

import java.util.Arrays;

/**
 * Created by Tianran on 8/3/2017.
 */
public class LC14LongestCommonPrefix {
	//method1
	public String longestCommonPrefix(String[] strs) {
		if(strs.length == 0) {
			return "";
		}
		String prefix = strs[0];
		for(int i = 1; i < strs.length; i++) {
			while(strs[i].indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length() - 1);
				if(prefix.isEmpty()) {
					return "";
				}
			}
		}
		return prefix;
	}
	//method2
	public String longestCommonPrefixI(String[] strs) {
		if(strs == null || strs.length == 0) {
			return "";
		}
		for(int i = 0; i < strs[0].length(); i++) {
			char ch = strs[0].charAt(i);
			for(int j = 1; j < strs.length; j++) {
				if(i == strs[j].length() || strs[j].charAt(i) != ch) {
					return strs[0].substring(0, i);
				}
			}
		}
		return strs[0];
	}


	public static void main(String[] args) {
		String[] strs = new String[] {"ab", "bc", "abc"};
		for(String s : strs) {
			System.out.print(s + " ");
		}
		System.out.println();
		Arrays.sort(strs);
		for(String s : strs) {
			System.out.print(s + " ");
		}
	}
}
