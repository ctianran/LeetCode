package com.chentianran;

import java.util.*;

/**
 * Created by Tianran on 5/5/2017.
 */
public class LC127WordLadder {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		//sanity check
		//build a set for word list
		Set<String> set = new HashSet<>();
		for(String s : wordList) {
			set.add(s);
		}
		Queue<String> queue = new LinkedList<>();
		queue.offer(beginWord);
		set.remove(beginWord);
		int level = 1;
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				String cur = queue.poll();
				//terminate condition
				if(cur.equals(endWord)) {
					return level;
				}
				for(String nei : getNeis(cur, set)) {
					queue.offer(nei);
				}
			}
			level++;
		}
		return 0;
	}

	private List<String> getNeis(String cur, Set<String> wordSet) {
		List<String> res = new ArrayList<>();
		for(int i = 0; i < cur.length(); i++) {
			char[] array = cur.toCharArray();
			for(char ch = 'a'; ch <= 'z'; ch++) {
				array[i] = ch;
				String word = new String(array);
				if (wordSet.remove(word)) {
					res.add(word);
				}
			}
		}
		return res;
	}
}
