package com.chentianran;

import com.chentianran.utility.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Tianran on 3/9/2017.
 */
public class LC56MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> result = new ArrayList<>();
		if(intervals == null || intervals.size() == 0) {
			return result;
		}
		Collections.sort(intervals, new Comparator<Interval>(){
			@Override
			public int compare(Interval i1, Interval i2) {
				if(i1.start == i2.start) {
					return 0;
				}
				return i1.start < i2.start ? -1 : 1;
			}
		});

		Interval prev = intervals.get(0);
		for(int i = 1; i < intervals.size(); i++) {
			Interval cur = intervals.get(i);
			if(cur.start > prev.end) {
				result.add(prev);
				prev = cur;
			} else {
				prev.end = Math.max(prev.end, cur.end);
			}
		}
		result.add(prev);
		return result;
	}
}
