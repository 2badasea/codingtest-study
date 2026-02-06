package programmers.level1.K번째_수;

import java.util.Arrays;

/**
 * Platform: Programmers
 * Problem: 42748
 * Title: K번째 수
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/42748
 */
public class P_42748 {
	
	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		
		
		for (int i = 0; i < commands.length; i++) {
			int startIndex = commands[i][0];
			int endIndex = commands[i][1];
			int seq = commands[i][2];
			
			// 교재에선 아래 과정을 int[] subs = Arrays.copyOfRange(array, from, to); 형태로 배열을 채우기도 함
			int[] tmpAry = new int[endIndex - startIndex + 1];
			for (int j = 0; j < tmpAry.length; j++) {
				tmpAry[j] = array[startIndex - 1 + j];
			}
			// 오름차순 정렬
			Arrays.sort(tmpAry);
			answer[i] = tmpAry[seq -1 ];
		}
		
		return answer;
	}
}
