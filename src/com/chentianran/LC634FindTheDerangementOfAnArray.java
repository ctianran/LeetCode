package com.chentianran;

/**
 * Created by Tianran on 8/2/2017.
 */
public class LC634FindTheDerangementOfAnArray {
	public long findDerangement(int n) {
		long dn2 = 0;
		long dn1 = 1;
		long res = n == 1 ? 0 : 1;
		for(int i = 3; i <= n; i++) {
			res = ((i - 1) * (dn1 + dn2)) % 1000000007;
			dn2 = dn1;
			dn1 = res;
		}
		return res;
	}

	public static void main(String[] args) {
		LC634FindTheDerangementOfAnArray sol = new LC634FindTheDerangementOfAnArray();
		long res = sol.findDerangement(4);
		System.out.println(res);
	}
}
