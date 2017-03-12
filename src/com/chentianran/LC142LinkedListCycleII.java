package com.chentianran;

import com.chentianran.utility.ListNode;

/**
 * Created by Tianran on 3/11/2017.
 */
public class LC142LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
		if(head == null || head.next == null) {
			return null;
		}
		ListNode slow = head;
		ListNode fast = head;
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				slow = head;
				while(slow != fast) {
					slow = slow.next;
					fast = fast.next;
				}
				return slow;
			}
		}
		return null;
	}
}
