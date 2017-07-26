package com.chentianran;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tianran on 3/5/2017.
 */
public class LC244ShortestWordDistanceII {
		Map<String, List<Integer>> map;
		public LC244ShortestWordDistanceII(String[] words) {
			map = new HashMap<>();
			for(int i = 0; i < words.length; i++) {
				List<Integer> list = map.get(words[i]);
				if(list == null) {
					list = new ArrayList<>();
				}
				list.add(i);
				map.put(words[i], list);
			}
		}

		public int shortest(String word1, String word2) {
			List<Integer> list1 = map.get(word1);
			List<Integer> list2 = map.get(word2);
			if(list1 == null || list2 == null) {
				return Integer.MAX_VALUE;
			}
			int i = 0;
			int j = 0;
			int res = Integer.MAX_VALUE;
			while(i < list1.size() && j < list2.size()) {
				int idx1 = list1.get(i);
				int idx2 = list2.get(j);
				res = Math.min(res, Math.abs(idx1 - idx2));
				if(idx1 < idx2) {
					i++;
				} else {
					j++;
				}
			}
			return res;
		}
}
