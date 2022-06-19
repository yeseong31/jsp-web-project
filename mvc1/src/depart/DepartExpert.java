package depart;

import java.util.*;

public class DepartExpert {
	
	public List<String> advice(String depart) {
		List<String> list = new ArrayList<>();

		switch (depart) {
			case "c" -> {
				list.add("프로그램 기초를 배우는 과정");
				list.add("C 언어 자체는 어려우나 수업은 기초 과정만 배워서 매우 쉽습니다.");
			}
			case "java" -> {
				list.add("객체지향 프로그램 기초를 배우는 과정");
				list.add("객체지향이라는 개념이 어려워서 많이 힘들어 하는 과정입니다.");
			}
			case "python" -> {
				list.add("프로그램 기초를 배우는 과정");
				list.add("C 언어보다 쉽고 직관적인 언어로 프로그램 언어 중에 가장 쉬운 언어입니다.");
			}
			case "go" -> {
				list.add("서버 프로그램을 관리하는 언어");
				list.add("요즘은 서버 프로그램으로 많이 사용하고 있는 언어입니다.");
			}
			default -> list.add("준비되지 않았습니다.");
		}
		
		return list;
	}

}
