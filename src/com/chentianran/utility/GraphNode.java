package com.chentianran.utility;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianran on 2/9/2017.
 */
public class GraphNode {
	public int val;
	public List<GraphNode> neighbors;
	public GraphNode(int val) {
		this.val = val;
		this.neighbors = new ArrayList<GraphNode>();
	}
}
