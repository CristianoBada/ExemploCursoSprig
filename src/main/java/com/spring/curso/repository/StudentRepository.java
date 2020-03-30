package com.spring.curso.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.spring.curso.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long>{
	List<Student> findByNameIgnoreCaseContaining(String name);
}
