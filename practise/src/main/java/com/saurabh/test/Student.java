package com.saurabh.test;

import java.util.Objects;

public class Student {
	
	int id;
	String name;
	String email;
	String location;
	int age;
	
	public Student(int id, String name, String email, String location, int age) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.location = location;
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", location=" + location + ", age=" + age
				+ "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(age, email, id, location, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return age == other.age && Objects.equals(email, other.email) && id == other.id
				&& Objects.equals(location, other.location) && Objects.equals(name, other.name);
	}
	
	

}
