package com.chentianran;

import com.chentianran.utility.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianran on 3/10/2017.
 */
public class LC57InsertInterval {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> result = new ArrayList<>();

		for(Interval i : intervals) {
			if(i.end < newInterval.start) {
				result.add(i);
			} else if (i.start > newInterval.end) {
				result.add(newInterval);
				newInterval = i;
			} else if (i.end >= newInterval.start || i.start <= newInterval.end) {
				newInterval = new Interval(Math.min(i.start, newInterval.start), Math.max(i.end, newInterval.end));
			}
		}
		result.add(newInterval);
		return result;
	}
}
