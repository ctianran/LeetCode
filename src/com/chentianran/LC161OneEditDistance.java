package com.chentianran;

/**
 * Created by Tianran on 2/24/2017.
 */
public class LC161OneEditDistance {
	public boolean isOneEditDistance(String s, String t) {
		if(s == null || t == null) {
			return false;
		}
		if(s.length() > t.length()) {
			return isOneEditDistance(t, s);
		}
		int i = 0;
		int j = 0;
		while(i < s.length() && j < t.length()) {
			if(s.charAt(i) != t.charAt(j)) {
				return s.substring(i+1).equals(t.substring(j+1)) || s.substring(i).equals(t.substring(j + 1));
			}
			i++;
			j++;
		}
		return j == t.length() - 1;
	}

	public static void main(String[] args) {
		String s = "acd";
		String t = "abcd";
		LC161OneEditDistance sol = new LC161OneEditDistance();
		System.out.println(sol.isOneEditDistance(s, t));
	}
}
