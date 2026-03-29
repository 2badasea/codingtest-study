package programmers.level3;


/**
 * Platform: Programmers
 * Problem: P43105
 * Title: 정수 삼각형
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/P43105
 */
public class P43105 {
	
	public int solution(int[][] triangle) {
		int answer = 0;
		// 누적시켜 계산된 값을 담을 배열
		int[][] saveAry = new int[triangle.length][triangle.length];
		
		// 시작점은 동일
		saveAry[0][0] = triangle[0][0];
		
		// 두 번째부터 맨 아래까지 내려가면서 계산
		for (int i = 1; i < triangle.length; i++) {			// y축
			
			for (int j = 0; j <= i; j++) {		// x축 (정삼각형 구조 -> y보다 1개 더 많음)
				if (j == 0) {
					// 이전 층의 첫 번째값과 + 삼각형의 해당 위치의 숫자를 더한 값.
					saveAry[i][j] = saveAry[i -1][j] + triangle[i][j];
				} else {
				
				}
			}
		}
		
		
		return answer;
	}
}
