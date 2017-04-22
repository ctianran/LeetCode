package com.chentianran;

/**
 * Created by Tianran on 4/21/2017.
 */
public class LC551StudentAttendanceRecordI {
	public boolean checkRecord(String s) {
		int countA = 0;
		int countL = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == 'A') {
				countA++;
				countL = 0;
			} else if (s.charAt(i) == 'L') {
				countL++;
			} else {
				countL = 0;
			}
			if(countA > 1 || countL > 2) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String s = "PPALLL";
		LC551StudentAttendanceRecordI sol = new LC551StudentAttendanceRecordI();
		System.out.println(sol.checkRecord(s));
	}
}
