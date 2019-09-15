package com.chentianran;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * Created by Tianran on 9/1/2017.
 */
public class LC379DesignPhoneDirectory {
		private Queue<Integer> phoneNumbers;
		private Set<Integer> set;
		private int maxNumber;
		public LC379DesignPhoneDirectory(int maxNumber) {
			phoneNumbers = new ArrayDeque<>();
			set = new HashSet<>();
			this.maxNumber = maxNumber;
				for(int i = 0; i < maxNumber; i++) {
				phoneNumbers.offer(i);
			}
		}

		public int get() {
			Integer res = phoneNumbers.poll();
			if(res == null) {
				return -1;
			}
			set.add(res);
			return res;
		}

		public boolean check(int number) {
			if(number < 0 || number >= maxNumber) {
				return false;
			}
			return !set.contains(number);
		}

		public void release(int number) {
			if (set.remove(number)) {
				phoneNumbers.offer(number);
			}
		}
}
