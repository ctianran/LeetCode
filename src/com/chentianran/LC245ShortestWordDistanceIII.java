package com.chentianran;

/**
 * Created by Tianran on 7/26/2017.
 */
public class LC245ShortestWordDistanceIII {
	public int shortestWordDistance(String[] words, String word1, String word2) {
		if(words == null || words.length == 0) {
			return 0;
		}
		boolean isSame = word1.equals(word2);
		int pos1 = -1;
		int pos2 = -1;
		int res = Integer.MAX_VALUE;
		for(int i = 0; i < words.length; i++) {
			if(words[i].equals(word1)) {
				if(isSame) {
					pos1 = pos2;
					pos2 = i;
				} else {
					pos1 = i;
				}
			} else if(words[i].equals(word2)) {
				pos2 = i;
			}
			if(pos1 != -1 && pos2 != -1) {
				res = Math.min(res, Math.abs(pos1 - pos2));
			}
		}
		return res;
	}
}
