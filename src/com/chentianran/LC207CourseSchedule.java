package com.chentianran;

import java.util.*;

/**
 * Created by Tianran on 3/2/2017.
 */
public class LC207CourseSchedule {
	//BFS
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		if (prerequisites == null) {
			throw new IllegalArgumentException("illegal prerequisties input");
		}
		if (numCourses == 0 || prerequisites.length == 0) {
			return true;
		}
		int[] count = new int[numCourses];
		for (int i = 0; i < prerequisites.length; i++) {
			count[prerequisites[i][0]]++;
		}
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < count.length; i++) {
			if (count[i] == 0) {
				queue.offer(i);
			}
		}
		int countNoPre = queue.size();
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int i = 0; i < prerequisites.length; i++) {
				if (prerequisites[i][1] == cur) {
					count[prerequisites[i][0]]--;
					if (count[prerequisites[i][0]] == 0) {
						countNoPre++;
						queue.offer(prerequisites[i][0]);
					}
				}
			}
		}
		return countNoPre == numCourses;
	}

	//DFS
	public boolean canFinishII(int numCourses, int[][] prerequisites) {
		if(prerequisites == null) {
			throw new IllegalArgumentException("illegal input");
		}
		int len = prerequisites.length;
		if(numCourses == 0 || len == 0) {
			return true;
		}
		Map<Integer, List<Integer>> map = new HashMap<>();
		int[] visit = new int[numCourses];
		for(int[] a : prerequisites) {
			if(map.containsKey(a[1])) {
				map.get(a[1]).add(a[0]);
			} else {
				List<Integer> list = new ArrayList<>();
				list.add(a[0]);
				map.put(a[1], list);
			}
		}

		for(int i = 0; i < numCourses; i++) {
			if(!helper(i, map, visit)) {
				return false;
			}
		}
		return true;
	}

	private boolean helper(int i, Map<Integer, List<Integer>> map, int[] visit) {
		//visited
		if(visit[i] == -1) {
			return true;
		}
		//visiting
		if(visit[i] == 1) {
			return false;
		}
		visit[i] = 1;
		if(map.containsKey(i)) {
			for(int j : map.get(i)) {
				if(!helper(j, map, visit)) {
					return false;
				}
			}
		}
		visit[i] = -1;
		return true;
	}

	public static void main(String[] args) {
		int[][] pre = new int[][] {{1, 0}, {0, 2}};
		LC207CourseSchedule sol = new LC207CourseSchedule();
		System.out.println(sol.canFinishII(3, pre));
	}
}
