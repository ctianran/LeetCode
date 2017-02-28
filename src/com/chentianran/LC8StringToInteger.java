package com.chentianran;

/**
 * Created by Tianran on 2/27/2017.
 */
public class LC8StringToInteger {
	public int myAtoi(String str) {
		if (str.length() == 0) {
			return 0;
		}
		int sign = 1;
		int total = 0;
		int index = 0;
		while (str.charAt(index) == ' ' && index < str.length()) {
			index++;
		}
		if (str.charAt(index) == '+' || str.charAt(index) == '-') {
			sign = str.charAt(index) == '+' ? 1 : -1;
			index++;
		}
		while (index < str.length()) {
			int digit = str.charAt(index) - '0';
			if (digit < 0 || digit > 9) {
				break;
			}
			if (Integer.MAX_VALUE / 10 < total || Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit) {
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			total = total * 10 + digit;
			index++;
		}
		return total * sign;
	}
}
