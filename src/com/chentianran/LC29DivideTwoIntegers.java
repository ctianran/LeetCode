package com.chentianran;

/**
 * Created by Tianran on 2/25/2017.
 */
public class LC29DivideTwoIntegers {

	//without using  "/" "*" "+"
	public int divide(int dividend, int divisor) {
		if(divisor == 0) {
			return Integer.MAX_VALUE;
		}
		if(divisor == -1 && dividend == Integer.MIN_VALUE) {
			return Integer.MAX_VALUE;
		}

		long pDividend = Math.abs((long)dividend);
		long pDivisor = Math.abs((long)divisor);
		int result = 0;
		long temp = pDivisor;
		int cur = 1;
		while(temp <= pDividend) {
			temp <<= 1;
			cur <<=1;
		}
		temp >>= 1;
		cur >>= 1;
		while(pDividend >= divisor) {
			if(temp <= pDividend) {
				result |= cur;
				pDividend -= temp;
			}
			temp >>= 1;
			cur >>= 1;
		}

		if(dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) {
			return -result;
		}
		return result;
	}


}
