package com.chentianran;

/**
 * Created by Tianran on 2/17/2017.
 */
public class LC338CountingBits {
	public int[] countBits(int num) {
		int[] result = new int[num + 1];
		for(int i = 1; i <= num; i++) {
			result[i] = getBits(i);
		}
		return result;
	}

	private int getBits(int num) {
		int count = 0;
		while(num > 0) {
			count += (num & 1);
			num >>= 1;
		}
		return count;
	}

	public int[] countBitsII(int num) {
		int[] result = new int[num + 1];

		int pow = 1;
		int count = 1;
		for(int i = 1; i <= num; i++) {
			if(i == pow) {
				result[i] = 1;
				pow <<= 1;
				count = 1;
			} else {
				result[i] = result[count] + 1;
				count++;
			}
		}
		return result;
	}
}
