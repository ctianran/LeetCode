package com.chentianran;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Tianran on 6/24/2017.
 */
public class LC394DecodeString {
	public String decodeString(String s) {
		if(s == null || s.length() <= 1) {
			return s;
		}
		String res = "";
		Deque<String> resStack = new LinkedList<>();
		Deque<Integer> numStack = new LinkedList<>();

		int index = 0;
		while(index < s.length()) {
			char ch = s.charAt(index);
			if (Character.isDigit(ch)) {
				int count = 0;
				while (Character.isDigit(s.charAt(index))) {
					count = count * 10 + (s.charAt(index) - '0');
					index++;
				}
				numStack.offerFirst(count);
			} else if (ch == '[') {
				resStack.offerFirst(res);
				res = "";
				index++;
			} else if (ch == ']') {
				StringBuilder sb = new StringBuilder(resStack.pollFirst());
				int num = numStack.pollFirst();
				for(int i = 0; i < num; i++) {
					sb.append(res);
				}
				res = sb.toString();
				index++;
			} else {
				res += ch;
				index++;
			}
		}
		return res;
	}
}
