package com.chentianran;

/**
 * Created by Tianran on 2/16/2017.
 */
public class LC367ValidPerfectSquare {
	public boolean isPerfectSquare(int num) {
		if(num < 0) {
			return false;
		}
		int left = 0;
		int right = num;
		while(left <= right) {
			long mid = left + (right - left) / 2;
			if(mid * mid == num) {
				return true;
			} else if (mid * mid < num) {
				left = (int) mid + 1;
			} else {
				right = (int) mid - 1;
			}
		}
		return false;
	}

}
