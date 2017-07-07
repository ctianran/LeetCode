package com.chentianran;

/**
 * Created by Tianran on 7/6/2017.
 */
public class LC69Sqrt {
	public int mySqrt(int x) {
		if(x < 0) {
			return -1;
		}
		if(x == 0) {
			return 0;
		}
		long left = 1;
		long right = left * 2;
		while(right * right < x) {
			right *= 2;
		}
		return mySqrt(x, left, right);
	}

	public int mySqrt(long x, long left, long right) {
		if(x < 0) {
			return -1;
		}
		while(left < right - 1) {
			long mid = left + (right - left) / 2;
			if(mid * mid == x) {
				return (int)mid;
			} else if(mid * mid < x) {
				left = mid;
			} else {
				right = mid - 1;
			}
		}
		return right * right <= x ? (int) right : (int) left;
	}

	public double sqrtDouble(double x) {
		double epsilon = 0.000001;
		//if x > 1, search [1, x]
		//if x < 1, saerch [x, 1]
		double left = x < 1 ? x : 1;
		double right = x < 1 ? 1 : x;

		while(left < right) {
			double mid = left + (right - left) / 2;
			if(Math.abs(mid * mid - x) / x < epsilon) {
				return mid;
			} else if (mid * mid < x) {
				left = mid;
			} else {
				right = mid;
			}
		}
		return left;
	}

	
}
