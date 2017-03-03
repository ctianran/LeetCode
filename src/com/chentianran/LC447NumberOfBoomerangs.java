package com.chentianran;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tianran on 3/3/2017.
 */
public class LC447NumberOfBoomerangs {
	public int numberOfBoomerangs(int[][] points) {
		Map<Integer, Integer> map = new HashMap<>();
		int res = 0;
		for(int i = 0; i < points.length; i++) {
			for(int j = 0; j < points.length; j++) {
				if(i == j) {
					continue;
				}
				int d = getDistance(points[i], points[j]);
				Integer count = map.get(d);
				if(count == null) {
					map.put(d, 1);
				} else {
					map.put(d, count + 1);
				}
			}
			for(int val : map.values()) {
				res += val * (val - 1);
			}
			map.clear();
		}
		return res;
	}

	private int getDistance(int[] a, int[] b) {
		int dx = a[0] - b[0];
		int dy = a[1] - b[1];
		return dx * dx + dy * dy;
	}

}
