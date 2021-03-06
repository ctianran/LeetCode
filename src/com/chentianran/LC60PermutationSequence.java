package com.chentianran;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianran on 2/13/2017.
 */
public class LC60PermutationSequence {
	public String getPermutation(int n , int k) {

		int[] factorial = new int[n + 1];
		factorial[0] = 1;
		for(int i = 1; i <= n; i++) {
			factorial[i] = factorial[i-1] * i;
		}

		if(k <= 0 || k > factorial[n]) {
			return null;
		}

		List<Integer> numbers = new ArrayList<>();
		for(int i = 1; i <= n; i++) {
			numbers.add(i);
		}

		k--;
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= n; i++) {
			int index = k / factorial[n - i];
			sb.append(numbers.get(index));
			numbers.remove(index);
			k -= index * factorial[n - i];
		}

		return new String(sb);
	}

	public static void main(String[] args) {
		LC60PermutationSequence sol = new LC60PermutationSequence();
		String res = sol.getPermutation(1, 2);
		System.out.println(res);
	}
}
