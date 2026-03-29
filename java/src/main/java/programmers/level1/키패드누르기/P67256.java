package programmers.level1.키패드누르기;


/**
 * Platform: Programmers
 * Problem: 67256
 * Title: 키패드누르기
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/67256
 */
public class P67256 {
	
	public String solution(int[] numbers, String hand) {
		StringBuilder answer = new StringBuilder();
		
		// 0~9까지 순서대로 배열 선언
		int[][] numpadPos = {
				{3, 1},        // 0
				{0, 0},        // 1
				{0, 1},        // 2
				{0, 2},        // ..
				{1, 0},
				{1, 1},
				{1, 2},
				{2, 0},
				{2, 1},
				{2, 2},        // 9
		};
		
		// 처음 시작 위치
		int[] curLeft = {3, 0};    // 별
		int[] curRight = {3, 2};    // 샵
		
		for (int num : numbers) {
			// 왼쪽
			if (num == 1 || num == 4 || num == 7) {
				answer.append("L");
				curLeft = numpadPos[num];    // 변경된 엄지손가락 위치
			}
			// 우측
			else if (num == 3 || num == 6 || num == 9) {
				answer.append("R");
				curRight = numpadPos[num];
			}
			// 가운데 (2, 5, 8, 0)
			else {
				int[] targetPos = numpadPos[num];
				// 현재 좌/우 손가락 기준에서 거리 측정 => 거리계산 후, 손가락 위치 이동할 것
				// NOTE 맨해튼 거리는 절대값 사용해야 함
				int leftDis = Math.abs(curLeft[0] - targetPos[0]) + Math.abs(curLeft[1] - targetPos[1]);        // 왼
				int rightDis = (curRight[0] - targetPos[0]) + (curRight[1] - targetPos[1]);        // 우
				
				if (leftDis < rightDis) {
					answer.append("L");
					curLeft = targetPos;
				} else if (rightDis < leftDis) {
					answer.append("R");
					curRight = targetPos;
				}
				// 거리가 동일한 경우 -> 주 손가락 사용
				else {
					if ("left".equals(hand)) {
						answer.append("L");
						curLeft = targetPos;        // 이동
					} else {
						answer.append("R");
						curRight = targetPos;
					}
				}
			}
			
		}
		return answer.toString();
	}
}
