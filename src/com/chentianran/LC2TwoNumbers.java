package com.chentianran;

import com.chentianran.utility.ListNode;

/**
 * Created by Tianran on 2/14/2017.
 */
public class LC2TwoNumbers {
		public ListNode add(ListNode l1, ListNode l2) {
			if(l1 == null) {
				return l2;
			} else if(l2 == null) {
				return l1;
			}

			int carry = 0;
			ListNode dummy = new ListNode(0);
			ListNode cur = dummy;
			while(l1 != null || l2 != null) {
				int num = 0;
				num += carry;
				if(l1 != null) {
					num += l1.val;
				}
				if(l2 != null) {
					num += l2.val;
				}
				cur.next = new ListNode(num % 10);
				cur = cur.next;
				carry = num / 10;
			}

			if(carry > 0) {
				cur.next = new ListNode(carry);
			}
			return dummy.next;
	}
}
