package com.chentianran;

/**
 * Created by Tianran on 5/4/2017.
 */
public class LC521LongestUncommonSubsequenceI {
	public int findLUSlength(String a, String b) {
		return a.equals(b) ? -1 : Math.max(a.length(), b.length());
	}
}
