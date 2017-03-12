package com.chentianran;

/**
 * Created by Tianran on 3/11/2017.
 */
public class LC171ExcelSheetColumnNumber {
	public int titleToNumber(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}
		int result = 0;
		int fact = 0;
		for(int i = s.length(); i >= 0; i--) {
			char ch = s.charAt(i);
			result += (int)(ch - 'A' + 1) * Math.pow(26, fact++);
		}
		return result;
	}
}
