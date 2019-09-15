package com.chentianran.utility;

/**
 * Created by Tianran on 11/16/2017.
 */
public class LC468ValidateIPAddress {
	public String validIPAddress(String IP) {
		if(IP == null || IP.length() == 0) {
			return "Neither";
		}
		if(isIPv4(IP)) {
			return "IPv4";
		}
		if(isIPv6(IP)) {
			return "IPv6";
		}
		return "Neither";
	}

	public boolean isIPv4(String IP) {
			if(IP.charAt(0) == '.' || IP.charAt(IP.length() - 1) == '.') {
				return false;
			}
			String[] strs = IP.split("\\.");
			if(strs.length != 4) {
				return false;
			}
			for(String str : strs) {
				if(str.length() == 0 || str.length() > 3 || str.length() > 1 && str.charAt(0) == '0') {
					return false;
				}
				for(char ch : str.toCharArray()) {
					if(!Character.isDigit(ch)) {
						return false;
					}
				}
				if(Integer.parseInt(str) > 255) {
					return false;
				}
			}
			return true;
	}

	public boolean isIPv6(String IP) {
		if(IP.charAt(0) == ':' || IP.charAt(IP.length() - 1) == ':') {
			return false;
		}
		String[] strs = IP.split(":");
		if(strs.length != 8) {
			return false;
		}
		for(String str : strs) {
			if(str.length() == 0 || str.length() > 4) {
				return false;
			}
			for(char ch : str.toCharArray()) {
				if(Character.isDigit(ch)) {
					continue;
				}
				if(Character.toLowerCase(ch) < 'a' || Character.toLowerCase(ch) > 'f') {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String IP = "255.255.255.255";

		LC468ValidateIPAddress sol = new LC468ValidateIPAddress();
		System.out.println(sol.isIPv4(IP));
	}
}
