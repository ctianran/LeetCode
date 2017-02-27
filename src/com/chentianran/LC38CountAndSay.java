package com.chentianran;

/**
 * Created by Tianran on 2/26/2017.
 */
public class LC38CountAndSay {
	public String countAndSay(int n) {
		String res = "1";
		if(n == 1) {
			return res;
		}
		int i = 1;
		while(i < n) {
			StringBuilder sb = new StringBuilder();
			int count = 1;
			for(int j = 1; j < res.length(); j++) {
				if(res.charAt(j) == res.charAt(j - 1)) {
					count++;
				} else {
					sb.append(count);
					sb.append(res.charAt(j - 1));
					count = 1;
				}
			}
			sb.append(count);
			sb.append(res.charAt(res.length() - 1));
			i++;
		}
		return res;
	}
}
