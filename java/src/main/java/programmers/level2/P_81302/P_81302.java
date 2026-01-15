package programmers.level2.P_81302;

/**
 * Platform: Programmers
 * Problem: 81302
 * Title: 거리두기 확인하기
 * 정답률: 48%
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/81302
 */
public class P_81302 {
	private static final int[] dx = {0, -1, 1, 0};        // x좌표 변화량 (상 좌 우 하)  => 탐색방향을 구분하기 위해
	private static final int[] dy = {-1, 0, 0, 1};        // y좌표 변화량
	
	public int[] solution(String[][] places) {
		int[] answer = new int[places.length];
		for (int i = 0; i < answer.length; i++) {
			// 방 세팅
			String[] place = places[i];
			char[][] room = new char[place.length][];
			for (int j = 0; j < room.length; j++) {
				room[j] = place[j].toCharArray();
			}
			if (isDistanced(room)) {
				answer[i] = 1;
			} else {
				answer[i] = 0;
			}
		}
		return answer;
	}
	
	// 방 확인
	private boolean isDistanced(char[][] room) {
		// 사람 위치 확인
		for (int y = 0; y < room.length; y++) {
			for (int x = 0; x < room[y].length; x++) {
				if (room[y][x] != 'P') {
					continue;
				}
				// P(사람)인 경우에만 해당 위치를 기준으로 탐색 진행
				if (!isDistanced(room, x, y)) {
					return false;        // 거리두기를 지키지 못한 경우 false리턴 -> 메서드 종료
				}
			}
		}
		// 모두 만족하는 경우 true리턴
		return true;
	}
	
	// 사람 위치를 기준으로 탐색 진행
	private boolean isDistanced(char[][] room, int x, int y) {
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			// 탐색예정인 위치가 방을 벗어난 경우엔 패스
			if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) {
				continue;
			}
			// 각 탐색공간이 P라면 false리턴. 칸막이(X)는 검증 불필요
			switch (room[ny][nx]) {
				case 'P':
					return false;
				case 'O':
					// 빈테이블인 경우, 다시 탐색을 진행한다.
					if (isNextToVolunteer(room, nx, ny, 3 - d)) {
						return false;
					}
					break;
			}
		}
		return true;
	}
	
	// 빈 테이블을 기준으로 한번 더 탐색을 진행한다.
	private boolean isNextToVolunteer(char[][] room, int x, int y, int exclude) {
		for (int d = 0; d < 4; d++) {
			// 제외할 탐색 방향
			if (d == exclude) {
				continue;
			}
			int nx = x + dx[d];
			int ny = y + dy[d];
			// 탐색가능한 구간인지 확인
			if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) {
				continue;
			}
			if (room[ny][nx] == 'P') {
				return true;
			}
		}
		return false;
	}
}
