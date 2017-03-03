package com.chentianran;

/**
 * Created by Tianran on 3/3/2017.
 */
public class LC520DetectCapital {
	public boolean detectCapitalUse(String word) {
		if(word == null || word.length() <= 1) {
			return true;
		}
		boolean first = false;
		if(word.charAt(0) >= 'A' && word.charAt(0) <= 'Z') {
				first = true;
		}
		boolean second = false;
		if(word.charAt(1) >= 'A' && word.charAt(1) <= 'Z') {
			second = true;
		}
		for(int i = 1; i < word.length(); i++) {
			char ch = word.charAt(i);
			if(first) {
				if(second) {
					if(ch >= 'a' && ch <= 'z') {
						return false;
					}
				} else if(ch >= 'A' && ch <= 'Z') {
						return false;
				}
			} else if(ch >= 'A' && ch <= 'Z'){
				return false;
			}
		}
		return true;
	}
}
