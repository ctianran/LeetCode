package com.chentianran;

import com.chentianran.utility.Interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Tianran on 2/18/2017.
 */
public class LC253MeetingRoomsII {
	public int minMeetingRooms(Interval[] intervals) {
		if(intervals == null || intervals.length == 0) {
			return 0;
		}
		Arrays.sort(intervals, new Comparator<Interval>(){
			@Override
			public int compare(Interval i1, Interval i2) {
				if(i1.start == i2.start) {
					return 0;
				}
				return i1.start < i2.start ? -1 : 1;
			}
		});
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for(int i = 0; i < intervals.length; i++) {
			if(!minHeap.isEmpty() && intervals[i].start >= minHeap.peek()) {
				minHeap.poll();
			}
			minHeap.offer(intervals[i].end);
		}
		return minHeap.size();
	}


	public static void main(String[] args) {
		Interval[] intervals = new Interval[] {new Interval(0, 4),
						                               new Interval(3, 10),
						                               new Interval(9,20)};
		LC253MeetingRoomsII sol = new LC253MeetingRoomsII();
		System.out.println(sol.minMeetingRooms(intervals));
	}
}
