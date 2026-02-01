package programmers.level1.모의고사;

import java.util.stream.IntStream;

/**
 * Platform: Programmers
 * Problem: 42840
 * Title: 모의고사
 * 정답률: 86%
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/42840
 * NOTE: 교재내용 풀이
 */
public class P_42840 {
	// 답지가 반복되면서, 각 수포자들의 답을 가져온다. 그리고 비교를 함으로써, 같다면
	private static final int[][] RULES = {
			{1, 2, 3, 4, 5},
			{2, 1, 2, 3, 2, 4, 2, 5},
			{3, 3, 1, 1, 2, 2, 4, 4, 5, 5},
	};
	
	// 수포자별로 선택한 답을 가져온다.
	private int getPickedByPeople(int people, int problemSeq) {
		int [] peopleAnswers = RULES[people];
		int index = problemSeq % peopleAnswers.length;
		return peopleAnswers[index];
	}
	
	
	public int[] solution(int[] answers) {
		int[] peoples = new int[3];
		int max = 0;
		
		// 채점시작
		for (int i = 0; i < answers.length; i++) {
			int pickedAnswer = answers[i];
			
			for (int j = 0; j < RULES.length; j++) {
				int currentAnswer = getPickedByPeople(j, i);
				if (currentAnswer == pickedAnswer) {
					peoples[j]++;
					if (peoples[j] > max) {
						max = peoples[j];
					}
				}
			}
		}
		
		final int maxCorrects = max;
		return IntStream.range(0, 3).filter(i -> peoples[i] == maxCorrects).map(i -> i + 1).toArray();
	}
}
