package com.chentianran;

import com.chentianran.utility.Point;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tianran on 2/18/2017.
 */
public class LC149MaxPointsOnALine {
	public int maxPoints(Point[] points) {
		if(points == null || points.length == 0) {
			return 0;
		}
		if(points.length <= 2) {
			return points.length;
		}
		int result =0;
		for(int i = 0; i < points.length; i++) {
			Point p1 = points[i];
			int sameLine = 1;
			int sameX = 0;
			int most = 0;
			Map<Double, Integer> map = new HashMap<>();
			for(int j = 0; j < points.length; j++) {
				if(i == j) {
					continue;
				}
				Point p2 = points[j];
				if(p1.x == p2.x && p1.y == p2.y) {
					sameLine++;
				} else if (p1.x == p2.x) {
					sameX++;
				} else {
					double slope = ((p2.y - p1.y) + 0.0) / (p2.x - p1.x);
					Integer count = map.get(slope);
					if(count == null) {
						map.put(slope, 1);
					} else {
						map.put(slope, count + 1);
					}
					most = Math.max(most, map.get(slope));
				}
			}
			most = Math.max(most, sameX) + sameLine;
			result = Math.max(result, most);
		}
		return result;
	}

	public static void main(String[] args) {
		Point[] points = new Point[] {new Point(0, 0),
		                              new Point(1, 1),
		                              new Point(2 , 3),
																	new Point(3,3)};
		LC149MaxPointsOnALine sol = new LC149MaxPointsOnALine();
		int res = sol.maxPoints(points);
		System.out.println(res);
	}
}
