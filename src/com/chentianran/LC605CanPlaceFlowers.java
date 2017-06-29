package com.chentianran;

/**
 * Created by Tianran on 6/28/2017.
 */
public class LC605CanPlaceFlowers {
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		if(n == 0) {
			return true;
		}
		int count = 0;
		for(int i = 0; i < flowerbed.length; i++) {
			if(flowerbed[i] == 0 && (i == 0 || flowerbed[i-1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
				flowerbed[i] = 1;
				count++;
				if(count == n) {
					return true;
				}
			}
		}
		return false;
	}
}
