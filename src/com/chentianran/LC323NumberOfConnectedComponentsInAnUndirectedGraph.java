package com.chentianran;

import java.util.*;

/**
 * Created by Tianran on 6/7/2017.
 */
public class LC323NumberOfConnectedComponentsInAnUndirectedGraph {
	public int countComponents(int n, int[][] edges) {
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for(int i = 0; i < n; i++) {
			graph.put(i, new ArrayList<>());
		}
		for(int[] e : edges) {
			graph.get(e[0]).add(e[1]);
			graph.get(e[1]).add(e[0]);
		}

		int res = 0;
		Set<Integer> visited = new HashSet<>();
		for(int i = 0; i < n; i++) {
			if(visited.add(i)) {
				dfs(i, graph, visited);
				res++;
			}
		}
		return res;
	}

	private void dfs(Integer i, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
		for(Integer n : graph.get(i)) {
			if(visited.add(n)) {
				dfs(n, graph, visited);
			}
		}
	}
}
