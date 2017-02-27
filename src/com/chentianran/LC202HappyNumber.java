package com.chentianran;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Tianran on 2/26/2017.
 */
public class LC202HappyNumber {
	public boolean isHappy(int n) {
		Set<Integer> set = new HashSet<>();
		while(n != 1) {
			int cur = 0;
			while(n > 0) {
				cur += (n % 10)*(n % 10);
				n /= 10;
			}
			if(!set.add(cur)) {
				return false;
			}
			n = cur;
		}
		return true;
	}
}
