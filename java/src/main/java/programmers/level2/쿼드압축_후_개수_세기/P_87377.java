package programmers.level2.쿼드압축_후_개수_세기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Platform: Programmers
 * Problem: 68936
 * Title: 쿼드압축 후 개수세기
 * 정답률: 56%
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/68936
 * NOTE:
 */
public class P_87377 {
	// 상태, 종료조건, 점화식
	
	public int[] solution(int[][] arr) {
		Count count = count(0, 0, arr.length, arr);
		return new int[] {count.zero, count.one};
	}
	
	// 0과 1의 개수를 한 번에 담을 수 있는 클래스 선언
	private static class Count {
		public final int zero;
		public final int one;
		
		public Count(int zero, int one) {
			this.zero = zero;
			this.one = one;
		}
		
		public Count add(Count other) {
			return new Count(zero + other.zero, one + other.one);
		}
	}
	
	// 하나의 상태가 나타내는 부분 문제를 해결할 수 있는 재귀 메서드 작성
	private Count count(int offsetX, int offsetY, int size, int[][] arr) {
		
		int h = size / 2;
		// 종료 조건(정사각형 영역 안의 모든 원소가 같은 값을 가질 때)
		for (int x = offsetX; x < offsetX + size; x++) {
			for (int y = offsetY; y < offsetY + size; y++) {
				if (arr[y][x] != arr[offsetY][offsetX]) {
					// 원소가 섞여 있는 경우 반환값
					return count(offsetX, offsetY, h, arr)
							.add(count(offsetX + h, offsetY, h , arr))
							.add(count(offsetX, offsetY + h, h , arr))
							.add(count(offsetX + h, offsetY + h, h , arr));
				}
			}
		}
		// for문을 끝까지 돌았다는 것은 모든 영역의 값이 같았다는 것
		if (arr[offsetY][offsetX] == 1) {
			return new Count(0, 1);
		}
		return new Count(1, 0);
	}
	
	
}
