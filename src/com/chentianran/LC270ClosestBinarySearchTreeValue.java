package com.chentianran;

import com.chentianran.utility.TreeNode;

/**
 * Created by Tianran on 3/7/2017.
 */
public class LC270ClosestBinarySearchTreeValue {
	public int closestValue(TreeNode root, double target) {
		if(root == null) {
			return Integer.MIN_VALUE;
		}
		int result = root.val;
		while(root != null) {
			if (root.val == target) {
				return root.val;
			} else {
				if (Math.abs(result - target) > Math.abs(root.val - target)) {
					result = root.val;
				}
				if (root.val < target) {
					root = root.right;
				}
				if (root.val > target) {
					root = root.left;
				}
			}
		}
		return result;
	}
}
