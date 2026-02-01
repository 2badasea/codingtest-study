package programmers.level2.카펫;

/**
 * Platform: Programmers
 * Problem: 42842
 * Title: 카펫
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/42842
 * NOTE: 교재내용 풀이
 */
public class P_42842 {
	public int[] solution(int brown, int yellow) {
		int[] answer = {};
		// brown + yellow = brown * yellow
		// x >= y
		// 2x + 2(y-2) = brown
		// 2x + 2y - 4 => (x + y - 2) * 2 = brown
		// xy - (x + y - 2) * 2 = yellow
		// width, height
		// brown = 2width + 2(height - 2) = 2 ( width + heigth - 2 )
		// yellow = width * height - (width + height -2) * 2;
		for (int width = 3; width <= 5000; width++) {
			for (int height = 3; height <= width; height++) {
				int boundary = (width + height - 2) * 2;
				int center = (width * height) - boundary;
				if (brown == boundary && yellow == center) {
					return new int[]{width, height};
				}
				
			}
		}
		return null;
	}
	
}
