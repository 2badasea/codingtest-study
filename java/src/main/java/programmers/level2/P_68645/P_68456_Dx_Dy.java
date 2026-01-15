package programmers.level2.P_68645;

/**
 * Platform: Programmers
 * Problem: 68645
 * Title: 삼각 달팽이
 * 정답률: 55%
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/68645
 * NOTE: dx, dy 변화량을 이용한 방식 cf) 변화량: 특정 방향으로 이동할 때 해당 좌표값이 어떻게 변화하는지 의미
 */
public class P_68456_Dx_Dy {
	
	private static final int[] dx = {0, 1, -1};
	private static final int[] dy = {1, 0, -1};
	
	public int[] solution(int n) {
		
		// 2차원 배열 선언
		int[][] triangle = new int[n][n];
		int num = 1;
		int x = 0;
		int y = 0;
		int d = 0;
		
		while (true) {
			triangle[y][x] = num++;
			int nx = x + dx[d];    // 다음 x좌표
			int ny = y + dy[d];    // 다음 y좌표
			if (nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0) {
				d = (d + 1) % 3;
				nx = x + dx[d];
				ny = y + dy[d];
				if (nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0) {
					break;
				}
			}
			x = nx;
			y = ny;
		}
		
		int[] answer = new int[num - 1];
		int index = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				answer[index++] = triangle[i][j];
			}
		}
		return answer;
	}
}
