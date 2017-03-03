package com.chentianran;

import com.chentianran.utility.GraphNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by Tianran on 2/9/2017.
 */
public class LC133CloneGraph {
	//DFS
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

	//BFS
	public GraphNode cloneGraphII(GraphNode node) {
		if(node == null) {
			return null;
		}
		Map<GraphNode, GraphNode> map = new HashMap<>();
		Queue<GraphNode> queue = new LinkedList<>();
		map.put(node, new GraphNode(node.val));
		queue.offer(node);
		while(!queue.isEmpty()) {
			GraphNode cur = queue.poll();
			if(!map.containsKey(cur)) {
				map.put(cur, new GraphNode(cur.val));
			}
			for(GraphNode nei : cur.neighbors) {
				if(!map.containsKey(nei)) {
					map.put(nei, new GraphNode(nei.val));
					queue.offer(nei);
				}
				map.get(cur).neighbors.add(map.get(nei));
			}
		}
		return map.get(node);
	}

}
