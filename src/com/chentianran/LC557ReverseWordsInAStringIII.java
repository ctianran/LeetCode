package com.chentianran;

/**
 * Created by Tianran on 5/2/2017.
 */
public class LC557ReverseWordsInAStringIII {
	public String reverseWords(String s) {
		if (s == null || s.length() <= 1) {
			return s;
		}
		char[] array = s.toCharArray();
		int start = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != ' ' && (i == 0 || array[i - 1] == ' ')) {
				start = i;
			}
			if (array[i] != ' ' && (i == array.length - 1 || array[i + 1] == ' ')) {
				reverseHelper(array, start, i);
			}
		}
		return new String(array);
	}

	private void reverseHelper(char[] array, int start, int end) {
		while(start < end) {
			char temp = array[start];
			array[start] = array[end];
			array[end] = temp;
			start++;
			end--;
		}
	}

}
