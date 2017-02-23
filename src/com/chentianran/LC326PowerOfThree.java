package com.chentianran;

/**
 * Created by Tianran on 2/22/2017.
 */
public class LC326PowerOfThree {
	public boolean isPowrOfThree(int n) {
		if(n > 1) {
			while(n % 3 == 0) {
				n /= 3;
			}
		}
		return n == 1;
	}
}
