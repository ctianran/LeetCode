package com.chentianran;

import java.util.*;

/**
 * Created by Tianran on 2/20/2017.
 */
public class LC187RepeatedDNASequences {
	public List<String> findRepeatedDnaSequencesI(String s) {
		List<String> result = new ArrayList<>();
		if(s == null || s.length() <= 1) {
			return result;
		}
		Set<Integer> one = new HashSet<>();
		Set<Integer> two = new HashSet<>();
		Map<Character, Integer> map = new HashMap<>();
		map.put('A', 1);
		map.put('C', 2);
		map.put('G', 3);
		map.put('T', 4);
		int hashValue = 0;
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if(i < 10) {
				hashValue = hashValue * 4 + map.get(ch);
				if(i == 9) {
					one.add(hashValue);
				}
			} else {
				hashValue = hashValue % (int)(Math.pow(4, 9)) * 4 + map.get(ch);
				if(!one.add(hashValue) && two.add(hashValue)) {
					result.add(s.substring(i - 9, i + 1));
				}
			}
		}
		return result;
	}

	public List<String> findRepeatedDnaSequencesII(String s) {
		List<String> result = new ArrayList<>();
		if (s == null || s.length() <= 1) {
			return result;
		}
		Set<Integer> one = new HashSet<>();
		Set<Integer> two = new HashSet<>();
		Map<Character, Integer> map = new HashMap<>();
		map.put('A', 0);
		map.put('C', 1);
		map.put('G', 2);
		map.put('T', 3);

		int hashValue = 0;
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if(i < 9) {
				hashValue = (hashValue << 2) | map.get(ch);
			} else {
				hashValue = (hashValue << 2) | map.get(ch);
				hashValue &= (1 << 20) - 1;

				if(!one.add(hashValue) && two.add(hashValue)) {
					result.add(s.substring(i - 9, i + 1));
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		LC187RepeatedDNASequences sol = new LC187RepeatedDNASequences();
		List<String> res = sol.findRepeatedDnaSequencesII(s);
		System.out.println(res);
	}

}
