package com.saurabh.designpatterns;
import java.util.List;

public class PrototypePatternTest {

	public static void main(String[] args) {
		
		Employees emp = new Employees();
		emp.loadData();
		
		Employees emp1 = (Employees) emp.clone();
		Employees emp2 = (Employees) emp.clone();
		
		List<String> list1 = emp1.getEmpList();
		list1.add("Karen");
		List<String> list2 = emp2.getEmpList();
		list2.remove("John");
		
		System.out.println("emp list "+emp.getEmpList());
		System.out.println("emp list1 "+emp1.getEmpList());
		System.out.println("emp list2 "+emp2.getEmpList());
	}

}
