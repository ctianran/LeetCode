package com.chentianran;

/**
 * Created by Tianran on 8/11/2017.
 */
public class LC461HammingDistance {
	//Time: O(32) -> number of bits
	public int hammingDistance(int x, int y) {
		int num = x ^ y;
		int res = 0;
		for(int i = 0; i < 32; i++) {
			if(((num >> i) & 1) == 1) {
				res++;
			}
		}
		return res;
	}

	//Time: O(# of 1 bits)
	public int hammingDistanceII(int x, int y) {
		int num = x ^ y;
		int res = 0;
		while(num != 0) {
			num = num & (num - 1);
			res++;
		}
		return res;
	}

	public static void main(String[] args) {
		LC461HammingDistance sol = new LC461HammingDistance();
		int res = sol.hammingDistance(1, 4);
		System.out.println(res);
	}
}
