package programmers.level2.교점에_별_구하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Platform: Programmers
 * Problem: 87377
 * Title: 교점에 별 구하기
 * 정답률: 33%
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/87377
 * NOTE:
 */
public class P_87377 {
	
	// 1. n개의 line이 주어짐
	// 2. 모든 직선 쌍에 대해서 반복 필요 => 돌면서 교점 좌표를 구하여 정수인 것들만 반환 -> x, y축의 최소, 최대크기를 구하여, '.'로 채우기 -> 별채우기 -> 배열 반d환
	public String[] solution(int[][] line) {
		
		// 이중 반복문을 통해 직선과 직선 간의 교점 중 정수좌표를 가진 점을 리턴한다.
		List<Point> pointList = new ArrayList<>();
		for (int i = 0; i < line.length; i++) {
			for (int j = i + 1; j < line.length; j++) {
				Point point = getIntersection(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);
				if (point != null) {
					pointList.add(point);
				}
			}
		}
		
		Point maxPoint = getMaxPoint(pointList);
		Point minPoint = getMinPoint(pointList);
		
		int width  = (int) (maxPoint.x - minPoint.x) + 1;
		int height = (int) (maxPoint.y - minPoint.y) + 1;
		
		// 우선 구역 전체를 문자 '.'로 채운다.
		char[][] square = new char[height][width];
		for (char[] row : square) {
			Arrays.fill(row, '.');
		}
		
		// 교점 좌표엔 *를 채운다.
		// NOTE 최종 형태는 2차원 배열이라는 점 기억할 것 (xy축의 일반좌표로 생각x)
		for (Point targetPoint : pointList) {
			int x = (int) (targetPoint.x - minPoint.x);
			int y = (int)  (maxPoint.y - targetPoint.y);
			
			square[y][x] = '*';		// char타입은 ''
		}
		
		String[] result = new String[square.length];
		for (int i = 0; i < square.length; i++) {
			result[i] = new String(square[i]);
		}
		
		return result;
	}
	
	// 교점을 구해서 반환.
	private Point getIntersection(long a1, long b1, long c1, long a2, long b2, long c2) {
		// double형으로 계산. 계산에 따라 소수점도 나올 수 있기 때문.
		double x = (double) (b1 * c2 - b2 * c1) / (a1 * b2 - a2 * b1);
		double y = (double) (a2 * c1 - a1 * c2) / (a1 * b2 - a2 * b1);
		
		// 계산된 결과를 토대로 좌표가 정수로 구성된 게 아니면 null을 리턴한다.
		if (x % 1 != 0 || y % 1 != 0) {
			return null;
		}
		return new Point((long) x, (long) y);
	}
	
	// 최대값을 리턴
	private Point getMaxPoint(List<Point> points) {
		long x = Long.MIN_VALUE;
		long y = Long.MIN_VALUE;
		
		for (Point p : points) {
			if (p.x > x) {
				x = p.x;
			}
			if (p.y > y) {
				y = p.y;
			}
		}
		return new Point(x, y);
	}
	
	// 최소값을 리턴
	private Point getMinPoint(List<Point> points) {
		long x = Long.MAX_VALUE;
		long y = Long.MAX_VALUE;
		
		for (Point p : points) {
			if (p.x < x) {
				x = p.x;
			}
			if (p.y < y) {
				y = p.y;
			}
		}
		return new Point(x, y);
	}
	
	// 생성자 함수를 통해서 좌표 정보 초기화
	private static class Point {
		public final long x;        // 데이터를 나타내는 클래스이므로 final 키워드 사용
		public final long y;
		
		private Point(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}
	
}
