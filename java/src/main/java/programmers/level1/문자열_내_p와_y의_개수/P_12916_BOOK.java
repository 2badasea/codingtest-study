package programmers.level1.문자열_내_p와_y의_개수;


/**
 * Platform: Programmers
 * Problem: 12916
 * Title: 문자열 내 p와 y의 개수
 * 정답률: 87%
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/12916
 * NOTE: 교재 풀이 => 내장메서드를 이용하지 않고, 최소한의 시간복잡도를 이용한 방식.
 */
public class P_12916_BOOK {
	
	// 개수를 비교할 때, 대문자와 소문자는 구분하지 않음
	boolean solution(String s) {
		int pCnt = 0;
		int yCnt = 0;
		
		for (char c : s.toCharArray()) {
			switch (c) {
				case 'p','P' -> pCnt++;
				case 'y','Y' -> yCnt++;
			}
		}
		
		return pCnt == yCnt;
	}

}
