package com.rem.adj;

import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		
		String s = "baacdccce";
		int step = 0;
		int i = 0;
		while(true) {
			char ourChar = s.charAt(i);  
			if(ourChar == s.charAt(i+1) || s.charAt(i+1) == ' ') {
				int j = i;
				while(j < s.length()-1 && (ourChar == s.charAt(j+1) || s.charAt(j+1) == ' ')) {
					j++;
				}
				s = remove(i,j,s);
				i = -1;
				step++;
			}
			i++;
			if(i == s.length()-1) {
				break;
			}
		}
		System.out.println("final Output =" + s);
		System.out.println("Total steps =" + step);
		

	}
	
	static String remove(int i, int j, String s) {
		s = s.substring(0,i) + s.substring(j+1,s.length());
		return s;
	}

	public static String removeDuplicates(String S, int K) {
		for (int i = 1, count = 1; i < S.length(); i++) {
			count = S.charAt(i) == S.charAt(i - 1) ? count + 1 : 1;
			if (count == K)
				S = removeDuplicates(S.substring(0, i - K + 1) + S.substring(i + 1), K);
		}
		return S;
	}

	static String removeUtil(String str, char last_removed) {

// If length of string is 1 or 0
		if (str.length() == 0 || str.length() == 1)
			return str;

// Remove leftmost same characters
// and recur for remaining 
// string
		if (str.charAt(0) == str.charAt(1)) {
			last_removed = str.charAt(0);
			while (str.length() > 1 && str.charAt(0) == str.charAt(1))
				str = str.substring(1, str.length());
			str = str.substring(1, str.length());
			return removeUtil(str, last_removed);
		}

// At this point, the first
// character is definiotely different 
// from its adjacent. Ignore first
// character and recursively 
// remove characters from remaining string
		String rem_str = removeUtil(str.substring(1, str.length()), last_removed);

// Check if the first character of
// the rem_string matches with 
// the first character of the original string
		if (rem_str.length() != 0 && rem_str.charAt(0) == str.charAt(0)) {
			last_removed = str.charAt(0);

// Remove first character
			return rem_str.substring(1, rem_str.length());
		}

// If remaining string becomes
// empty and last removed character
// is same as first character of
// original string. This is needed
// for a string like "acbbcddc"
		if (rem_str.length() == 0 && last_removed == str.charAt(0))
			return rem_str;

// If the two first characters
// of str and rem_str don't match, 
// append first character of str
// before the first character of
// rem_str
		return (str.charAt(0) + rem_str);
	}

	static String remove(String str) {
		char last_removed = '\0';
		return removeUtil(str, last_removed);
	}

}
