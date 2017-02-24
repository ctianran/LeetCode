package com.chentianran;

/**
 * Created by Tianran on 2/23/2017.
 */
public class LC151ReverseWordsInAString {
	public String reverseWords(String s) {
		if(s == null || s.length() == 0) {
			return s;
		}
		char[] array = s.toCharArray();
		int start = 0;
		int slow = 0;
		for(int fast = 0; fast < array.length; fast++) {
			if(array[fast] == ' ' && (fast == 0 || array[fast - 1] == ' ')) {
				continue;
			}
			array[slow] = array[fast];
			if(array[slow] != ' ' && (slow == 0 || array[slow-1] == ' ')) {
				start = slow;
			}
			if(array[slow] == ' ') {
				reverse(array, start, slow - 1);
			} else if (fast == array.length - 1) {
				reverse(array, start, slow);
			}
			slow++;
		}
		if(slow > 0 && array[slow - 1] == ' ') {
			slow--;
		}
		reverse(array, 0, slow - 1);
		return new String(array, 0, slow);
	}

	private void reverse(char[] array, int left, int right) {
		while(left < right) {
			char temp = array[left];
			array[left] = array[right];
			array[right] = temp;
			left++;
			right--;
		}
	}

	public static void main(String[] args) {
		String s = "  I love you  ";
		LC151ReverseWordsInAString sol = new LC151ReverseWordsInAString();
		String res = sol.reverseWords(s);
		System.out.println(res);
	}
}
