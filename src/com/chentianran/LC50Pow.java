package com.chentianran;

/**
 * Created by Tianran on 2/22/2017.
 */
public class LC50Pow {
	public double myPow(double x, int n) {
		if(n == 0) {
			return 1;
		}
		if(x == 0) {
			return 0;
		}
		if(n % 2 == 0) {
			return myPow(x * x, n / 2);
		} else {
			return (n > 0 ? x : 1.0/x) * myPow(x * x, n / 2);
		}
	}
}
