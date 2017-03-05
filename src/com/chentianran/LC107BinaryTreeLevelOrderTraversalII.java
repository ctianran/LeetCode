package com.chentianran;

import com.chentianran.utility.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianran on 3/4/2017.
 */
public class LC107BinaryTreeLevelOrderTraversalII {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root == null) {
			return result;
		}
		int height = getHeight(root);
		for(int i = height; i > 0; i--) {
			List<Integer> cur = new ArrayList<>();
			helper(root, i, cur);
			result.add(cur);
		}
		return result;
	}

	private void helper(TreeNode root, int height, List<Integer> cur) {
		if(root == null) {
			return;
		}
		if(height == 1) {
			cur.add(root.val);
		} else {
			helper(root.left, height - 1, cur);
			helper(root.right, height - 1, cur);
		}
	}

	private int getHeight(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int left = getHeight(root.left);
		int right = getHeight(root.right);
		return 1 + Math.max(left, right);
	}
}
