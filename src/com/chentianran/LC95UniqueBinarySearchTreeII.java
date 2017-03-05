package com.chentianran;

import com.chentianran.utility.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianran on 3/3/2017.
 */
public class LC95UniqueBinarySearchTreeII {
	public List<TreeNode> generateTrees(int n) {
		if(n <= 0) {
			return new ArrayList<TreeNode>();
		}
		return helper(1, n);
	}

	private List<TreeNode> helper(int left, int right) {
		List<TreeNode> list = new ArrayList<>();
		if(left > right) {
			list.add(null);
			return list;
		}
		for(int i = left; i <= right; i++) {
			List<TreeNode> ls = helper(left, i - 1);
			List<TreeNode> rs = helper(i + 1, right);
			for(TreeNode l : ls) {
				for(TreeNode r : rs) {
					TreeNode cur = new TreeNode(i);
					cur.left = l;
					cur.right = r;
					list.add(cur);
				}
			}
		}
		return list;
	}
}
