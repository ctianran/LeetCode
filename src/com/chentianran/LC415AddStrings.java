package com.chentianran;

/**
 * Created by Tianran on 2/18/2017.
 */
public class LC415AddStrings {
	public String addStrings(String num1, String num2) {
		if(num1 == null || num1.length() == 0) {
			return num2;
		}
		if(num2 == null || num2.length() == 0) {
			return num1;
		}
		StringBuilder sb = new StringBuilder();
		int index1 = num1.length() - 1;
		int index2 = num2.length() - 1;
		int carry = 0;
		while(index1 >= 0 || index2 >= 0) {
			int sum = 0;
			sum += carry;
			if(index1 >= 0) {
				sum += (num1.charAt(index1--) - '0');
			}
			if(index2 >= 0) {
				sum += (num2.charAt(index2--) - '0');
			}
			sb.append(sum % 10);
			carry = sum / 10;
		}
		if(carry > 0) {
			sb.append(carry);
		}
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		String s1 = "34";
		String s2 = "183";
		LC415AddStrings sol = new LC415AddStrings();
		String res = sol.addStrings(s1, s2);
		System.out.println(res);
	}
}
