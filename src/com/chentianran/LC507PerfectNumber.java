package com.chentianran;

/**
 * Created by Tianran on 8/21/2017.
 */
public class LC507PerfectNumber {
	public boolean checkPerfectNumber(int num) {
		if(num == 1) {
			return false;
		}
		int sum = 1;
		for(int i = 2; i <= Math.sqrt(num); i++) {
			if(num % i == 0) {
				sum += i;
				if(i != num / i) {
					sum += num / i;
				}
			}
		}
		return sum == num;
	}

}
