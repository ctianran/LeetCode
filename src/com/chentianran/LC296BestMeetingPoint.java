package com.chentianran;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Tianran on 2/18/2017.
 */
public class LC296BestMeetingPoint {
	public int minTotalDistance(int[][] grid) {
		if(grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		List<Integer> rows = new ArrayList<>();
		List<Integer> cols = new ArrayList<>();
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				if(grid[i][j] == 1) {
					rows.add(i);
					cols.add(j);
				}
			}
		}
		return getMin(rows) + getMin(cols);
	}

	private int getMin(List<Integer> list) {
		Collections.sort(list);
		int res = 0;
		int left = 0;
		int right = list.size() - 1;
		while(left < right) {
			res += list.get(right--) - list.get(left++);
		}
		return res;
	}

	public static void main(String[] args) {
		int[][] grid = new int[][] {{1,0,0,0,1},
						                    {0,0,0,0,0},
						                    {0,0,1,0,0}};
		LC296BestMeetingPoint sol = new LC296BestMeetingPoint();
		int res = sol.minTotalDistance(grid);
		System.out.println(res);
	}
}
