package com.chentianran;

/**
 * Created by Tianran on 5/1/2017.
 */
public class LC504BaseSeven {
	public String convertToBase7(int num) {
		if(num == 0) {
			return "0";
		}
		boolean sign = false;
		if(num < 0) {
			sign = true;
		}
		num = Math.abs(num);
		StringBuilder sb = new StringBuilder();
		while(num > 0) {
			sb.append(num % 7);
			num /= 7;
		}
		if(sign) {
			sb.append('-');
		}
		return sb.reverse().toString();
	}
}
