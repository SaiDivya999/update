package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee1{
	int empid;
	String name;
	int age;
	
	public Employee1() {
}
	
	public Employee1(int empid, String name, int age) {
		super();
		this.empid = empid;
		this.name = name;
		this.age = age;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
public class New {
	public static void main(String[] args) {
		List<Employee1> empList = new ArrayList<Employee1>();
		
		Employee1 e = new Employee1(121, "Cheryl", 50);
		
		empList.add(e);
		
		empList.add(new Employee1(122, "Betty", 60));
		empList.add(new Employee1(123, "sarah", 40));
		empList.add(new Employee1(124, "veronica", 70));
		
		// converting list to map
       Map<Integer, String> empHm = new HashMap<Integer, String>();
       
       // 1. using normal java approach
       for(Employee1 emp: empList) {
    	   empHm.put(emp.getAge(),  emp.getName());
       }
       System.out.println(empHm);
       
       // 2. using java 8 features
       // converting list to map
       LinkedHashMap<Integer, String> lmap = empList.stream().collect(Collectors.toMap(Employee1 :: getAge, Employee1 :: getName,(k,v) -> k+" " + v, LinkedHashMap :: new));

	  lmap.forEach((k,v) -> System.out.println("Age: " +k + " Name: " + v));
	
	  // converting Map(key, value both) data to Collection(key or value only one) data
	  // converting into list
	  
	  List<Integer> mtoc = empHm.entrySet().stream().map(k -> k.getKey()).collect(Collectors.toList());
	  
	  mtoc.forEach(System.out :: println);
	  
List<String> mtoc1 = empHm.entrySet().stream().map(v -> v.getValue()).collect(Collectors.toList());
	  
	  mtoc1.forEach(System.out :: println);
	}
}