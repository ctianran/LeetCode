package com.chentianran;

import java.util.*;

/**
 * Created by Tianran on 6/20/2017.
 */
public class LC267PalindromePermutationII {
	public List<String> generatePalindromes(String s) {
		List<String> res = new ArrayList<>();
		String mid = "";
		int odd = 0;
		Map<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			Integer count = map.get(ch);
			if(count == null) {
				map.put(ch, 1);
				odd++;
			} else {
				map.put(ch, count + 1);
				if((count + 1) % 2 == 0) {
					odd--;
				} else {
					odd++;
				}
			}
		}
		//not a valid palindrome
		if(odd > 1) {
			return res;
		}
		//get half characters
		StringBuilder sb = new StringBuilder();
		for(Map.Entry<Character, Integer> entry : map.entrySet()) {
			char key = entry.getKey();
			int num = entry.getValue();
			if(num % 2 != 0) {
				mid += key;
			}
			for(int i = 0; i < num / 2; i++) {
				sb.append(key);
			}
		}

		//perform permutation for the half of the characters
		permHelper(sb, 0, mid, res);
		return res;
	}

	private void permHelper(StringBuilder sb, int index, String mid, List<String> res) {
		if(index == sb.length()) {
			res.add(sb.toString() + mid + sb.reverse().toString());
			sb.reverse();
			return;
		}
		Set<Character> set = new HashSet<>();
		for(int i = index; i < sb.length(); i++) {
			if(set.add(sb.charAt(i))) {
				swap(sb, i, index);
				permHelper(sb, index +1, mid, res);
				swap(sb, i, index);
			}
		}
	}

	private void swap(StringBuilder sb, int a, int b) {
		char temp = sb.charAt(a);
		sb.setCharAt(a, sb.charAt(b));
		sb.setCharAt(b, temp);
	}

	public static void main(String[] args) {
		String s = "aaaabbbb";
		LC267PalindromePermutationII sol = new LC267PalindromePermutationII();
		List<String> res = sol.generatePalindromes(s);
		System.out.println(res);
	}
}
