package com.chentianran;

import com.chentianran.utility.ListNode;

/**
 * Created by Tianran on 2/27/2017.
 */
public class LC141LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		if(head == null || head.next == null) {
			return false;
		}
		ListNode slow = head;
		ListNode fast = head;
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				return true;
			}
		}
		return false;
	}
}
