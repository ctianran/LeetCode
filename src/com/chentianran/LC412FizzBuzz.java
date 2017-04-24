package com.chentianran;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianran on 4/23/2017.
 */
public class LC412FizzBuzz {
	public List<String> fizzBuzz(int n) {
		List<String> result = new ArrayList<>();
		if(n <= 0) {
			return result;
		}
		for(int i = 1; i <= n; i++) {
			if(i % 3 == 0 && i % 5 == 0) {
				result.add("FizzBuzz");
			} else if (i % 3 == 0) {
				result.add("Fizz");
			} else if (i % 5 == 0) {
				result.add("Buzz");
			} else {
				result.add(String.valueOf(i));
			}
		}
		return result;
	}
}
