package com.chentianran;

/**
 * Created by Tianran on 2/23/2017.
 */
public class LC274HIndex {
	public int hIndexI(int[] citations) {
		if(citations == null || citations.length == 0) {
			return 0;
		}
		int length = citations.length;
		int[] arr = new int[length + 1];
		for(int i = 0; i < length; i++) {
			if(citations[i] > length) {
				arr[length] += 1;
			} else {
				arr[citations[i]] += 1;
			}
		}
		int t = 0;
		int res = 0;

		for(int i = length; i >= 0; i--) {
			t = t + arr[i];
			if(t >= i) {
				return i;
			}
		}
		return 0;
	}
}
