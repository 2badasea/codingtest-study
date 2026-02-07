package programmers.level2.메뉴_리뉴얼;


import java.util.*;
import java.util.stream.Collectors;

/**
 * Platform: Programmers
 * Problem: 72411 {
 * Title: 메뉴_리뉴얼
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/72411
 */
public class P_72411 {
	
	// 재귀 메서드
	private void getCourses(char nextMenu,
							Set<String> selectedMenus,    // 현재까지 선택한 메뉴정보를 담음
							List<Set<String>> orderList,
							Map<Integer, List<Course>> courses) {
		
		int occurrences = (int) orderList.stream().
				filter(order -> order.containsAll(selectedMenus))
				.count();
		// 등장 횟수가 2미만인 건 구성을 하지 않는다.
		if (occurrences < 2) {
			return;
		}
		
		// 선택한 메뉴 구성이 코스요리를 구성하는 단품갯수와 일치해야 하는지 체크
		int size = selectedMenus.size();
		if (courses.containsKey(size)) {
			List<Course> courseList = courses.get(size);
			Course course = new Course(
					selectedMenus.stream().sorted().collect(Collectors.joining("")), occurrences
			);
			Course originCourse = courseList.get(0);
			if (originCourse.occurrences < occurrences) {
				courseList.clear();
				courseList.add(course);
			} else if (originCourse.occurrences == occurrences) {
				courseList.add(course);
			}
		}
		
		if (size >= 10) {
			return;
		}
		for (char menuChar = nextMenu; menuChar <= 'Z'; menuChar++) {
			String menu = String.valueOf(menuChar);
			selectedMenus.add(menu);
			getCourses((char) (menuChar + 1), selectedMenus, orderList, courses);
			selectedMenus.remove(menu);
		}
		
		
	}
	
	public String[] solution(String[] orders, int[] course) {
		List<Set<String>> orderList = Arrays.stream(orders)
				.map(String::chars)
				.map(charStream -> charStream.mapToObj(menu -> String.valueOf((char) menu))
						.collect(Collectors.toSet()))
				.collect(Collectors.toList());
		Map<Integer, List<Course>> courses = new HashMap<>();
		for (int length : course) {
			List<Course> list = new ArrayList<>();
			list.add(new Course("", 0));
			courses.put(length, list);
		}
		getCourses('A', new HashSet<>(), orderList, courses);
		
		return courses.values().stream()
				.filter(list -> list.get(0).occurrences > 0)
				.flatMap(List::stream)
				.map(c -> c.course)
				.sorted()
				.toArray(String[]::new);
		
	}
	
	// course 객체
	private static class Course {
		public final String course;
		public final int occurrences;
		
		public Course(String course, int occurrences) {
			this.course = course;                // 코스 구성
			this.occurrences = occurrences;        // 등장 횟수
		}
	}
	
}
