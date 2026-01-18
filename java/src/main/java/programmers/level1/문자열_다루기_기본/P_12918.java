package programmers.level1.문자열_다루기_기본;

/**
 * Platform: Programmers
 * Problem: 12918
 * Title: 문자열 다루기 기본
 * 정답률: 82%
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/12918
 */
public class P_12918 {
	
	public boolean solution(String s) {
		
		// 내가 풀이한 방식
		try {
			Integer.parseInt(s);
			return s.length() == 4 || s.length() == 6;
		} catch (Exception e) {
			return false;
		}
		
		// 교재방식 && 응용
		// return (s.matches("[0-9]") && (s.length() == 4 || s.length() == 6));
		// return s.matches("[0-9]{4}|[0-9]{6}");
		// NOTE 숫자가 모두 맞는지 확인하기 위해 s.toCharArray()후 반복문을 통해 Character.isDigit(char c)를 사용하는 것도 가능
		
	}
}
