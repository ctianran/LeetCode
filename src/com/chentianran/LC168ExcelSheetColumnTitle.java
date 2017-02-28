package com.chentianran;

/**
 * Created by Tianran on 2/27/2017.
 */
public class LC168ExcelSheetColumnTitle {
	public String convertToTitle(int n) {
		StringBuilder sb = new StringBuilder();
		while(n > 0) {
			n--;
			sb.append((char)((n % 26) + 'A'));
			n /= 26;
		}
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		LC168ExcelSheetColumnTitle sol = new LC168ExcelSheetColumnTitle();
		System.out.println(sol.convertToTitle(27));
	}
}
