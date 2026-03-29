package programmers.level2.피보나치_수;

import java.util.Arrays;

/**
 * Platform: Programmers
 * Problem: 12945
 * Title: 피보나치 수
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/12945
 */
public class P12945 {
	
	// n은 2이상 100,000 이하인 자연수
	// n번째 피보나치 수를 1234567로 나눈 나머지를 리턴하는 함수를 만들기
	// 동적프로그래밍이란 개념을 활용하기
	private final int[] mem = new int[100001];
	private int fibonacci(int n) {
		if (mem[n] != -1) return mem[n];
		if (n == 0 || n == 1) return n;
		
		return mem[n] = (fibonacci(n - 1) + fibonacci(n - 2)) % 1234567;	// 애초에 메모이제이션 배열에 나머지값을 저장하도록 할 것(오브플로우 방지)
	}
	
	// mem 배열에 유효하지 않은 값으로 값을 채움
	public long solution(int n) {
		Arrays.fill(mem, -1);
		// bottom-up 방식으로 아래부터 값을 채움
		for (int i = 0; i <= n; n++) {
			fibonacci(i);
		}
		return fibonacci(n);
	}
	
	
	// 예전 풀이
	public long originSolution(int n) {
		long[] longStr = new long[n + 1];
		longStr[0] = 0;
		longStr[1] = 1;
		longStr[2] = 1;
		
		for (int count = 2; count <= n; count++) {
			longStr[count] = (longStr[count - 1] + longStr[count - 2]) % 1234567;
		}
		return longStr[n];
	}
	
}
