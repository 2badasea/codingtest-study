package programmers.level1.K번째_수;

import java.util.Arrays;

public class P_42748_RE {
	
	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		
		for (int i = 0; i < commands.length; i++) {
			int start = commands[i][0];
			int end = commands[i][1];
			int order = commands[i][2];
			
			int[] tmpAry = new int[end - start + 1];
			for (int j = 0; j < tmpAry.length; j++) {
				tmpAry[j] = array[start - 1 + j];
			}
			// 오름차순 정렬
			Arrays.sort(tmpAry);
			answer[i] = tmpAry[order - 1];
		}
		
		return answer;
	}
}
