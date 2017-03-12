package com.chentianran;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Tianran on 3/11/2017.
 */
public class LC179LargestNumber {
	public String largestNumber(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		String[] str = new String[nums.length];
		for(int i = 0; i < nums.length; i++) {
			str[i] = String.valueOf(nums[i]);
		}
		Arrays.sort(str, new Comparator<String>(){
			@Override
			public int compare(String a, String b) {
				return (b + a).compareTo(a + b);
			}
		});
		StringBuilder sb = new StringBuilder();
		for(String s : str) {
			sb.append(s);
		}
		if(sb.charAt(0) == '0') {
			return "0";
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		int[] nums = new int[] {30, 34, 9};
		LC179LargestNumber sol = new LC179LargestNumber();
		String res = sol.largestNumber(nums);
		System.out.println(res);
	}
}
