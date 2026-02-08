package programmers.level1.두_개_뽑아서_더하기;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P_68644_RE {
	
	public int[] solution(int[] numbers) {
		Set<Integer> set = new HashSet<>();
		
		// 서로 다른 인덱스에 있는 요소의 합 구해서 넣기
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				set.add(numbers[i] + numbers[j]);
			}
		}
		
		// set의 데이터를 배열로 옮긴 후 정렬
		int[] answer = new int[set.size()];
		int index = 0;
		for (int num : set) {
			answer[index++] = num;
		}
		
		Arrays.sort(answer);
		return answer;
	}
	
	
}
