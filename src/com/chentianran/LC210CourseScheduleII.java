package com.chentianran;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Tianran on 3/2/2017.
 */
public class LC210CourseScheduleII {
	public int[] findOrder(int numCourses, int[][] pre) {
		if(pre == null) {
			throw new IllegalArgumentException("invalid input");
		}
		int[] result = new int[numCourses];
		if (pre.length == 0) {
			for(int i = 0; i < numCourses; i++) {
				result[i] = i;
			}
			return result;
		}
		int[] count = new int[numCourses];
		for(int i = 0; i < pre.length; i++) {
			count[pre[i][0]]++;
		}
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 0; i < count.length; i++) {
			if(count[i] == 0) {
				queue.offer(i);
			}
		}
		int numNoPre = queue.size();
		int index = 0;
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			result[index++] = cur;
			for(int i = 0; i < pre.length; i++) {
				if(pre[i][1] == cur) {
					count[pre[i][0]]--;
					if(count[pre[i][0]] == 0) {
						numNoPre++;
						queue.offer(pre[i][0]);
					}
				}
			}
		}
		if(numNoPre == numCourses) {
			return result;
		} else {
			return new int[0];
		}
	}

	public static void main(String[] args) {
		int[][] pre = new int[][] {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
		LC210CourseScheduleII sol = new LC210CourseScheduleII();
		int[] res = sol.findOrder(4, pre);
		for(int num : res) {
			System.out.print(num + " ");
		}
	}
}
