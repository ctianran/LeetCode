package com.chentianran;

import com.chentianran.utility.GraphNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tianran on 2/9/2017.
 */
public class LC133CloneGraph {
	public GraphNode cloneGraph(GraphNode node) {
		if(node == null) {
			return null;
		}
		Map<GraphNode, GraphNode> map = new HashMap<>();
		helper(node, map);
		return map.get(node);
	}

	private void helper(GraphNode node, Map<GraphNode, GraphNode> map) {
		if(map.containsKey(node)) {
			return;
		}
		GraphNode copyNode = new GraphNode(node.val);
		map.put(node, copyNode);
		for(GraphNode nei : node.neighbors) {
			helper(nei, map);
			copyNode.neighbors.add(map.get(nei));
		}
	}
}
