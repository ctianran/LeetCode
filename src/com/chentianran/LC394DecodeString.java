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

	//improvement with StringBuilder

	public String decodeStringII(String s) {
		if(s == null || s.length() <= 1) {
			return s;
		}
		StringBuilder cur = new StringBuilder();
		Deque<StringBuilder> resStack = new LinkedList<>();
		Deque<Integer> numStack = new LinkedList<>();
		int count = 0;
		for(char ch : s.toCharArray()) {
			if(ch >= '0' && ch <= '9') {
				count = count * 10 + (ch - '0');
			} else if (ch == '[') {
				numStack.offerFirst(count);
				resStack.offerFirst(cur);
				cur = new StringBuilder();
				count = 0;
			} else if (ch == ']') {
				StringBuilder temp = cur;
				cur = resStack.pollFirst();
				int num = numStack.pollFirst();
				for(int i = 0; i < num; i++) {
					cur.append(temp);
				}
			} else {
				cur.append(ch);
			}
		}
		return cur.toString();
	}

	public static void main(String[] args) {
		String s1 = "3[a]2[bc]";
		String s2 = "3[a2[c]]";
		LC394DecodeString sol = new LC394DecodeString();
		String res1 = sol.decodeString(s1);
		String res2 = sol.decodeStringII(s2);
		System.out.println(res1);
		System.out.println(res2);
	}
}
