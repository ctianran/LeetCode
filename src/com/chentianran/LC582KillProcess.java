package com.chentianran;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tianran on 5/16/2017.
 */
public class LC582KillProcess {
	public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
		List<Integer> res = new ArrayList<>();
		Map<Integer, List<Integer>> map = new HashMap<>();
		for(int i = 0; i < ppid.size(); i++) {
			if(!map.containsKey(ppid.get(i))) {
				map.put(ppid.get(i), new ArrayList<>());
			}
			map.get(ppid.get(i)).add(pid.get(i));
		}
		helper(map, kill, res);
		return res;
	}

	private void helper(Map<Integer, List<Integer>> map, int kill, List<Integer> res) {
		if(kill != 0) {
			res.add(kill);
		}
		if(map.get(kill) == null) {
			return;
		}
		for(int num : map.get(kill)) {
			helper(map, num, res);
		}
	}
}
