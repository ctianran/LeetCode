package com.chentianran;

/**
 * Created by Tianran on 2/12/2017.
 */
public class LC243ShortestWordDistance {
	public int shortestDistance(String[] words, String word1, String word2) {
		if(words == null || words.length <= 1 || word1.equals(word2)) {
			return 0;
		}
		int index1 = -1;
		int index2 = -1;
		int result = Integer.MAX_VALUE;
		for(int i = 0; i < words.length; i++) {
			if(words[i].equals(word1)) {
				index1 = i;
			}
			if(words[i].equals(word2)) {
				index2 = i;
			}

			if(index1 != -1 && index2 != -1) {
				result = Math.min(result, Math.abs(index1 - index2));
			}
		}
		return result;
	}
}
