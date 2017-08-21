package com.chentianran;

import com.chentianran.utility.Interval;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Tianran on 2/18/2017.
 */
public class LC252MeetingRooms {
	public boolean canAttendMeetings(Interval[] intervals) {
		if(intervals.length <= 1) {
			return true;
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

		for(int i = 1; i < intervals.length; i++) {
			if(intervals[i-1].end > intervals[i].start) {
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Interval[] intervals = new Interval[] {new Interval(0, 4),
		                                       new Interval(5, 10),
																					 new Interval(15,20)};
		LC252MeetingRooms sol = new LC252MeetingRooms();
		System.out.println(sol.canAttendMeetings(intervals));
		System.out.println(3);
		System.out.println(~3);
	}
}
