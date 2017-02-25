package com.chentianran;

import com.chentianran.utility.ListNode;

/**
 * Created by Tianran on 2/24/2017.
 */
public class LC160IntersectionOfTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA == null || headB == null ) {
			return null;
		}
		//check if two list intersects,
		//and get the length of each list
		int lengthA = 1;
		int lengthB = 1;
		ListNode curA = headA;
		ListNode curB = headB;
		while(curA.next != null) {
			lengthA++;
			curA = curA.next;
		}
		while(curB.next != null) {
			lengthB++;
			curB = curB.next;
		}
		if(curA != curB) {
			return null;
		}
		curA = headA;
		curB = headB;
		int diff = Math.abs(lengthA - lengthB);
		if(lengthA < lengthB) {
			while(diff > 0) {
				curB = curB.next;
				diff--;
			}
		} else {
			while(diff > 0) {
				curA = curA.next;
				diff--;
			}
		}
		while(curA != curB) {
			curA = curA.next;
			curB = curB.next;
		}
		return curA;
	}

}
