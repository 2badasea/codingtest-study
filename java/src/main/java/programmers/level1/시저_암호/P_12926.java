package programmers.level1.시저_암호;

/**
 * Platform: Programmers
 * Problem: 12926
 * Title: 시저 암호
 * 정답률: 74%
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/12926
 * NOTE: 교재 확인 전 풀이
 */
public class P_12926 {
	
	public String solution(String s, int n) {
		char[] chars = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (char aChar : chars) {
			sb.append(push(aChar, n));
		}
		
		return sb.toString();
	}
	
	public char push(char ch, int n) {
		if (!Character.isAlphabetic(ch)) return ' ';
		char offSet = Character.isUpperCase(ch) ? 'A' : 'a';
		int curPosition = ch - offSet;
		int newPosition = (curPosition + n) % ('Z' - 'A' + 1);
		return (char) (newPosition + offSet);
	}
	
}
