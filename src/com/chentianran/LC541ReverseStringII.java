package com.chentianran;

/**
 * Created by Tianran on 5/2/2017.
 */
public class LC541ReverseStringII {
	public String reverseStr(String s, int k) {
		if(s == null || s.length() <= 1 || k <= 1) {
			return s;
		}
		char[] array = s.toCharArray();
		int i = 0;
		while(i < array.length) {
			if(i + k <= array.length) {
				reverseHelper(array, i, i + k - 1);
			} else {
				reverseHelper(array, i, array.length - 1);
			}
			i += 2 * k;
		}
		return new String(array);
	}

	private void reverseHelper(char[] array, int left, int right) {
		while(left < right) {
			char temp = array[left];
			array[left] = array[right];
			array[right] = temp;
			left++;
			right--;
		}
	}
}
