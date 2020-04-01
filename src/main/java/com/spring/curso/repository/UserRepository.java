package com.spring.curso.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.spring.curso.model.User;


public interface UserRepository extends PagingAndSortingRepository<User, Long>{
	User findByUsername(String username);
}
