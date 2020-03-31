package com.spring.curso.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.spring.curso.model.Student;

public interface StudentRepository extends PagingAndSortingRepository<Student, Long>{
	List<Student> findByNameIgnoreCaseContaining(String name);
}
