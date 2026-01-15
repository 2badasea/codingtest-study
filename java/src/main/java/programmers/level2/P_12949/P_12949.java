package programmers.level2.P_12949;

/**
 * Platform: Programmers
 * Problem: 12949
 * Title: 행렬의 곱셈
 * 정답률: 67%
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/12949
 * NOTE: 2차원 배열에서 곱셈이 가능하기 위해선 두 행렬에서 선행행렬의 열 크기와 후행행렬의 행의 크기가 같아야 한다. ex) 3x3, 3x2는 가능하지만, 3x2, 3x3은 불가능하다.
 */
public class P_12949 {
	
	public int[][] solution(int[][] arr1, int[][] arr2) {
		
		int[][] answer = new int[arr1.length][arr2[0].length];
		for (int y = 0; y < answer.length; y++) {
			for (int x = 0; x < answer[y].length; x++) {
				answer[y][x] = 0;
				for (int k = 0; k < arr1[y].length; k++) {
					answer[y][x] += arr1[y][k] * arr2[k][x];
				}
			}
		}
		return answer;
	}
}
