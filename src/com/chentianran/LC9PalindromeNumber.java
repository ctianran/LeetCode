package com.chentianran;

/**
 * Created by Tianran on 2/27/2017.
 */
public class LC9PalindromeNumber {
	public boolean isPalindrome(int x) {
		if(x < 0 || x != 0 && x % 10 == 0) {
			return false;
		}
		int temp = 0;
		while(x > temp) {
			temp = temp * 10 + x % 10;
			x /= 10;
		}
		return (x == temp || x == temp / 10);
	}
}