package com.chentianran;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianran on 4/29/2017.
 */
public class LC241DifferentWaysToAddParentheses {
	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> res = new ArrayList<>();
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == '-' || input.charAt(i) == '*' || input.charAt(i) == '+') {
				String one = input.substring(0, i);
				String two = input.substring(i+1);
				List<Integer> oneRes = diffWaysToCompute(one);
				List<Integer> twoRes = diffWaysToCompute(two);
				for(Integer numOne : oneRes) {
					for(Integer numTwo : twoRes) {
						int c = 0;
						switch(input.charAt(i)) {
							case '+': c = numOne + numTwo;
							break;
							case '-': c = numOne - numTwo;
							break;
							case '*': c = numOne * numTwo;
							break;
						}
						res.add(c);
					}
				}
			}
		}
		if(res.size() == 0) {
			res.add(Integer.valueOf(input));
		}
		return res;
	}
}
