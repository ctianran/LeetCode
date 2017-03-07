package com.chentianran;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Tianran on 3/6/2017.
 */
public class LC255VerifyPreorderSequenceInBinarySearchTree {
	public boolean verifyPreorder(int[] preorder) {
		if(preorder == null || preorder.length <= 1) {
			return true;
		}
		Deque<Integer> stack = new LinkedList<>();
		int min = Integer.MIN_VALUE;
		for(int i = 0; i < preorder.length; i++) {
			if(preorder[i] < min) {
				return false;
			}
			while(!stack.isEmpty() && stack.peekFirst() < preorder[i]) {
				min = stack.pollFirst();
			}
			stack.offerFirst(preorder[i]);
		}
		return true;
	}
}
