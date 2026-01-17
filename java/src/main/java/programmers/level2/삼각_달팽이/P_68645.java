package programmers.level2.삼각_달팽이;

/**
 * Platform: Programmers
 * Problem: 68645
 * Title: 삼각 달팽이
 * 정답률: 55%
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/68645
 */
public class P_68645 {
	
	// n은 1이상 1000 이하
	public int[] solution(int n) {
		// 1. 크기가 n인 배열 생성
		// 2. 시작점 0,0을 기준으로 밑으로 -> 옆으로 -> 위로 삽입할 것
		int[][] sq = new int[n][n];
		
		int x = 0;
		int y = 0;
		int num = 1;
		while (true) {
			
			// 아래로 이동
			while (true) {
				sq[y][x] = num++;
				// 행(y)가 길이가 동일해지거나 그 아래에 값이 이미 있는 경우 중단(break)
				if (y + 1 == n || sq[y + 1][x] != 0) {
					break;
				}
				y++;
			}
			// x++를 하기 전에 체크
			if (x + 1 == n || sq[y][x + 1] != 0) {
				break;
			}
			x++;
			
			// 옆으로 이동
			while (true) {
				sq[y][x] = num++;
				if (x + 1 == n || sq[y][x + 1] != 0) {
					break;
				}
				x++;
			}
			if (sq[y - 1][x - 1] != 0) {
				break;
			}
			y--;
			x--;
			
			// 위로 이동
			while (true) {
				sq[y][x] = num++;
				if (sq[y - 1][x - 1] != 0) {
					break;
				}
				y--;
				x--;
			}
			if (y + 1 == n || sq[y + 1][x] != 0) {
				break;
			}
			y++;
		}
		
		int[] answer = new int[num - 1];
		int index = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				answer[index++] = sq[i][j];
			}
		}
		return answer;
	}
}
