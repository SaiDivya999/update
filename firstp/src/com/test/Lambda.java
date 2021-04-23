package com.test;

import java.util.List;
import java.util.ArrayList;

class Employee {
	int empid;
	String name;
	int age;
	public Employee () {
		
	}
	public Employee(int empid, String name, int age) {
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
public class Lambda {
	public static void main(String[] args) {
		List<Employee> empList = new ArrayList<Employee>();
		//List is an interface.we cannot create an object.
		Employee e = new Employee(45,"Harsha", 25);
		empList.add(e);
		empList.add(new Employee(12,"Bindu",19));
		empList.add(new Employee(42,"Surya", 20));
		empList.add(new Employee(23,"Anitha",23));
		for(Employee emp:empList) {
		//	System.out.println(emp.getEmpid()+" "+emp.getName()+" "+emp.getAge());
			if(emp.getAge()>20) {
				System.out.println(emp.getName()+" "+emp.getAge());
			}
		}
		// Stream api java 8 feature
		empList.stream().filter(emp -> emp.getAge() > 20).forEach(emp -> System.out.println("Emp age : " + e.getAge() + " Emp name : " + e.getName()));
		
	}
}
