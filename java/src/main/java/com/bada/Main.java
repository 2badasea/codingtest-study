package com.bada;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		Main main = new Main();
		System.out.println(main.solution("aabbaccc"));
	}
	
	// 압축 문자열
	public int solution(String s) {
		int minVal = s.length();    // 최악의 경우 (압축이 되지 않았을 때 처음 길이 그대로)
		if (minVal == 1) {
			return minVal;
		}
		// 절반까지만 잘라낸다.
		for (int i = 1; i <= s.length() / 2; i++) {
			// 1 ~ n개까지 잘라서 압축된 문자열의 길이를 반환
			int res = compressedLength(s, i);
			minVal = Math.min(minVal, res);
		}
		return minVal;
	}
	
	private int compressedLength(String s, int n) {
		StringBuilder sb = new StringBuilder();
		String compareStr = s.substring(0, n);    // 비교 기준 문자열
		int repeat = 1;
		for (int i = n; i <= s.length(); i += n) {
			int endIndex = Math.min(i + n, s.length());
			String subStr = s.substring(i, endIndex);
			if (compareStr.equals(subStr)) {
				repeat++;
			} else {
				if (repeat > 1) {
					sb.append(repeat);
				}
				sb.append(compareStr);
				compareStr = subStr;
				repeat = 1;
			}
		}
		sb.append(compareStr);
		return sb.length();
	}
	
	
}