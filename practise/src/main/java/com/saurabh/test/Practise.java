package com.saurabh.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Practise {
	
	public static void main(String[] args) {
		
		Student student1 = new Student(1, "saurabh", " ", "lucknow", 30);
		Student student2 = new Student(2, "abhishek", " ", "bihar", 31);
		Student student3 = new Student(3, "pulkit", " ", "bangalore", 28);
		Student student4 = new Student(4, "lawrence", " ", "orrisa", 30);
		Student student5 = new Student(1, "saurabh", " ", "lucknow", 30);
		
		List<Student> students = new ArrayList<>();
		students.add(student1);
		students.add(student2);
		students.add(student3);
		students.add(student4);
		students.add(student5);
		
		//remove duplicates in object
		
		List<Student> listset = students.stream().distinct().collect(Collectors.toList());
		System.out.println("without dups" + listset);
		
		Map<Integer, Long> map = students.stream().filter(student -> student.getAge() > 28)
		.collect(Collectors.groupingBy(Student :: getAge, Collectors.counting()));
		System.out.println(map);
		
		students.sort(Comparator.comparing((Student s)-> s.getName()).thenComparing((Student s) -> s.getLocation()));
		System.out.println(students);
		
		//Map<Integer, Student> map2 = students.stream().collect(Collectors.toMap(Student :: getId, Function.identity()));
		//handle duplicate objects
		Map<Integer, Student> map3 = students.stream().collect(Collectors.toMap(Student :: getId, Function.identity(), (o1,o2) -> o1));
		System.out.println(map3);
		
		List<Integer> list1 = Arrays.asList(1, 2,3, 4);
		List<Integer> list2 = Arrays.asList(4,5,6,7,8);
		
		List<Integer> listmap = list1.stream().map(num -> num*2).collect(Collectors.toList());
		System.out.println(listmap);
		
		List<List<Integer>> lists = new ArrayList<>();
		lists.add(list1);
		lists.add(list2);
		
		List<Integer> listflat = lists.stream().flatMap(list -> list.stream()).collect(Collectors.toList());
		System.out.println(listflat);
		
	}

}
