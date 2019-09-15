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
	//Method3
	public String longestCommonPrefixII(String[] strs){
		if(strs == null || strs.length == 0) {
			return "";
		}
		return longestCommonHelper(strs, 0, strs.length - 1);
	}

	private String longestCommonHelper(String[] strs, int left, int right) {
		if(left == right) {
			return strs[left];
		}
		int mid = left + (right - left) / 2;
		String ll = longestCommonHelper(strs, left, mid);
		String rr = longestCommonHelper(strs, mid + 1, right);
		return getCommon(ll, rr);
	}

	private String getCommon(String left, String right) {
		int len = Math.min(left.length(), right.length());
		int i = 0;
		while(i < len && left.charAt(i) == right.charAt(i)) {
			i++;
		}
		return left.substring(0, i);
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
		String s = "abc";
		System.out.println(s.substring(0, 0));
	}
}
