package com.chentianran;

/**
 * Created by Tianran on 2/26/2017.
 */
public class LC204CountPrimes {
	public int countPrimes(int n) {
		boolean[] notPrime = new boolean[n];
		int count = 0;
		for(int i = 2; i < n; i++) {
			if(notPrime[i] == false) {
				count++;
				for(int j = 2; i * j < n; j++) {
					notPrime[i*j] = true;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		LC204CountPrimes sol = new LC204CountPrimes();
		int res = sol.countPrimes(5);
		System.out.println(res);
	}
}
