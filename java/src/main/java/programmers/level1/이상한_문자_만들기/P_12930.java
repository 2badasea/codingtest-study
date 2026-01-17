package programmers.level1.이상한_문자_만들기;

/**
 * Platform: Programmers
 * Problem: 12930
 * Title: 이상한 문자 만들기
 * 정답률: 77%
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/12930
 * NOTE: 교재 확인 전 풀이
 */
public class P_12930 {
	
	public String solution(String s) {
		StringBuilder sb = new StringBuilder();
		
		char[] chars = s.toCharArray();
		boolean isNextUpper = true;
		
		for (char ch : chars) {
			if (!Character.isAlphabetic(ch)) {
				sb.append(' ');
				isNextUpper = true;
				continue;
			}
			if (isNextUpper) {
				sb.append(Character.toUpperCase(ch));
			} else {
				sb.append(Character.toLowerCase(ch));
			}
			isNextUpper = !isNextUpper;
		}
		return sb.toString();
	}
}
