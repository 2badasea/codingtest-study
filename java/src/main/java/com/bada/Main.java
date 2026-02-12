package com.bada;

public class Main {
	
	public static void main(String[] args) {
		Main m = new Main();
	}
	
	public String solution(String s, int n) {
		StringBuilder sb = new StringBuilder();
		for (char c : s.toCharArray()) {
			sb.append(processor(c, n));
		}
		return sb.toString();
	}
	
	// n은 1이상, 25이하인 자연수 => 한 번에 대문자에서 소문자로 연달아 변경되는 경우는 없음
	private char processor(char c, int n) {
		if (Character.isWhitespace(c)) {
			return c;
		}
		
		
	}
	
}