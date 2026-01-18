package programmers.level1.문자열_내_p와_y의_개수;


/**
 * Platform: Programmers
 * Problem: 12916
 * Title: 문자열 내 p와 y의 개수
 * 정답률: 87%
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/12916
 * NOTE: 교재 확인 전 풀이
 * cf) 단순히 문자열을 교체하는 건 replace지만, replaceAll을 이용하면 정규표현식으로 사용할 수 있다. ex) "123abc456".replaceAll("[0-9]", "")을 사용하는 경우 "abc"만 남는다.
 */
public class P_12916 {
	
	// 개수를 비교할 때, 대문자와 소문자는 구분하지 않음
	boolean solution(String s) {
		s = s.toLowerCase();
		String pStr = s.replaceAll("y", "");
		String yStr = s.replaceAll("p", "");
		return pStr.length() == yStr.length();
	}

}
