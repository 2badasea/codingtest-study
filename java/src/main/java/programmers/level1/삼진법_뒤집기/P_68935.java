package programmers.level1.삼진법_뒤집기;

/**
 * Platform: Programmers
 * Problem: 68935
 * Title: 3진법 뒤집기
 * 정답률: 77%
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/68935
 * NOTE: 교재 확인 전 풀이
 */
public class P_68935 {
	
	// 자연수 n을 3진법 상에서 앞뒤로 뒤집은 후, 이르 ㄹ다시 10진법으로 표현한 수를 리턴
	public int solution(int n) {
		
		String str = Integer.toString(n, 3);
		String radix = new StringBuilder(str).reverse().toString();
		return Integer.valueOf(radix, 3);		// Long.valueof()도 존재
	}
}
