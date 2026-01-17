package programmers.level1.자연수_뒤집어_배열로_만들기;

/**
 * Platform: Programmers
 * Problem: 12932
 * Title: 자연수 뒤집어 배열로 만들기
 * 정답률: 88%
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/12932
 * NOTE: 교재 풀이(배열 및 문자열 관련 메서드 활용)
 */
public class P_12932_BOOK {
	
	public int[] solution(long n) {
		// 문자엷 변환
		String str = Long.toString(n);
		// StringBuilder를 활용하면서 뒤집기
		StringBuilder sb = new StringBuilder(str).reverse();
		String reversedStr = sb.toString();
		// 문자 쪼개기
		char[] chAry = reversedStr.toCharArray();
		int[] answer = new int[str.length()];
		for (int i = 0; i < chAry.length; i++) {
			answer[i] = Character.getNumericValue(chAry[i]);	// chAry[i] - '0' 형태로도 표현 가능
		}
		return answer;
	}
}
