package com.chentianran;

import com.chentianran.utility.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianran on 8/10/2017.
 */
public class LC366FindLeaversOfBinaryTree {
	public List<List<Integer>> findLeaves(TreeNode root){
		List<List<Integer>> res = new ArrayList<>();
		if(root == null) {
			return res;
		}
		getHeight(root, res);
		return res;
	}

	private int getHeight(TreeNode root, List<List<Integer>> res) {
		if(root == null) {
			return -1;
		}
		int left = getHeight(root.left, res);
		int right = getHeight(root.right, res);
		int cur = Math.max(left, right) + 1;

		if(res.size() == cur) {
			res.add(new ArrayList<>());
		}
		res.get(cur).add(root.val);
		return cur;
	}
}
