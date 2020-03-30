package com.spring.curso.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import static java.util.Arrays.asList;

@Entity
public class Student extends AbstractEntity {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
