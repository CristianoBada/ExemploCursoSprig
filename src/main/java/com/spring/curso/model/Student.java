package com.spring.curso.model;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class Student {
	private int id;
	private String name;
	public static List<Student> sudentList;
	
	static {
		studentRepository();
	}

	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Student(String name) {
		this.name = name;
	}

	public Student() {
	}
	
	private static void studentRepository() {
		sudentList = new ArrayList<Student>(asList(new Student(1, "Deku"), new Student(2, "Cristian")));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
