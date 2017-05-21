package com.chentianran;

import com.chentianran.utility.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianran on 5/20/2017.
 */
public class LC501FindModeInBinarySearchTree {
	public int[] findMode(TreeNode root) {
		//corner case
		if(root == null) {
			return new int[0];
		}
		List<Integer> list = new ArrayList<>();
		TreeNode[] prev = new TreeNode[] {null};
		int[] count = new int[] {1};
		int[] max = new int[] {Integer.MIN_VALUE};
		//inorder traversal helper
		helper(root, prev, list, count, max);

		int[] res = new int[list.size()];
		for(int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
		}
		return res;
	}

	private void helper(TreeNode root, TreeNode[] prev, List<Integer> list, int[] count,
	                    int[] max) {
		//base case
		if(root == null) {
			return;
		}
		//inorder traversal
		helper(root.left, prev, list, count, max);
		//check current root value with previous node's value
		if(prev[0] != null) {
			if(prev[0].val == root.val) {
				count[0]++;
			} else {
				count[0] = 1;
			}
		}
		//adding the same node value to the list
		if(count[0] == max[0]) {
			list.add(root.val);
		//update the mode with the most frquent one
		} else if (count[0] > max[0]) {
			max[0] = count[0];
			list.clear();
			list.add(root.val);
		}
		//increment the prev pointer
		prev[0] = root;
		helper(root.right, prev, list, count, max);
	}
}
