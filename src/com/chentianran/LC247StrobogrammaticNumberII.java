package com.chentianran;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Tianran on 3/3/2017.
 */
public class LC247StrobogrammaticNumberII {
	public List<String> findStrobogrammatic(int n) {
		List<String> one = Arrays.asList("0", "1", "8");
		List<String> two = Arrays.asList("");
		List<String> result = two;

		if(n % 2 == 1) {
			result = one;
		}
		for(int i = (n % 2) + 2; i <= n; i += 2) {
			List<String> temp = new ArrayList<>();
			for(String s : result) {
				if(i != n) {
					temp.add("0" + s + "0");
				}
				temp.add("1" + s + "1");
				temp.add("6" + s + "9");
				temp.add("8" + s + "8");
				temp.add("9" + s + "6");
			}
			result = temp;
		}
		return result;
	}

	public static void main(String[] args) {
		LC247StrobogrammaticNumberII sol = new LC247StrobogrammaticNumberII();
		List<String> res = sol.findStrobogrammatic(4);
		System.out.println(res);
	}
}
