package programmers.level1.두_개_뽑아서_더하기;


import java.util.*;

/**
 * Platform: Programmers
 * Problem: 68644
 * Title: 두_개_뽑아서_더하기
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/68644
 */
public class P_68644 {
	public int[] solution(int[] numbers) {
		
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				int res = numbers[i] + numbers[j];
				// 중복을 검증할 때는 HashSet 자료구조를 사용하면 더 효율적 & set도 컬렉션이기 때문에 sort()메서드 가능.
				if (!list.contains(res)) {
					list.add(res);
				}
			}
		}
		return list.stream().mapToInt(i -> i).toArray();
		
		// HashSet 활용해보기
		// Set<Integer> set = new HashSet<>();
		// for (int i = 0; i < numbers.length - 1; i++) {
		// 	for (int j = i + 1; j < numbers.length; j++) {
		// 		int res = numbers[i] + numbers[j];
		// 		set.add(res);
		// 	}
		// }
		// return set.stream().sorted().mapToInt(Integer::intValue).toArray();
		
	}
	
}
