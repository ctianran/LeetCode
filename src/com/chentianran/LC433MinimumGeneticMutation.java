package com.chentianran;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by Tianran on 8/28/2017.
 */
public class LC433MinimumGeneticMutation {
	public int minMutation(String start, String end, String[] bank) {
		if(start.equals(end)) {
			return 0;
		}
		Set<String> bankSet = new HashSet<>();
		for(String s : bank) {
			bankSet.add(s);
		}
		char[] chars = new char[] {'A', 'C', 'G', 'T'};

		Set<String> visited = new HashSet<>();
		Queue<String> queue = new LinkedList<>();
		queue.offer(start);
		visited.add(start);
		int level = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				String cur = queue.poll();
				if (cur.equals(end)) {
					return level;
				}

				char[] curArray = cur.toCharArray();
				for(int j = 0; j < curArray.length; j++) {
					char old = curArray[j];
					for(char ch : chars) {
						curArray[j] = ch;
						String temp = new String(curArray);
						if(!visited.contains(temp) && bankSet.contains(temp)) {
							visited.add(temp);
							queue.offer(temp);
						}
					}
					curArray[j] = old;
				}
			}
			level++;
		}
		return -1;
	}
}
