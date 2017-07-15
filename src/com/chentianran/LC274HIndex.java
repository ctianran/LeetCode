package com.chentianran;

import java.util.Arrays;

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

	public int hIndex(int[] citations) {
		if(citations == null || citations.length == 0) {
			return 0;
		}
		Arrays.sort(citations);
		int res = 0;
		for(int i = 0; i < citations.length; i++) {
			int smaller = Math.min(citations[i], citations.length - i);
			res = Math.max(res, smaller);
		}
		return res;
	}

	public static void main(String[] args) {
		int[] citations = new int[] {0, 1, 3, 3, 5};
		LC274HIndex sol = new LC274HIndex();
		int res = sol.hIndex(citations);
		System.out.println(res);
	}
}
